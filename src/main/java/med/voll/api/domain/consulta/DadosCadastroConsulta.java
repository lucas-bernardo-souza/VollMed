package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.DadosCadastroMedico;
import med.voll.api.domain.paciente.DadosCadastroPaciente;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosCadastroConsulta(
        @NotNull
        DadosCadastroPaciente paciente,
        @NotNull
        DadosCadastroMedico medico,
        @NotBlank
        LocalDate dataConsulta,
        @NotBlank
        LocalTime horaConsulta
        ) {
}
