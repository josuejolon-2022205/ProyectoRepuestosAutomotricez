package com.JosueJolon.RepuestosAutomotricez.Controllers;

import com.JosueJolon.RepuestosAutomotricez.Entity.Ventas;

import com.JosueJolon.RepuestosAutomotricez.Service.VentasService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAListVentas(){
        return ventasService.getAListVentas();
    }

    @PostMapping
    public ResponseEntity<Object> saveVentas(@Valid @RequestBody Ventas ventas){
        try {
            Ventas postVenta = ventasService.saveVentas(ventas);
            return new ResponseEntity<>(postVenta, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVentas(@PathVariable Integer id, @Valid @RequestBody Ventas ventas){
        try {
            Ventas ventas1 = ventasService.updateVentas(id, ventas);
            return new ResponseEntity<>(ventas1, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVentas(@PathVariable Integer id){
        try {
            ventasService.deleteVentas(id);
            return ResponseEntity.noContent().build();
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
     }

     @GetMapping("/{id}")
    public ResponseEntity<Object> getVentasById(@PathVariable Integer id){
        try {
            Ventas ventas = ventasService.getVentasById(id);
            return ResponseEntity.ok(ventas);
        }catch (ObjectNotFoundException e){
            return ResponseEntity.notFound().build();

        }
     }
}
