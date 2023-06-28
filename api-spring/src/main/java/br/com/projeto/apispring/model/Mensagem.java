package br.com.projeto.apispring.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Mensagem {
    private String mensagem;
}
