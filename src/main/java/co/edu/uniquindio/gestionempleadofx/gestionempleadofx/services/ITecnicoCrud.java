package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services;

import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Departamento;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Proyecto;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Tecnico;
public interface ITecnicoCrud {
    boolean crearTecnico(String nombre, String id, Proyecto proyectoAsociado, 
    Departamento departamentoAsociado, String especialidad);
    boolean actualizarTecnico(String id, String nuevoNombre, 
    Proyecto nuevoProyectoAsociado, Departamento nuevoDepartamentoAsociado, String nuevaEspecialidad);
    boolean eliminarTecnico(String id);
    Tecnico obtenerTecnico(String id);
}
