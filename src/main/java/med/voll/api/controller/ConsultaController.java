package med.voll.api.controller;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAtualizacaoConsulta;
import med.voll.api.domain.consulta.DadosCadastroConsulta;
import med.voll.api.domain.consulta.DadosListagemConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    private ConsultaRepository repository;

    public ResponseEntity cadastrar(DadosCadastroConsulta dados){

        return ResponseEntity.ok().build();
    }

    public ResponseEntity atualizar(DadosAtualizacaoConsulta dados){

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Page<DadosListagemConsulta>> listar(){


    }

    public ResponseEntity excluir(Long id){

        return ResponseEntity.noContent().build();
    }

}
