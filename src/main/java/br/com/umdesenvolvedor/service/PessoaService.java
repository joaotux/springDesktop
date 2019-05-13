package br.com.umdesenvolvedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.umdesenvolvedor.model.Pessoa;
import br.com.umdesenvolvedor.repository.PessoaRep;

@Service
public class PessoaService {

	@Autowired
	private PessoaRep pessoas;
	
	public Pessoa salvar(Pessoa pessoa) {
		try {
			
			pessoa = pessoas.save(pessoa);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return pessoa;
	}
}
