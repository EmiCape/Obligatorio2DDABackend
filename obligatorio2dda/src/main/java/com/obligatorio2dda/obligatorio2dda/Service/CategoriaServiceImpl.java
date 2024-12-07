package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.Entity.Categoria;
import com.obligatorio2dda.obligatorio2dda.Repository.CategoriaRepository;
import com.obligatorio2dda.obligatorio2dda.AppException;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria agregar(Categoria c) throws AppException {
       
        if (categoriaRepository.existsById(c.getId())) {
            throw new AppException("Ya existe una categoría con el mismo ID");
        }
        return categoriaRepository.save(c);
    }

    public boolean eliminar(int id) throws AppException {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);
            return true;
        } else {
            throw new AppException("No se encontró la categoría con el ID " + id);
        }
    }

    public Categoria modificar(Categoria c) throws AppException {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(c.getId());
        if (categoriaExistente.isPresent()) {
            return categoriaRepository.save(c);
        } else {
            throw new AppException("No se encontró la categoría con el ID " + c.getId());
        }
    }

    public Categoria conseguir(int id) throws AppException {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        } else {
            throw new AppException("No se encontró la categoría con el ID " + id);
        }
    }

    public List<Categoria> conseguir() {
        return categoriaRepository.findAll();
    }
}
