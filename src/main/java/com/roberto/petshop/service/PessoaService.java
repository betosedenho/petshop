package com.roberto.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.petshop.domain.Pessoa;
import com.roberto.petshop.repositories.PessoaRepository;
import com.roberto.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PessoaService {
	
	/*Injeção de dependencia */
	@Autowired
	private PessoaRepository repo;
	
	/*Retorna para o Controller*/
	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
		
	}
	

}
