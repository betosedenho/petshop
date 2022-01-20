package com.roberto.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.roberto.petshop.domain.Categoria;
import com.roberto.petshop.repositories.CategoriaRepository;
import com.roberto.petshop.service.exceptions.DataIntegrityException;
import com.roberto.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {
	
	/*Injeção de dependencia */
	@Autowired
	private CategoriaRepository repo;
	
	/*Retorna para o Controller*/
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + ", Tipo: " + Categoria.class.getName()));
		
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
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
			throw new DataIntegrityException("Categoria possui Produtos, Não foi possível deletar!");
		}
	}

}
