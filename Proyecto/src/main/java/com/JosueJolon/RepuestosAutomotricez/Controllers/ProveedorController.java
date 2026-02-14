package com.JosueJolon.RepuestosAutomotricez.Controllers;

import com.JosueJolon.RepuestosAutomotricez.Entity.Proveedor;
import com.JosueJolon.RepuestosAutomotricez.Exception.ResourceNotFoundException;
import com.JosueJolon.RepuestosAutomotricez.Service.ProveedorService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")

public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService ) {
        this.proveedorService = proveedorService;

    }

    @GetMapping
    public List<Proveedor> getAListProveedor(){
        return proveedorService.getAListProveedors();
    }

    @PostMapping
    public ResponseEntity<Object> saveProveedor(@Valid @RequestBody Proveedor proveedor){
        try {
            Proveedor createProveedor = proveedorService.saveProveedor(proveedor);
            return new ResponseEntity<>(createProveedor, HttpStatus.CREATED);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProveedor(@Valid @RequestBody Proveedor proveedor, @PathVariable Integer id){
        try {
            Proveedor proveedor1 = proveedorService.updateProveedor(id, proveedor);
            return new ResponseEntity<>(proveedor1, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProveedor(@PathVariable Integer id){
        try {
            proveedorService.deleteProveedor(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProveedorById(@PathVariable Integer id){
        try {
            Proveedor proveedor = proveedorService.getProveedorById(id);
            return ResponseEntity.ok(proveedor);
        }catch (ObjectNotFoundException e){
            return ResponseEntity.notFound().build();

        }

    }

}
