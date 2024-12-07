package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.Entity.usuarioEstandar;
import com.obligatorio2dda.obligatorio2dda.Repository.UsuarioEstandarRepository;
import com.obligatorio2dda.obligatorio2dda.AppException;

@Service
public class UsuarioEstandarServiceImpl implements UsuarioEstandarService {

    @Autowired
    UsuarioEstandarRepository usuarioEstandarRepository;

    public usuarioEstandar agregar(usuarioEstandar ue) throws AppException {
        if (usuarioEstandarRepository.existsById(ue.getId())) {
            throw new AppException("Ya existe un usuario con el mismo ID");
        }
        return usuarioEstandarRepository.save(ue);
    }

    public boolean eliminar(int id) throws AppException {
        Optional<usuarioEstandar> usuario = usuarioEstandarRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioEstandarRepository.deleteById(id);
            return true;
        } else {
            throw new AppException("No se encontró el usuario con el ID " + id);
        }
    }

    public usuarioEstandar modificar(usuarioEstandar ue) throws AppException {
        Optional<usuarioEstandar> usuarioExistente = usuarioEstandarRepository.findById(ue.getId());
        if (usuarioExistente.isPresent()) {
            return usuarioEstandarRepository.save(ue);
        } else {
            throw new AppException("No se encontró el usuario con el ID " + ue.getId());
        }
    }

    public usuarioEstandar conseguir(int id) throws AppException {
        Optional<usuarioEstandar> usuario = usuarioEstandarRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new AppException("No se encontró el usuario con el ID " + id);
        }
    }

    public List<usuarioEstandar> conseguir() {
        return usuarioEstandarRepository.findAll();
    }
}
