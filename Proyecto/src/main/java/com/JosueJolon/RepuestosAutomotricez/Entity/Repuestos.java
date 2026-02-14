package com.JosueJolon.RepuestosAutomotricez.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Repuestos")
public class Repuestos  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repuesto")
    private Integer id_repuesto;

    @Column(name = "nombre_repuesto")
    @NotBlank
    private String nombre_repuesto;

    @Column(name = "categoria_repuesto")
    @NotBlank(message = "la categoria del repuesto no puede estar vacio¿")
    private String categoria_repuesto;

    @Column(name = "precio_compra")
    @NotNull(message = "el precio de compran no puede ser nulo")
    private double precio_compra;

    @Column(name = "precio_venta")
    @NotNull(message = "el precio de venta no puede estar ")
    private double precio_venta;

    @Column(name = "id_proveedor")
    @NotNull(message = "el id del proveedor no puede ser nulo o vacio")
    private Integer id_proveedor;

    public Integer getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(Integer id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public String getNombre_repuesto() {
        return nombre_repuesto;
    }

    public void setNombre_repuesto(String nombre_repuesto) {
        this.nombre_repuesto = nombre_repuesto;
    }

    public String getCategoria_repuesto() {
        return categoria_repuesto;
    }

    public void setCategoria_repuesto(String categoria_repuesto) {
        this.categoria_repuesto = categoria_repuesto;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
}
