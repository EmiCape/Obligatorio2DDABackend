package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;

import com.obligatorio2dda.obligatorio2dda.Entity.Videojuego;

public interface VideojuegoService {
    public Videojuego agregar(Videojuego v) throws Exception;
    public boolean eliminar(int id)throws Exception;
    public Videojuego modificar(Videojuego v)throws Exception;
    public Videojuego conseguir(int id)throws Exception;
    public List<Videojuego> conseguir(); 
    public List<Videojuego> filtrarPorStock(int cantCopias)throws Exception;

}
