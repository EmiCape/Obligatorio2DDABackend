package com.obligatorio2dda.obligatorio2dda.Repository;

import com.obligatorio2dda.obligatorio2dda.Entity.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<persona, Integer> {

}
