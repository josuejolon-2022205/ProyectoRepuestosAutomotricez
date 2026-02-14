package com.JosueJolon.RepuestosAutomotricez.Repository;

import com.JosueJolon.RepuestosAutomotricez.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {


}
