package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services;

import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Departamento;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Empleado;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Proyecto;

public interface IProyectoCrud {
    boolean crearProyecto(String nombreProyecto, String codigoProyecto, Departamento departamentoAsociado, Empleado empleadosAsignado);

    boolean modificarProyecto( String nombreProyecto,String codigoProyecto,Empleado listaEmpleados,Departamento listaDepartamento);

    boolean eliminarProyecto(String codigoProyecto);

    Proyecto obtenerProyecto(String codigoProyecto);

}
