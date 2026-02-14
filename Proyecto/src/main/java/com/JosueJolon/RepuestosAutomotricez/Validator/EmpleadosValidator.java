package com.JosueJolon.RepuestosAutomotricez.Validator;

import com.JosueJolon.RepuestosAutomotricez.Entity.Empleado;
import com.JosueJolon.RepuestosAutomotricez.Repository.EmpleadoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // uso la anotacion @Component para crear una instancia de esta clase para que spring inyecte esta clase de "ayuda" porque si no creara la instancia
//tendria que usar new cada vez que la quisiera mandar a llamar. Esta clase no se puso en el service ya que no queda con la logica de negocio y porque component
// es usuada como auxiliar o para otras utilidades como este validador ya que las anotaciones como @controller, @Service y @Repository tiene su especialización
public class EmpleadosValidator {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadosValidator(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public void validarEmpleado(Empleado empleado){

        String nombreCompleto = empleado.getNombre_empleado() + empleado.getApellido_empleado();
        String emailEmpleado = empleado.getEmail_empleado();
        List<Empleado> empleados = empleadoRepository.findAll();

        for(Empleado nombresEmp : empleados){
            if(nombreCompleto.equals(nombresEmp.getNombre_empleado() + nombresEmp.getApellido_empleado())){
                throw new IllegalArgumentException("El nombre del empleado ya existe");
            }
        }

        for(Empleado emailEmp : empleados){
            if(emailEmpleado.equals(emailEmp.getEmail_empleado())){
                throw new IllegalArgumentException("El email del empleado ya existe");
            }
        }

        if(!emailEmpleado.endsWith("@gmail.com") && !emailEmpleado.endsWith("@yahoo.com") && !emailEmpleado.endsWith("@outlook.com")){
            throw new IllegalArgumentException("El email del empleado no tiene los dominios esperados");
        }


    }

}
