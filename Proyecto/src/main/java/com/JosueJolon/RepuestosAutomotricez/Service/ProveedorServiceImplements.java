package com.JosueJolon.RepuestosAutomotricez.Service;


import com.JosueJolon.RepuestosAutomotricez.Entity.Proveedor;
import com.JosueJolon.RepuestosAutomotricez.Exception.ResourceNotFoundException;
import com.JosueJolon.RepuestosAutomotricez.Repository.ProveedorRepository;
import com.JosueJolon.RepuestosAutomotricez.Validator.ProveedorValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImplements implements ProveedorService {
    private final ProveedorRepository proveedorRepository;
    private final ProveedorValidator proveedorValidator;

    public ProveedorServiceImplements(ProveedorRepository proveedorRepository, ProveedorValidator proveedorValidator) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorValidator = proveedorValidator;
    }

    @Override
    public List<Proveedor> getAListProveedors() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor getProveedorById(Integer id) {
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if(proveedor == null){
            throw new IllegalArgumentException();
        }else {
            return proveedorRepository.findById(id).orElse(null);
        }
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) throws RuntimeException {
        proveedorValidator.validarProveedor(proveedor);
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor updateProveedor(Integer id, Proveedor proveedor) {
        Proveedor proveedores = proveedorRepository.findById(id).orElse(null);

        if(proveedores != null){
            proveedorValidator.validarProveedor(proveedor);
            proveedores.setNombre_proveedor(proveedor.getNombre_proveedor());
            proveedores.setTelefono_proveedor(proveedor.getTelefono_proveedor());
            proveedores.setDireccion(proveedor.getDireccion());
            proveedores.setEmail_proveedor(proveedor.getEmail_proveedor());

        }else {
            throw new ResourceNotFoundException("el id del proveedor no existe");
        }
        return proveedorRepository.save(proveedores);
    }

    @Override
    public void deleteProveedor(Integer id) {
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if(proveedor == null){
            throw new ResourceNotFoundException("el id del proveedor no existe");
        }
        proveedorRepository.deleteById(id);
    }
}
