package com.JosueJolon.RepuestosAutomotricez.Service;

import com.JosueJolon.RepuestosAutomotricez.Entity.Empleado;
import com.JosueJolon.RepuestosAutomotricez.Entity.Repuestos;
import com.JosueJolon.RepuestosAutomotricez.Entity.Ventas;
import com.JosueJolon.RepuestosAutomotricez.Exception.ResourceNotFoundException;
import com.JosueJolon.RepuestosAutomotricez.Repository.EmpleadoRepository;
import com.JosueJolon.RepuestosAutomotricez.Repository.RepuestoRepository;
import com.JosueJolon.RepuestosAutomotricez.Repository.VentasRepository;
import com.JosueJolon.RepuestosAutomotricez.Validator.VentasValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    private final VentasRepository ventasRepository;
    private final RepuestoRepository repuestoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final VentasValidator ventasValidator;

    public VentasServiceImplements(VentasRepository ventasRepository, RepuestoRepository repuestoRepository, EmpleadoRepository empleadoRepository, VentasValidator ventasValidator) {
        this.ventasRepository = ventasRepository;
        this.repuestoRepository = repuestoRepository;
        this.empleadoRepository = empleadoRepository;
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
            throw new ResourceNotFoundException("el id de ventas no existe");
        }

        return ventasRepository.save(updateVentas);
    }

    @Override
    public void deleteVentas(Integer id) {

        Ventas ventas = ventasRepository.findById(id).orElse(null);
        if(ventas == null){
            throw new ResourceNotFoundException("el id de ventas no existe");
        }
        ventasRepository.deleteById(id);


    }

}
