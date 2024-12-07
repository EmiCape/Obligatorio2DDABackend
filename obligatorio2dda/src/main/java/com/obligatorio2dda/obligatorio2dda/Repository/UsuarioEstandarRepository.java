package com.obligatorio2dda.obligatorio2dda.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obligatorio2dda.obligatorio2dda.Entity.usuarioEstandar;

@Repository
public interface UsuarioEstandarRepository extends JpaRepository<usuarioEstandar, Integer>{
    
}
