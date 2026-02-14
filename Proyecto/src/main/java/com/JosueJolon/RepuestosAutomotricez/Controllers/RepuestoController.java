package com.JosueJolon.RepuestosAutomotricez.Controllers;

import com.JosueJolon.RepuestosAutomotricez.Entity.Repuestos;

import com.JosueJolon.RepuestosAutomotricez.Service.RepuestoService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {
    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }

    @GetMapping
    public List<Repuestos> getAListRepuestos(){
        return repuestoService.getAListRepuestos();

    }

    @PostMapping
    public ResponseEntity<Object> saveRepuesto(@Valid @RequestBody Repuestos repuestos){
        try {
            Repuestos postRepuesto = repuestoService.saveRepuestos(repuestos);
            return new ResponseEntity<>(postRepuesto, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRepuesto(@PathVariable Integer id, @Valid @RequestBody Repuestos repuestos){
        try {
            Repuestos repuestos1 = repuestoService.updateRepuestos(id, repuestos);
            return new ResponseEntity<>(repuestos1, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRepuesto(@PathVariable Integer id){
        try {
            repuestoService.deleteRepuestos(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRepuestoById(@PathVariable Integer id){
        try {
            Repuestos repuestos = repuestoService.getRepuestoById(id);
            return ResponseEntity.ok(repuestos);
        }catch (ObjectNotFoundException e){
            return ResponseEntity.notFound().build();

        }

    }
}
