package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services;

import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Gerente;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Proyecto;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Tecnico;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.Departamento;

public interface IDepartamentoCrud {
    boolean crearDepartamento(String nombreDepartamento, String codigoDepartamento, Gerente gerenteAsociado, Proyecto proyectoAsociado, Tecnico listaTecnicos);
    boolean eliminarDepartamento(String codigoDepartamento);
    boolean actualizarDepartamento(String nombreDepartamento, String codigoDepartamento,Gerente gerenteAsociado,Proyecto proyectoAsociado,Tecnico listaTecnicos);
    Departamento ObtenerDepartamento(String codigoDepartamento);
}
