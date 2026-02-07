package com.JosueJolon.RepuestosAutomotricez.Service;

import com.JosueJolon.RepuestosAutomotricez.Models.Empleado;
import com.JosueJolon.RepuestosAutomotricez.Models.Repuestos;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmpleadoService {
    List<Empleado> getAListEmpleados();
    Empleado getEmpleadoById(Integer id);
    Empleado saveEmpleado (Empleado empleado) throws RuntimeException;
    Empleado updateEmpleado(Integer id, Empleado empleado);
    void deleteEmpleado(Integer id);



}
