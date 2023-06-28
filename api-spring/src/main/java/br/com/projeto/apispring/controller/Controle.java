package br.com.projeto.apispring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apispring.model.Pessoa;
import br.com.projeto.apispring.repository.Repositorio;
import br.com.projeto.apispring.service.Servico;

@RestController
public class Controle {
    
    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa p) {
        return servico.cadastrar(p);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selecionar() {
        return servico.selecionar();
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarCodigo(@PathVariable Integer codigo) {
        return servico.selecionarCodigo(codigo);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa p) {
        return servico.editar(p);
    }

    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable Integer codigo) {
        //Pessoa p = selecionarCodigo(codigo);
        //acao.delete(p);
    }

    @GetMapping("/api/contador")
    public Long contador() {
        return acao.count();
    } 

    @GetMapping("/api/odernarNomes")
    public List<Pessoa> ordenarNomes() {
        return acao.findByOrderByNome();
    }

    @GetMapping("/api/ordenarNomesIdade/{nome}")
    public List<Pessoa> ordenarNomesByIdade(@PathVariable String nome) {
        return acao.findByNomeOrderByIdade(nome);
    }

    @GetMapping("/api/nomeContem/{termo}")
    public List<Pessoa> nomeContem(@PathVariable String termo) {
        return acao.findByNomeContaining(termo);
    }

    @GetMapping("/api/iniciaNome/{termo}")
    public List<Pessoa> iniciaNome(@PathVariable String termo) {
        return acao.findByNomeStartsWith(termo);
    }

    @GetMapping("/api/finalizaNome/{termo}")
    public List<Pessoa> finalizaNome(@PathVariable String termo) {
        return acao.findByNomeEndsWith(termo);
    }

    @GetMapping("/api/somaIdades")
    public Integer somaIdades() {
        return acao.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual/{idade}")
    public List<Pessoa> idadeMaiorIgual(@PathVariable Integer idade) {
        return acao.idadeMaiorIgual(idade);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);    
    }
}
