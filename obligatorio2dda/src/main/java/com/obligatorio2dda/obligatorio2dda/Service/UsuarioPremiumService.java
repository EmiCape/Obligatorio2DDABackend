package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;

import com.obligatorio2dda.obligatorio2dda.Entity.usuarioPremium;

public interface UsuarioPremiumService {
    public usuarioPremium agregarUsuarioPremium(usuarioPremium u)throws Exception;
    public boolean eliminarUsuarioPremium(int id)throws Exception;
    public usuarioPremium modificarUsuarioPremium(usuarioPremium u)throws Exception;
    public usuarioPremium conseguirUsuarioPremium(int id)throws Exception;
    public List<usuarioPremium> conseguirUsuarioPremium();
}
