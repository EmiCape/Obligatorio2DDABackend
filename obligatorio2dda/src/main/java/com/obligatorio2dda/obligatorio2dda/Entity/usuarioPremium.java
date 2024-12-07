package com.obligatorio2dda.obligatorio2dda.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class usuarioPremium extends persona {
    private LocalDate fechaObtenida;

    public usuarioPremium(int id, String nombre, String email, LocalDate fechaIngreso, LocalDate fechaObtenida){
        super(id,nombre,email,fechaIngreso);
        this.fechaObtenida=fechaObtenida;
    }
    public usuarioPremium(){
        
    }

    public LocalDate getFechaObtenida() {
        return fechaObtenida;
    }

    public void setFechaObtenida(LocalDate fechaObtenida) {
        this.fechaObtenida = fechaObtenida;
    }

    public String getTipoPersona(){
        return "premium";
    }

}
