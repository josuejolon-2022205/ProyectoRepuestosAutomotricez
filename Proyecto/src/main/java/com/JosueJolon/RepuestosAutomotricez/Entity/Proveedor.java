package com.JosueJolon.RepuestosAutomotricez.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "Proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer id_proveedor;

    @Column(name = "nombre_proveedor")
    @NotBlank(message = "el nombre del proveedor no puede estar vacio ")
    private String nombre_proveedor;

    @Column(name = "telefono_proveedor")
    @NotNull(message = "el telefono del proveedor no puede estar vacio")
    private int telefono_proveedor;

    @Column(name = "direccion")
    @NotBlank(message = "la direccion del proveedor no puede estar vacio")
    private String direccion;

    @Column(name = "email_proveedor")
    @NotBlank(message = "el email del proveedor no puede estar vacio ")
    private String email_proveedor;

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public int getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(int telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }
}
