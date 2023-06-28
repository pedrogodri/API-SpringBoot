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

    // Método para selecionar pessoas através do código
    public ResponseEntity<?> selecionarCodigo(Integer codigo) {
         if(acao.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("Não foi enconttrada nenhuma pessoa");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
         } else {
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
         }
    }

    // Método para editar dados
    public ResponseEntity<?> editar(Pessoa p) {
        if(acao.countByCodigo(p.getCodigo()) == 0) {
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        } else if(p.getNome().equals("")) {
            mensagem.setMensagem("Necessário informar um nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(p.getIdade() < 0) {
            mensagem.setMensagem("Necessário informar uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(p), HttpStatus.OK);
        }
    }

    // Método para remover registros
    public ResponseEntity<?> remover(Integer codigo) {
        if(acao.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        } else {
            Pessoa p = acao.findByCodigo(codigo);
            acao.delete(p);
            mensagem.setMensagem("Pessoa removida com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
