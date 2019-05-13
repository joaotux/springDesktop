package br.com.umdesenvolvedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.umdesenvolvedor.model.Pessoa;

public interface PessoaRep extends JpaRepository<Pessoa, Long> {

}
