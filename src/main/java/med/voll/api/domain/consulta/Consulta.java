package med.voll.api.domain.consulta;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    private Long id;
    @ManyToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name="medico_id")
    private Medico medico;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private Boolean ativo;

    public Consulta(@Valid DadosCadastroConsulta dados){
        this.paciente = new Paciente(dados.paciente());
        this.medico = new Medico(dados.medico());
        this.dataConsulta = dados.dataConsulta();
        this.horaConsulta = dados.horaConsulta();
        this.ativo = true;
    }

    public void atualizar(@Valid DadosAtualizacaoConsulta dados){
        if(dados.dataConsulta() != null){
            this.dataConsulta = dados.dataConsulta();
        }
        if(dados.horaConsulta() != null){
            this.horaConsulta = dados.horaConsulta();
        }
        if(dados.medico() != null){
            this.medico = new Medico(dados.medico());
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
