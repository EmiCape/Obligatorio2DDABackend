package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.Entity.Videojuego;
import com.obligatorio2dda.obligatorio2dda.Repository.VideojuegoRepository;
import com.obligatorio2dda.obligatorio2dda.AppException;  

@Service
public class VideoJuegoServiceImpl implements VideojuegoService {

    @Autowired
    VideojuegoRepository videojuegoRepository;

   
    public Videojuego agregar(Videojuego v) throws AppException {
      
        if (videojuegoRepository.existsById(v.getId())) {
            throw new AppException("Ya existe un videojuego con el id: " + v.getId());
        }
        return videojuegoRepository.save(v);
    }

    
    public boolean eliminar(int id) throws AppException {
        Optional<Videojuego> videojuego = videojuegoRepository.findById(id);
        if (videojuego.isPresent()) {
            videojuegoRepository.deleteById(id);
            return true;
        } else {
            throw new AppException("No se encontró el videojuego con ID: " + id);
        }
    }


    public Videojuego modificar(Videojuego v) throws AppException {
        if (videojuegoRepository.findById(v.getId()).isPresent()) {
            return videojuegoRepository.save(v);
        } else {
            throw new AppException("No se encontró el videojuego con ID: " + v.getId());
        }
    }

    public Videojuego conseguir(int id) throws AppException {
        Optional<Videojuego> videojuego = videojuegoRepository.findById(id);
        if (videojuego.isPresent()) {
            return videojuego.get();
        } else {
            throw new AppException("No se encontró el videojuego con ID: " + id);
        }
    }


    public List<Videojuego> conseguir() {
        return videojuegoRepository.findAll();
    }

    
    @Override
    public List<Videojuego> filtrarPorStock(int cantCopias) throws AppException {
        List<Videojuego> videojuegos = videojuegoRepository.findByCantCopiasLessThan(cantCopias);
        if (videojuegos.isEmpty()) {
            throw new AppException("No hay videojuegos con menos de " + cantCopias + " copias disponibles.");
        }
        return videojuegos;
    }
}
