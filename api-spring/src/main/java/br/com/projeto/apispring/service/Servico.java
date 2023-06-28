package br.com.projeto.apispring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.apispring.model.Mensagem;
import br.com.projeto.apispring.model.Pessoa;
import br.com.projeto.apispring.repository.Repositorio;

@Service
public class Servico {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;


    // Método para cadastrar pessoas
    public ResponseEntity<?> cadastrar(Pessoa obj) {
        if(obj.getNome().equals("")) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    // Método para selecionar pessoas
    public ResponseEntity<?> selecionar() {
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }
}
