package com.obligatorio2dda.obligatorio2dda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obligatorio2dda.obligatorio2dda.Entity.Videojuego;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego,Integer>  {
    
    List<Videojuego> findByCantCopiasLessThan(int cantCopias);


}
