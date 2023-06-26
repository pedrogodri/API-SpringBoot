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
import org.springframework.web.service.annotation.PutExchange;

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

    @GetMapping("")
    public String mensagem() {
        return "Hello World";
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Seja bem vindo(a)";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem vindo(a) " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }
}
