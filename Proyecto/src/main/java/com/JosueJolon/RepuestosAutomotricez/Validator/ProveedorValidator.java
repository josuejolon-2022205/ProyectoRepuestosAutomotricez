package com.JosueJolon.RepuestosAutomotricez.Validator;


import com.JosueJolon.RepuestosAutomotricez.Entity.Proveedor;
import com.JosueJolon.RepuestosAutomotricez.Repository.ProveedorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProveedorValidator {
    private final ProveedorRepository proveedorRepository;

    public ProveedorValidator(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public void validarProveedor(Proveedor proveedor){
        String emailProveedor = proveedor.getEmail_proveedor();
        List<Proveedor> proveedores = proveedorRepository.findAll();

        if(!emailProveedor.endsWith("@gmail.com") && !emailProveedor.endsWith("@outlook") && !emailProveedor.endsWith("@yahoo.com")){
            throw new IllegalArgumentException("El email del proveedor no tiene los dominios esperados");
        }
    }
}
