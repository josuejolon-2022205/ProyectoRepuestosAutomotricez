package com.JosueJolon.RepuestosAutomotricez.Service;

import com.JosueJolon.RepuestosAutomotricez.Entity.Ventas;
import com.JosueJolon.RepuestosAutomotricez.Exception.Exceptions;
import com.JosueJolon.RepuestosAutomotricez.Repository.VentasRepository;
import com.JosueJolon.RepuestosAutomotricez.Validator.VentasValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    private final VentasRepository ventasRepository;
    private final VentasValidator ventasValidator;

    public VentasServiceImplements(VentasRepository ventasRepository, VentasValidator ventasValidator) {
        this.ventasRepository = ventasRepository;
        this.ventasValidator = ventasValidator;
    }

    @Override
    public List<Ventas> getAListVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas getVentasById(Integer id) {
        Ventas ventas = ventasRepository.findById(id).orElse(null);
        if(ventas == null){
            throw new IllegalArgumentException();
        }else {
            return ventasRepository.findById(id).orElse(null);
        }
    }

    @Override
    public Ventas saveVentas(Ventas ventas) throws RuntimeException {
        ventasValidator.validarVentas(ventas);
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas updateVentas(Integer id, Ventas ventas) {
        Ventas updateVentas = ventasRepository.findById(id).orElse(null);

        if (updateVentas != null) {
            ventasValidator.validarVentas(ventas);
            updateVentas.setFecha_venta(ventas.getFecha_venta());
            updateVentas.setCantidad(ventas.getCantidad());
            updateVentas.setTotal(ventas.getTotal());
            updateVentas.setId_empleado(ventas.getId_empleado());
            updateVentas.setId_repuesto(ventas.getId_repuesto());
        } else {
            throw new Exceptions("el id de ventas no existe");
        }

        return ventasRepository.save(updateVentas);
    }

    @Override
    public void deleteVentas(Integer id) {

        Ventas ventas = ventasRepository.findById(id).orElse(null);
        if(ventas == null){
            throw new Exceptions("el id de ventas no existe");
        }
        ventasRepository.deleteById(id);


    }

}
