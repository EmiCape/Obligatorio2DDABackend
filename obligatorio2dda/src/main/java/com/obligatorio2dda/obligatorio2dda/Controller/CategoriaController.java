package com.obligatorio2dda.obligatorio2dda.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.obligatorio2dda.obligatorio2dda.Entity.Categoria;
import com.obligatorio2dda.obligatorio2dda.Repository.CategoriaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @PostMapping
    public ResponseEntity<?> add(@RequestBody Categoria categoria) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al crear la categoría");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            categoriaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al eliminar la categoría");
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Categoria categoria) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al actualizar la categoría");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findById(id).orElseThrow(() -> new Exception("Categoría no encontrada")));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al obtener la categoría: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> list() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al obtener las categorías");
        }
    }
}
