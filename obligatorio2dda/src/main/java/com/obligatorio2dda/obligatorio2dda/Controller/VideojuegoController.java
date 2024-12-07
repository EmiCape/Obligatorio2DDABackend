package com.obligatorio2dda.obligatorio2dda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.obligatorio2dda.obligatorio2dda.Entity.Videojuego;
import com.obligatorio2dda.obligatorio2dda.Service.VideojuegoService;

@Controller
@RequestMapping("/videojuego")
@CrossOrigin(origins = "http://localhost:3000")
public class VideojuegoController {
    
    @Autowired
    private VideojuegoService videojuegoService;


    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Videojuego v) {
        try {
            Videojuego videojuegoAgregado = videojuegoService.agregar(v);
            return ResponseEntity.status(HttpStatus.CREATED).body(videojuegoAgregado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar el videojuego: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        try {
            boolean eliminado = videojuegoService.eliminar(id);
            if (eliminado) {
                return ResponseEntity.status(HttpStatus.OK).body("Videojuego eliminado");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el videojuego: " + e.getMessage());
        }
    }


    @PutMapping
    public ResponseEntity<?> modificar(@RequestBody Videojuego v) {
        try {
            Videojuego videojuegoModificado = videojuegoService.modificar(v);
            if (videojuegoModificado != null) {
                return ResponseEntity.status(HttpStatus.OK).body(videojuegoModificado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al modificar el videojuego: " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> conseguir(@PathVariable int id) {
        try {
            Videojuego videojuego = videojuegoService.conseguir(id);
            if (videojuego != null) {
                return ResponseEntity.status(HttpStatus.OK).body(videojuego);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Videojuego no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener el videojuego: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> conseguir() {
        try {
            List<Videojuego> videojuegos = videojuegoService.conseguir();
            return ResponseEntity.status(HttpStatus.OK).body(videojuegos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener los videojuegos: " + e.getMessage());
        }
    }


    @GetMapping("/filtrarPorStock")
    public ResponseEntity<?> filtrarPorStock(@RequestParam int cantCopias) {
        try {
            List<Videojuego> videojuegos = videojuegoService.filtrarPorStock(cantCopias);
            if (videojuegos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontraron videojuegos con esa cantidad de copias");
            }
            return ResponseEntity.status(HttpStatus.OK).body(videojuegos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al filtrar videojuegos: " + e.getMessage());
        }
    }
}
