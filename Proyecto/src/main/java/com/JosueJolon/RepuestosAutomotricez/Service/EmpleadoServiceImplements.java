package com.JosueJolon.RepuestosAutomotricez.Service;


import com.JosueJolon.RepuestosAutomotricez.Entity.Empleado;
import com.JosueJolon.RepuestosAutomotricez.Exception.Exceptions;
import com.JosueJolon.RepuestosAutomotricez.Repository.EmpleadoRepository;
import com.JosueJolon.RepuestosAutomotricez.Validator.EmpleadosValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImplements implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadosValidator empleadosValidator;

    public EmpleadoServiceImplements(EmpleadoRepository empleadoRepository, EmpleadosValidator empleadosValidator) {
        this.empleadoRepository = empleadoRepository;
        this.empleadosValidator = empleadosValidator;
    }

    @Override
    public List<Empleado> getAListEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Integer id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if(empleado == null){
            throw new IllegalArgumentException();
        }else {
            return empleadoRepository.findById(id).orElse(null);
        }
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) throws RuntimeException {
        empleadosValidator.validarEmpleado(empleado);
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleado) {
        Empleado empleados = empleadoRepository.findById(id).orElse(null);
        if(empleados != null){
            empleadosValidator.validarEmpleado(empleado);
            empleados.setNombre_empleado(empleado.getNombre_empleado());
            empleados.setApellido_empleado(empleado.getApellido_empleado());
            empleados.setPuesto_empleado(empleado.getPuesto_empleado());
            empleados.setEmail_empleado(empleado.getEmail_empleado());
        } else {
            throw new Exceptions("el id del empleado no existe");
        }
        return empleadoRepository.save(empleados);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        if(empleado == null){
            throw new Exceptions("el id del empleado no existe");
        }

        empleadoRepository.deleteById(id);
    }
}
