package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.DadosAutenticacao;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosAutenticacao dados, UriComponentsBuilder uriBuilder){
        // Verificar se o usuário já está cadastrado
        if(repository.findByLogin(dados.login()) != null){
            return ResponseEntity.badRequest().body("Usuário já existe");
        }
        // criptografia da senha
        String senhaCriptografada = passwordEncoder.encode(dados.senha());

        // Cria novo usuario com a senha criptografada
        Usuario novoUsuario = new Usuario(dados.login(), senhaCriptografada);

        repository.save(novoUsuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(novoUsuario.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
