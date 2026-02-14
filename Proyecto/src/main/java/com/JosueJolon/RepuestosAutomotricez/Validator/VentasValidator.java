package com.JosueJolon.RepuestosAutomotricez.Validator;


import com.JosueJolon.RepuestosAutomotricez.Entity.Ventas;
import com.JosueJolon.RepuestosAutomotricez.Repository.VentasRepository;
import org.springframework.stereotype.Component;

@Component
public class VentasValidator {
    private final VentasRepository ventasRepository;

    public VentasValidator(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    public void validarVentas(Ventas ventas){
        if(ventas.getCantidad() <= 0){
            throw new IllegalArgumentException("la cantidad a vender no puede ser menor o igual a 0");
        }

        if(ventas.getTotal() <=0 ){
            throw new IllegalArgumentException("el total no puede ser menor o igual a 0");
        }
    }
}
