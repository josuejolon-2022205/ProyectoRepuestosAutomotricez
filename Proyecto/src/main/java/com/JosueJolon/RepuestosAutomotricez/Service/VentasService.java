package com.JosueJolon.RepuestosAutomotricez.Service;

import com.JosueJolon.RepuestosAutomotricez.Entity.Ventas;

import java.util.List;

public interface VentasService {
    List<Ventas> getAListVentas();
    Ventas getVentasById(Integer id);
    Ventas saveVentas(Ventas ventas) throws RuntimeException;
    Ventas updateVentas(Integer id, Ventas ventas);
    void deleteVentas(Integer id);

}
