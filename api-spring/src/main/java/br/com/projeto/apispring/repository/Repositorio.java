package br.com.projeto.apispring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.apispring.model.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    
    List<Pessoa> findAll();
    Pessoa findByCodigo(Integer codigo);
    List<Pessoa> findByOrderByNome();
    List<Pessoa> findByNomeOrderByIdade(String nome);
}
