package com.obligatorio2dda.obligatorio2dda.Entity;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fechaCompra;


    @ManyToOne
    private persona usuario; 
    
    @OneToMany(mappedBy = "venta")
    @JsonManagedReference
    private List<VideoJuegoVenta> videojuegosVenta;  

    private double montoTotal;

    
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Venta(int id,LocalDate fechaCompra , persona usuario, List<VideoJuegoVenta> videojuegosVenta, double monto) {
        this.id=id;
        this.fechaCompra = fechaCompra;
        this.usuario = usuario;
        this.videojuegosVenta = videojuegosVenta;
        this.montoTotal = monto;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public persona getUsuario() {
        return usuario;
    }

    public void setUsuario(persona usuario) {
        this.usuario = usuario;
    }

    public List<VideoJuegoVenta> getVideojuegosVenta() {
        return videojuegosVenta;
    }

    public void setVideojuegosVenta(List<VideoJuegoVenta> videojuegosVenta) {
        this.videojuegosVenta = videojuegosVenta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public Venta(){}

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
