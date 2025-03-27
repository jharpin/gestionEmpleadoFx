package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.*;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.builder.EmpleadoBuilder;



public interface IEmpleadoCrud {
   boolean crearEmpleado(EmpleadoBuilder NuevoEmpleado);
   boolean eliminarEmpleado(String id);
   boolean ActualizarEmpleado(String id, String nombre, Proyecto proyectoAsociado);
   Empleado obtenerEmpleado(String id);
}
