package com.obligatorio2dda.obligatorio2dda.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class usuarioEstandar extends persona {
    public usuarioEstandar(int Id,String nombre,String email, LocalDate fechaRegistro){
        super(Id, nombre, email, fechaRegistro);
    }

    public usuarioEstandar(){}

@Override
    public String getTipoPersona(){
    return "estandar";
    }
}
