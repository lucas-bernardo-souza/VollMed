package med.voll.api.domain.consulta;

import java.time.LocalDateTime;
// Dados de resposta
public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
