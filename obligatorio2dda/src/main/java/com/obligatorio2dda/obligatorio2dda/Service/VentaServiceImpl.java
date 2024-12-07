package com.obligatorio2dda.obligatorio2dda.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.Entity.Venta;
import com.obligatorio2dda.obligatorio2dda.Entity.VideoJuegoVenta;
import com.obligatorio2dda.obligatorio2dda.Entity.Videojuego;
import com.obligatorio2dda.obligatorio2dda.Entity.persona;
import com.obligatorio2dda.obligatorio2dda.Repository.PersonaRepository;
import com.obligatorio2dda.obligatorio2dda.Repository.VentaRepository;
import com.obligatorio2dda.obligatorio2dda.Repository.VideojuegoRepository;
import com.obligatorio2dda.obligatorio2dda.AppException;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    VentaRepository ventaRepository;

    public Venta agregar(Venta v) throws AppException {
        persona persona = personaRepository.findById(v.getUsuario().getId()).orElse(null);

        if (persona != null && persona.getTipoPersona().equals("premium")) {
            double descuento = 0.20;
            double montoConDescuento = v.getMontoTotal() * (1 - descuento);
            v.setMontoTotal(montoConDescuento);
        }

        for (VideoJuegoVenta videoJuegosVenta : v.getVideojuegosVenta()) {
            Optional<Videojuego> videojuegoOpt = videojuegoRepository.findById(videoJuegosVenta.getVideojuego().getId());
            if (videojuegoOpt.isPresent()) {
                Videojuego videojuegoActual = videojuegoOpt.get();
                int nuevoStock = videojuegoActual.getCantCopias() - videoJuegosVenta.getCantidad();
                if (nuevoStock < 0) {
                    throw new AppException("No hay suficiente stock de " + videojuegoActual.getNombre());
                }
                videojuegoActual.setCantCopias(nuevoStock);
                videojuegoRepository.save(videojuegoActual);
            } else {
                throw new AppException("El videojuego no existe.");
            }
        }

        return ventaRepository.save(v);
    }

    public boolean eliminar(int id) throws AppException {
        Optional<Venta> venta = ventaRepository.findById(id);
        if (venta.isPresent()) {
            ventaRepository.deleteById(id);
            return true;
        } else {
            throw new AppException("No se encontró la venta con el ID " + id);
        }
    }

    public Venta modificar(Venta v) throws AppException {
        Optional<Venta> ventaExistente = ventaRepository.findById(v.getId());
        if (ventaExistente.isPresent()) {
            return ventaRepository.save(v);
        } else {
            throw new AppException("No se encontró la venta con el ID " + v.getId());
        }
    }

    public Venta conseguir(int id) throws AppException {
        Optional<Venta> v = ventaRepository.findById(id);
        if (v.isPresent()) {
            return v.get();
        } else {
            throw new AppException("No se encontró la venta con el ID " + id);
        }
    }

    public List<Venta> conseguir() {
        return ventaRepository.findAll();
    }

    @Override
    public List<Venta> obtenerVentasPorUsuario(persona usuario) {
        return ventaRepository.findByUsuario(usuario);
    }

    @Override
    public List<Venta> obtenerVentasPorFecha(LocalDate fecha) {
        return ventaRepository.findByFechaCompra(fecha);
    }
}
