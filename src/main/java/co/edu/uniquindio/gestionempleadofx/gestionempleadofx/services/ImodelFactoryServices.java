package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services;

public interface ImodelFactoryServices extends IEmpleadoCrud,
        IDepartamentoCrud,IGerenteCrud,ITecnicoCrud,IProyectoCrud {
    void mostrarInfoEmpresa();

    boolean agregarProyectoAsociadaGerente(String id);

    boolean listarGerentesYProyectos();

    boolean tecnicoPerteneceProyecto();

    boolean buscarPropietarioVocales();

    boolean mostrarListaEmpleados();
}
