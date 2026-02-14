package com.JosueJolon.RepuestosAutomotricez.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "Ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id_venta;

    @Column(name = "fecha_venta")
    @NotNull(message = "la fecha de venta no puede estar vacia")
    private Date fecha_venta;

    @Column(name = "cantidad")
    @NotNull(message = "la cantidad no puede ser nula")
    private int cantidad;

    @Column(name = "total")
    @NotNull(message = "el total no puede ser nula")
    private double total;

    @Column(name = "id_empleado")
    @NotNull(message = "el id de empleado no puede ser 0 o estar vacio")
    private Integer id_empleado;

    @Column(name = "id_repuesto")
    @NotNull(message = "el id de repuesto no puede ser 0 o vacia")
    private Integer id_repuesto;

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Integer getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(Integer id_repuesto) {
        this.id_repuesto = id_repuesto;
    }
}
