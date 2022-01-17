package com.roberto.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.petshop.domain.Categoria;
import com.roberto.petshop.repositories.CategoriaRepository;
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
	

}
