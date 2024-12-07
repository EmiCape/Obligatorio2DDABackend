package com.obligatorio2dda.obligatorio2dda.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obligatorio2dda.obligatorio2dda.Entity.Venta;
import com.obligatorio2dda.obligatorio2dda.Entity.persona;
import com.obligatorio2dda.obligatorio2dda.Service.VentaService;

@Controller
@RequestMapping("/venta")
@CrossOrigin(origins = "http://localhost:3000")
public class VentaController {
    
    @Autowired
    private VentaService ventaService;


    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Venta v) {
        try {
            Venta ventaAgregada = ventaService.agregar(v);
            return ResponseEntity.status(HttpStatus.OK).body(ventaAgregada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar la venta: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        try {
            ventaService.eliminar(id);
            return ResponseEntity.status(HttpStatus.OK).body("Venta eliminada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la venta: " + e.getMessage());
        }
    }


    @PutMapping
    public ResponseEntity<?> modificar(@RequestBody Venta v) {
        try {
            Venta vModificada = ventaService.modificar(v);
            if (vModificada != null) {
                return ResponseEntity.status(HttpStatus.OK).body(vModificada);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al modificar la venta: " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> conseguir(@PathVariable int id) {
        try {
            Venta venta = ventaService.conseguir(id);
            if (venta != null) {
                return ResponseEntity.status(HttpStatus.OK).body(venta);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener la venta: " + e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> conseguir() {
        try {
            List<Venta> ventas = ventaService.conseguir();
            return ResponseEntity.status(HttpStatus.OK).body(ventas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las ventas: " + e.getMessage());
        }
    }

    @PostMapping("/filtrarPorUsuario")
    public ResponseEntity<List<Venta>> obtenerVentasPorUsuario(@RequestBody persona usuario) {
        try {
            List<Venta> ventas = ventaService.obtenerVentasPorUsuario(usuario);
            if (ventas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(ventas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/filtrarPorFecha")
    public ResponseEntity<List<Venta>> filtrarVentasPorFecha(@RequestParam String fechaCompra) {
        try {

            LocalDate fecha = LocalDate.parse(fechaCompra);
            List<Venta> ventas = ventaService.obtenerVentasPorFecha(fecha);
            if (ventas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(ventas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
