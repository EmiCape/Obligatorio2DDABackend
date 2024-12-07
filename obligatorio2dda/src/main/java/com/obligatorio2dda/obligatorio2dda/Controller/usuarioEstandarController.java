package com.obligatorio2dda.obligatorio2dda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obligatorio2dda.obligatorio2dda.Entity.usuarioEstandar;
import com.obligatorio2dda.obligatorio2dda.Service.UsuarioEstandarService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/usuarioEstandar")
@CrossOrigin(origins = "http://localhost:3000")
public class usuarioEstandarController {
    
    @Autowired
    private UsuarioEstandarService usuarioEstandarService;


    @PostMapping
    public ResponseEntity<?> agregarUsuarioEstandar(@RequestBody usuarioEstandar ue) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioEstandarService.agregar(ue));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al agregar el usuario: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuarioEstandar(@PathVariable int id) {
        try {
            usuarioEstandarService.eliminar(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al eliminar el usuario: " + e.getMessage());
        }
    }


    @PutMapping
    public ResponseEntity<?> modificarUsuarioEstandar(@RequestBody usuarioEstandar ue) {
        try {
            usuarioEstandar ueModificado = usuarioEstandarService.modificar(ue);
            if (ueModificado != null) {
                return ResponseEntity.status(HttpStatus.OK).body(ueModificado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al modificar el usuario: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> conseguirUsuarioEstandar(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioEstandarService.conseguir(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al obtener el usuario: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> conseguirUsuarioEstandar() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioEstandarService.conseguir());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al obtener los usuarios: " + e.getMessage());
        }
    }
}
