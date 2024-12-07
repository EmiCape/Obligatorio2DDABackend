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
import com.obligatorio2dda.obligatorio2dda.Entity.usuarioPremium;
import com.obligatorio2dda.obligatorio2dda.Service.UsuarioPremiumService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/usuariosPremium")
@CrossOrigin(origins = "http://localhost:3000")
public class usuarioPremiumController {

    @Autowired
    private UsuarioPremiumService usuarioPremiumService;


    @PostMapping
    public ResponseEntity<?> agregarUsuarioPremium(@RequestBody usuarioPremium u) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioPremiumService.agregarUsuarioPremium(u));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al agregar el usuario premium: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuarioPremium(@PathVariable int id) {
        try {
            usuarioPremiumService.eliminarUsuarioPremium(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario premium eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al eliminar el usuario premium: " + e.getMessage());
        }
    }


    @PutMapping
    public ResponseEntity<?> modificarUsuarioPremium(@RequestBody usuarioPremium u) {
        try {
            usuarioPremium ueModificado = usuarioPremiumService.modificarUsuarioPremium(u);
            if (ueModificado != null) {
                return ResponseEntity.status(HttpStatus.OK).body(ueModificado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario premium no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al modificar el usuario premium: " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> conseguirUsuarioPremium(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioPremiumService.conseguirUsuarioPremium(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al obtener el usuario premium: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> conseguirUsuarioPremium() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioPremiumService.conseguirUsuarioPremium());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema al obtener los usuarios premium: " + e.getMessage());
        }
    }
}
