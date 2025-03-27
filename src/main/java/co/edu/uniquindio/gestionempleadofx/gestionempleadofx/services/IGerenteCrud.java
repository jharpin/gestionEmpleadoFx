package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Departamento;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Gerente;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Proyecto;

public interface IGerenteCrud {
    boolean crearGerente(String nombre, String id, 
    Proyecto proyectoAsociado,Departamento departamentoAsociado);
    boolean eliminarGerente(String id);
    boolean actualizarGerente(String nombre, String id, Proyecto proyectoAsociado,
     Departamento departamentoAsociado);
    Gerente obtenerGerente(String id);
}
