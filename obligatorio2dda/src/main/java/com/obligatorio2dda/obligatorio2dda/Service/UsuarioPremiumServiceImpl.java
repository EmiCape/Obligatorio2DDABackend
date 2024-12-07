package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.Entity.usuarioPremium;
import com.obligatorio2dda.obligatorio2dda.Repository.UsuarioPremiumRepository;
import com.obligatorio2dda.obligatorio2dda.AppException;

@Service
public class UsuarioPremiumServiceImpl implements UsuarioPremiumService {
    
    @Autowired
    UsuarioPremiumRepository usuarioPremiumRepository;

    public usuarioPremium agregarUsuarioPremium(usuarioPremium u) throws AppException {
 
        if (usuarioPremiumRepository.existsById(u.getId())) {
            throw new AppException("Ya existe un usuario premium con el mismo ID");
        }
        return usuarioPremiumRepository.save(u);
    }

    public boolean eliminarUsuarioPremium(int id) throws AppException {
        Optional<usuarioPremium> usuario = usuarioPremiumRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioPremiumRepository.deleteById(id);
            return true;
        } else {
            throw new AppException("No se encontró el usuario premium con el ID " + id);
        }
    }

    public usuarioPremium modificarUsuarioPremium(usuarioPremium u) throws AppException {
        Optional<usuarioPremium> usuarioExistente = usuarioPremiumRepository.findById(u.getId());
        if (usuarioExistente.isPresent()) {
            return usuarioPremiumRepository.save(u);
        } else {
            throw new AppException("No se encontró el usuario premium con el ID " + u.getId());
        }
    }

    public usuarioPremium conseguirUsuarioPremium(int id) throws AppException {
        Optional<usuarioPremium> usuario = usuarioPremiumRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new AppException("No se encontró el usuario premium con el ID " + id);
        }
    }

    public List<usuarioPremium> conseguirUsuarioPremium() {
        return usuarioPremiumRepository.findAll();
    }
}
