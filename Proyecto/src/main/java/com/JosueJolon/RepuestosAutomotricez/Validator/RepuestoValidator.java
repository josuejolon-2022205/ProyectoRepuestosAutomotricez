package com.JosueJolon.RepuestosAutomotricez.Validator;


import com.JosueJolon.RepuestosAutomotricez.Entity.Repuestos;
import com.JosueJolon.RepuestosAutomotricez.Repository.RepuestoRepository;
import org.springframework.stereotype.Component;

@Component
public class RepuestoValidator {
    private final RepuestoRepository repuestoRepository;

    public RepuestoValidator(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;

    }

    public void validarRepuesto(Repuestos repuestos){
        if(repuestos.getPrecio_compra() <= 0){
            throw new IllegalArgumentException("el precio de compra no puede ser menor o igual a 0");
        }

        if(repuestos.getPrecio_venta() <= 0){
            throw new IllegalArgumentException("el precio de venta no puede ser menor o igual a 0");
        }

        if(repuestos.getPrecio_venta() <= repuestos.getPrecio_compra()){
            throw new IllegalArgumentException("El precio de venta no puede ser menor del de compra, para tener ganancias :)");
        }

    }

}
