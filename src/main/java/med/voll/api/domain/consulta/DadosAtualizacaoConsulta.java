package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.DadosCadastroMedico;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosAtualizacaoConsulta(
        @NotNull
        Long id,
        LocalDate dataConsulta,
        LocalTime horaConsulta,
        DadosCadastroMedico medico
) {
}
