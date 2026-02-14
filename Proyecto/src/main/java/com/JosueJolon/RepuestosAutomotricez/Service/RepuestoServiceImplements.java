package com.JosueJolon.RepuestosAutomotricez.Service;

import com.JosueJolon.RepuestosAutomotricez.Entity.Repuestos;
import com.JosueJolon.RepuestosAutomotricez.Exception.ResourceNotFoundException;
import com.JosueJolon.RepuestosAutomotricez.Repository.RepuestoRepository;
import com.JosueJolon.RepuestosAutomotricez.Validator.RepuestoValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepuestoServiceImplements implements RepuestoService{
    private final RepuestoRepository repuestoRepository;
    private final RepuestoValidator repuestoValidator;

    public RepuestoServiceImplements(RepuestoRepository repuestoRepository, RepuestoValidator repuestoValidator) {
        this.repuestoRepository = repuestoRepository;
        this.repuestoValidator = repuestoValidator;
    }

    @Override
    public List<Repuestos> getAListRepuestos() {
        return repuestoRepository.findAll();
    }

    @Override
    public Repuestos getRepuestoById(Integer id) {
        Repuestos repuestos = repuestoRepository.findById(id).orElse(null) ;
        if(repuestos == null){
            throw new IllegalArgumentException();
        }else {
            return repuestoRepository.findById(id).orElse(null);
        }
    }

    @Override
    public Repuestos saveRepuestos(Repuestos repuestos) throws RuntimeException {
        repuestoValidator.validarRepuesto(repuestos);
        return repuestoRepository.save(repuestos);
    }

    @Override
    public Repuestos updateRepuestos(Integer id, Repuestos repuestos) {
        Repuestos actRepuestos = repuestoRepository.findById(id).orElse(null);

        if(actRepuestos != null){
            repuestoValidator.validarRepuesto(repuestos);
            actRepuestos.setNombre_repuesto(repuestos.getNombre_repuesto());
            actRepuestos.setCategoria_repuesto(repuestos.getCategoria_repuesto());
            actRepuestos.setPrecio_compra(repuestos.getPrecio_compra());
            actRepuestos.setPrecio_venta(repuestos.getPrecio_venta());
            actRepuestos.setId_proveedor(repuestos.getId_proveedor());
        }else {
            throw new ResourceNotFoundException("el id del repuesto no existe");
        }
        return repuestoRepository.save(actRepuestos);
    }

    @Override
    public void deleteRepuestos(Integer id) {
        Repuestos repuestos = repuestoRepository.findById(id).orElse(null);
        if(repuestos == null){
            throw new ResourceNotFoundException("el id del repuesto no existe");
        }
        repuestoRepository.deleteById(id);


    }
}
