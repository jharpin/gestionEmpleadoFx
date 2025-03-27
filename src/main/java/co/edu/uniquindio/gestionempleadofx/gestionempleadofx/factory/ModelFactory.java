package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.factory;

import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.*;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.builder.EmpleadoBuilder;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services.*;

public class ModelFactory implements ImodelFactoryServices{
    /// inicializacion de los objetos
    private static ModelFactory modelFactory;
    private SistemaGestionEmpresa  sistemaGestionEmpresa;
    private Iempleadomapping mapper;

    private ModelFactory(){
        inicializarDatos();
    }
    /// si model factory es nulo crea una nueva instancia
    public static ModelFactory getInstance(){
        if (modelFactory == null){
            modelFactory = new ModelFactory();
        }
        ///si no, retorne el objeto ya creado
        return  modelFactory;
    }
    private void inicializarDatos() {
        /// se inicializan datos en quemado para facilitar el debug del codigo
        /// nueva instancia de gestion empresa
        sistemaGestionEmpresa= new SistemaGestionEmpresa();
        /// datos proyecto
        Proyecto proyecto1=new Proyecto();
        proyecto1.setNombreProyecto("Expansion");
        proyecto1.setCodigoProyecto("1039");
        Proyecto proyecto2=new Proyecto();
        proyecto2.setNombreProyecto("Social");
        proyecto2.setCodigoProyecto("2938");
        Proyecto proyecto3=new Proyecto();
        proyecto3.setNombreProyecto("Mercadeo");
        proyecto3.setCodigoProyecto("3746");
        Proyecto proyecto4=new Proyecto();
        proyecto4.setNombreProyecto("Construccion");
        proyecto4.setCodigoProyecto("6578");
        /// datos departamento
        Departamento departamento1 = new Departamento();
        departamento1.setNombreDepartamento("Administrativo");
        departamento1.setCodigoDepartamento("2020");
        Departamento departamento2 = new Departamento();
        departamento2.setNombreDepartamento("Recursos Humanos");
        departamento2.setCodigoDepartamento("2022");
        Departamento departamento3 = new Departamento();
        departamento3.setNombreDepartamento("Marketing");
        departamento3.setCodigoDepartamento("2025");
        Departamento departamento4 = new Departamento();
        departamento4.setNombreDepartamento("General");
        departamento4.setCodigoDepartamento("6060");
        /// datos empleado
        Empleado empleado1 = Empleado.builder()
                .setNombre("Fernando")
                .setId("1011")
                .setProyecto(proyecto1)
                .build();
        Empleado empleado2=Empleado.builder()
                .setNombre("esteban")
                .setId("poiu")
                .setProyecto(proyecto2)
                .build();
        Empleado empleado3 = Empleado.builder()
                .setNombre("jeslin")
                .setId("1012")
                .setProyecto(proyecto3)
                .build();
        Empleado empleado4 =  Empleado.builder()
                .setNombre("carmona")
                .setId("1013")
                .setProyecto(proyecto4)
                .build();

        Tecnico tecnico1= new Tecnico();
        tecnico1.setNombre("Juan");
        tecnico1.setId("1011"); 
        tecnico1.setProyectoAsociado(proyecto1);
        tecnico1.setDepartamentoAsociado(departamento1);
        tecnico1.setEspecialidad("Diagnostico");
        Tecnico tecnico2= new Tecnico();   
        tecnico2.setNombre("Carlos");
        tecnico2.setId("5105");
        tecnico2.setProyectoAsociado(proyecto2);
        tecnico2.setDepartamentoAsociado(departamento2);
        tecnico2.setEspecialidad("Mantenimiento");
        Tecnico tecnico3= new Tecnico();    
        tecnico3.setNombre("Pedro");
        tecnico3.setId("6025");
        tecnico3.setProyectoAsociado(proyecto3);
        tecnico3.setDepartamentoAsociado(departamento3);
        tecnico3.setEspecialidad("Instalacion");
        Tecnico tecnico4= new Tecnico();
        tecnico4.setNombre("Mario");    
        tecnico4.setId("6868");
        tecnico4.setProyectoAsociado(proyecto4);
        tecnico4.setDepartamentoAsociado(departamento4);
        tecnico4.setEspecialidad("Electricidad");
        /// datos gerente
        Gerente gerente1 = new Gerente();
        gerente1.setNombre("Marlon");
        gerente1.setId("1011");
        gerente1.setProyectoAsociado(proyecto1);
        gerente1.setDepartamentoAsociado(departamento1);
        Gerente gerente2 = new Gerente();
        gerente2.setNombre("Javier");
        gerente2.setId("5105");
        gerente2.setProyectoAsociado(proyecto2);
        gerente2.setDepartamentoAsociado(departamento2);
        Gerente gerente3 = new Gerente();
        gerente3.setNombre("Andres");
        gerente3.setId("6025");
        gerente3.setProyectoAsociado(proyecto3);
        gerente3.setDepartamentoAsociado(departamento3);
        Gerente gerente4 = new Gerente();
        gerente4.setNombre("Pablo");
        gerente4.setId("6868");
        gerente4.setProyectoAsociado(proyecto4);
        gerente4.setDepartamentoAsociado(departamento4);
        departamento1.setProyectoAsociado(proyecto1);
        departamento2.setProyectoAsociado(proyecto2);
        departamento3.setProyectoAsociado(proyecto3);
        departamento4.setProyectoAsociado(proyecto4);
        /// se agregan a las listas en sistemaGestiom
        sistemaGestionEmpresa.getDepartamentos().add(departamento1);
        sistemaGestionEmpresa.getDepartamentos().add(departamento2);
        sistemaGestionEmpresa.getDepartamentos().add(departamento3);
        sistemaGestionEmpresa.getDepartamentos().add(departamento4);
        sistemaGestionEmpresa.getEmpleados().add(empleado1);
        sistemaGestionEmpresa.getEmpleados().add(empleado2);
        sistemaGestionEmpresa.getEmpleados().add(empleado3);
        sistemaGestionEmpresa.getEmpleados().add(empleado4);
        sistemaGestionEmpresa.getTecnicos().add(tecnico1);
        sistemaGestionEmpresa.getTecnicos().add(tecnico2);
        sistemaGestionEmpresa.getTecnicos().add(tecnico3);
        sistemaGestionEmpresa.getTecnicos().add(tecnico4);
        sistemaGestionEmpresa.getGerentes().add(gerente1);
        sistemaGestionEmpresa.getGerentes().add(gerente2);
        sistemaGestionEmpresa.getGerentes().add(gerente3);
        sistemaGestionEmpresa.getGerentes().add(gerente4);
        sistemaGestionEmpresa.getProyectos().add(proyecto1);
        sistemaGestionEmpresa.getProyectos().add(proyecto2);
        sistemaGestionEmpresa.getProyectos().add(proyecto3);
        sistemaGestionEmpresa.getProyectos().add(proyecto4);
       
    }

    @Override
    public boolean crearEmpleado(EmpleadoBuilder empleadoBuilder) {
        return sistemaGestionEmpresa.crearEmpleado(empleadoBuilder);
    }

    /// CRUD EMPLEADOS

    @Override
    public boolean eliminarEmpleado(String id) {
        return sistemaGestionEmpresa.eliminarEmpleado(id);
    }

    @Override
    public boolean ActualizarEmpleado(String id, String nombre, Proyecto proyectoAsociado) {
        return sistemaGestionEmpresa.ActualizarEmpleado(id, nombre,proyectoAsociado);
    }

    @Override
    public Empleado obtenerEmpleado(String id) {
        return sistemaGestionEmpresa.obtenerEmpleado(id);
    }

    @Override
    public void mostrarInfoEmpresa() {
        sistemaGestionEmpresa.mostrarInfoEmpresa();
    }

    /// CRUD  Proyecto
    @Override
    public boolean agregarProyectoAsociadaGerente(String id) {
        return sistemaGestionEmpresa.agregarProyectoAsociadaGerente(id);
    }
    @Override
    public boolean crearProyecto(String nombreProyecto, String codigoProyecto, Departamento departamentoAsociado, Empleado empleadosAsignado) {
        return sistemaGestionEmpresa.crearProyecto(nombreProyecto,codigoProyecto,departamentoAsociado,empleadosAsignado);
    }
    @Override
    public boolean modificarProyecto(String nombreProyecto,String codigoProyecto,Empleado listaEmpleados,Departamento listaDepartamento) {
        return sistemaGestionEmpresa.modificarProyecto(nombreProyecto,codigoProyecto,listaEmpleados,listaDepartamento);
    }
    @Override
    public boolean eliminarProyecto(String codigoProyecto) {
        return sistemaGestionEmpresa.eliminarProyecto(codigoProyecto);
    }

    @Override
    public Proyecto obtenerProyecto(String codigoProyecto) {
        return sistemaGestionEmpresa.obtenerProyecto(codigoProyecto);
    }

    /// CRUD GERENTE
    @Override
    public boolean crearGerente(String nombre, String id, Proyecto proyectoAsociado, Departamento departamentoAsociado) {
        return sistemaGestionEmpresa.crearGerente(nombre, id, proyectoAsociado, departamentoAsociado);
    }
    @Override
    public boolean actualizarGerente( String nombre,String id, Proyecto proyectoAsociado,
                                 Departamento departamentoAsociado) {
        return sistemaGestionEmpresa.actualizarGerente( nombre,id, proyectoAsociado,
                    departamentoAsociado);}
    @Override
    public boolean eliminarGerente(String id) {
        return sistemaGestionEmpresa.eliminarGerente(id);
    }
    @Override
    public Gerente obtenerGerente(String id) {
        return sistemaGestionEmpresa.obtenerGerente(id);
    }
    /// CRUD TECNICO
    @Override 
    public boolean crearTecnico(String nombre, String id, Proyecto proyectoAsociado, Departamento departamentoAsociado, String especialidad) {
        return sistemaGestionEmpresa.crearTecnico(nombre, id, proyectoAsociado, departamentoAsociado, especialidad);
    }
    @Override
    public boolean actualizarTecnico(String nombre, String id, Proyecto proyectoAsociado, Departamento departamentoAsociado, String especialidad) {
        return sistemaGestionEmpresa.actualizarTecnico(nombre, id, proyectoAsociado, departamentoAsociado, especialidad);
    }
    @Override
    public boolean eliminarTecnico(String id) {
        return sistemaGestionEmpresa.eliminarTecnico(id);
    }
    @Override
    public Tecnico obtenerTecnico(String id) {
        return sistemaGestionEmpresa.obtenerTecnico(id);
    }
    /// CRUD DEPARTAMENTO
    @Override
    public boolean crearDepartamento(String nombreDepartamento, String codigoDepartamento, Gerente gerenteAsociado, Proyecto proyectoAsociado, Tecnico listaTecnico) {
        return sistemaGestionEmpresa.crearDepartamento(nombreDepartamento,codigoDepartamento,gerenteAsociado,proyectoAsociado,listaTecnico);
    }

    @Override
    public boolean eliminarDepartamento(String codigoDepartamento) {
        return sistemaGestionEmpresa.eliminarDepartamento(codigoDepartamento);
    }

    @Override
    public boolean actualizarDepartamento(String nombreDepartamento,String codigoDepartamento,Gerente gerenteAsociado, Proyecto proyectoAsociado, Tecnico listaTenico){
        return sistemaGestionEmpresa.actualizarDepartamento(nombreDepartamento, codigoDepartamento, gerenteAsociado, proyectoAsociado, listaTenico);
    }


    @Override
    public Departamento ObtenerDepartamento(String codigoDepartamento) {
        return sistemaGestionEmpresa.ObtenerDepartamento(codigoDepartamento);
    }
    @Override
    public boolean listarGerentesYProyectos(){
        return sistemaGestionEmpresa.listarGerentesYProyectos();
    }

    @Override
    public boolean tecnicoPerteneceProyecto() {
        return sistemaGestionEmpresa.tecnicoPerteneceProyecto();
    }

    @Override
    public boolean buscarPropietarioVocales() {
        return sistemaGestionEmpresa.buscarPropietarioVocales();
    }

    @Override
    public boolean mostrarListaEmpleados() {
        return sistemaGestionEmpresa.mostrarListaEmpleados();
    }

}
