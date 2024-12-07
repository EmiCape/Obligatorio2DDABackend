package com.obligatorio2dda.obligatorio2dda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obligatorio2dda.obligatorio2dda.Entity.usuarioPremium;

@Repository
public interface UsuarioPremiumRepository extends JpaRepository<usuarioPremium, Integer>{
    
}
