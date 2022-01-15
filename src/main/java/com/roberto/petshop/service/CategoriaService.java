package com.roberto.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.petshop.domain.Categoria;
import com.roberto.petshop.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	/*Injeção de dependencia */
	@Autowired
	private CategoriaRepository repo;
	
	/*Retorna para o Controller*/
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
	

}
