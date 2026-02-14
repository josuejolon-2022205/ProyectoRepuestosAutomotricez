package com.JosueJolon.RepuestosAutomotricez.Repository;

import com.JosueJolon.RepuestosAutomotricez.Entity.Repuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuestos, Integer> {
}
