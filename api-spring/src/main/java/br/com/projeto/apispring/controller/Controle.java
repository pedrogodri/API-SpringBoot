package br.com.projeto.apispring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apispring.model.Pessoa;
import br.com.projeto.apispring.repository.Repositorio;

@RestController
public class Controle {
    
    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa p) {
        return acao.save(p);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar() {
        return acao.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarCodigo(@PathVariable Integer codigo) {
        return acao.findByCodigo(codigo);
    }

    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa p) {
        return acao.save(p);
    }

    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable Integer codigo) {
        Pessoa p = selecionarCodigo(codigo);
        acao.delete(p);
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
}
