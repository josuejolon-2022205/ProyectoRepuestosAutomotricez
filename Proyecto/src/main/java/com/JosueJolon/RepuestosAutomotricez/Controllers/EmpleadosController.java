package com.JosueJolon.RepuestosAutomotricez.Controllers;


import com.JosueJolon.RepuestosAutomotricez.Entity.Empleado;
import com.JosueJolon.RepuestosAutomotricez.Exception.ResourceNotFoundException;
import com.JosueJolon.RepuestosAutomotricez.Service.EmpleadoService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/empleados")

public class EmpleadosController {
    private final EmpleadoService empleadoService;

    public EmpleadosController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> getAListEmpleados(){
        return empleadoService.getAListEmpleados();
    }

    @PostMapping
    public ResponseEntity<Object> createEmpleado(@Valid @RequestBody Empleado empleado) {

        try {
            Empleado createdEmpleado = empleadoService.saveEmpleado(empleado);
            return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpleado(@Valid @RequestBody Empleado empleado, @PathVariable Integer id){
        try {
            Empleado empleado1 = empleadoService.updateEmpleado(id, empleado);
            return ResponseEntity.ok(empleado1);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpleado(@PathVariable Integer id){
        try {
            empleadoService.deleteEmpleado(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmpleadoById(@PathVariable Integer id){
        try {
            Empleado empleado = empleadoService.getEmpleadoById(id);
            return  ResponseEntity.ok(empleado);
        }catch (ObjectNotFoundException e){
            return  ResponseEntity.notFound().build();

        }
    }

}

