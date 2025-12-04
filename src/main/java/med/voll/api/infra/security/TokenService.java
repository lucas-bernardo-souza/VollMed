package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){
        try {
            // Algoritmo utilizado para fazer assinatura digital do token
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    // Issuer é a identificação de quem está gerando esse token
                    .withIssuer("API Voll.med")
                    // Identificação do proprietário do token
                    .withSubject(usuario.getLogin())
                    // esse metodo pode ser chamado várias vezes e adiciona elementos do tipo chave : valor
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
           throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    // Método que valida o token, se tiver válido ele recupera o subject dentro do token
    public String getSubject(String tokenJWT){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API Voll.med")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado");
        }
    }

    public Instant dataExpiracao(){
        // Pega a data e hora atual soma duas horas e converte para o objeto instant
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
