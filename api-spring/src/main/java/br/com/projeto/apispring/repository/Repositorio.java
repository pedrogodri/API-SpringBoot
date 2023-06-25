package br.com.projeto.apispring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.apispring.model.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    
}
