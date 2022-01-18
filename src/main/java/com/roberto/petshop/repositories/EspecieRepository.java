package com.roberto.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roberto.petshop.domain.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {

}
