package com.obligatorio2dda.obligatorio2dda.Repository;

import org.springframework.stereotype.Repository;

import com.obligatorio2dda.obligatorio2dda.Entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
