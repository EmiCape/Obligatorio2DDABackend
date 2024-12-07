package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;

import com.obligatorio2dda.obligatorio2dda.Entity.usuarioEstandar;

public interface UsuarioEstandarService {
    public usuarioEstandar agregar(usuarioEstandar ue) throws Exception;
    public boolean eliminar(int id)throws Exception;
    public usuarioEstandar modificar(usuarioEstandar ue)throws Exception;
    public usuarioEstandar conseguir(int id)throws Exception;
    public List<usuarioEstandar> conseguir();
}
