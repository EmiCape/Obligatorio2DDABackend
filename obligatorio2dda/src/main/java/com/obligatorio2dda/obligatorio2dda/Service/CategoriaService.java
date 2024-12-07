package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;

import com.obligatorio2dda.obligatorio2dda.Entity.Categoria;

public interface CategoriaService {
    public Categoria agregar(Categoria c) throws Exception;
    public boolean eliminar(int id) throws Exception;
    public Categoria modificar(Categoria c) throws Exception;
    public Categoria conseguir(int id)throws Exception;
    public List<Categoria> conseguir();

    
}
