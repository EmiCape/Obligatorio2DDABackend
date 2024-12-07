package com.obligatorio2dda.obligatorio2dda.Repository;

import org.springframework.stereotype.Repository;
import com.obligatorio2dda.obligatorio2dda.Entity.Venta;
import com.obligatorio2dda.obligatorio2dda.Entity.persona;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
    List<Venta> findByUsuario(persona usuario);
    List<Venta> findByFechaCompra(LocalDate fecha);
}
