package com.roberto.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.roberto.petshop.domain.Servico;
import com.roberto.petshop.repositories.ServicoRepository;
import com.roberto.petshop.service.exceptions.DataIntegrityException;
import com.roberto.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ServicoService {
	
	/*Injeção de dependencia */
	@Autowired
	private ServicoRepository repo;
	
	/*Retorna para o Controller*/
	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + ", Tipo: " + Servico.class.getName()));
		
	}
	
	public Servico insert(Servico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Servico update(Servico obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new DataIntegrityException("Servico possui Produtos, Não foi possível deletar!");
		}
	}
	

}
