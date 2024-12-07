package com.obligatorio2dda.obligatorio2dda.Service;

import java.time.LocalDate;
import java.util.List;

import com.obligatorio2dda.obligatorio2dda.Entity.Venta;
import com.obligatorio2dda.obligatorio2dda.Entity.persona;

public interface VentaService {
     public Venta agregar(Venta v) throws Exception;
    public boolean eliminar(int id)throws Exception;
    public Venta modificar(Venta ue)throws Exception;
    public Venta conseguir(int id)throws Exception;
    public List<Venta> conseguir();
    public List<Venta> obtenerVentasPorUsuario(persona usuario);
    public List<Venta> obtenerVentasPorFecha(LocalDate fecha);

}
