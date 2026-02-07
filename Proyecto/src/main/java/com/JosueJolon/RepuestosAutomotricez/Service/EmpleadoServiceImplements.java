package com.JosueJolon.RepuestosAutomotricez.Service;


import com.JosueJolon.RepuestosAutomotricez.Models.Empleado;
import com.JosueJolon.RepuestosAutomotricez.Repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImplements implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImplements(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }



    @Override
    public List<Empleado> getAListEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) throws RuntimeException {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Integer id, Empleado empleado) {
        Empleado empleados = empleadoRepository.findById(id).orElse(null);
        if(empleados != null){
            empleados.setNombre_empleado(empleado.getNombre_empleado());
            empleados.setApellido_empleado(empleado.getApellido_empleado());
            empleados.setPuesto_empleado(empleado.getPuesto_empleado());
            empleados.setEmail_empleado(empleado.getEmail_empleado());
        } else {
            throw new IllegalArgumentException();
        }
        return empleadoRepository.save(empleados);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
