package com.JosueJolon.RepuestosAutomotricez.Service;

import com.JosueJolon.RepuestosAutomotricez.Entity.Repuestos;

import java.util.List;

public interface RepuestoService {
    List<Repuestos> getAListRepuestos();
    Repuestos getRepuestoById(Integer id);
    Repuestos saveRepuestos(Repuestos repuestos) throws RuntimeException;
    Repuestos updateRepuestos(Integer id, Repuestos repuestos);
    void deleteRepuestos(Integer id);

}
