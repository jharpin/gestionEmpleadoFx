package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model;

import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services.*;
import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model.builder.EmpleadoBuilder;

import java.util.ArrayList;
import java.util.Collections;

public class SistemaGestionEmpresa implements ImodelFactoryServices,IProyectoCrud,IGerenteCrud, ITecnicoCrud,IDepartamentoCrud {
    private ArrayList<Empleado> Empleados;
    private ArrayList<Tecnico> tecnicos;
    private ArrayList<Gerente> gerentes;
    private ArrayList<Departamento> departamentos;
    private ArrayList<Proyecto> proyectos;

    public SistemaGestionEmpresa() {
        /// inicializacion de listas
        this.Empleados = new ArrayList<>();
        this.tecnicos = new ArrayList<>();
        this.gerentes = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        this.proyectos = new ArrayList<>();
    }

    /// getters and setters
    public ArrayList<Empleado> getEmpleados() {
        return Empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.Empleados = empleados;
    }

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(ArrayList<Gerente> gerentes) {
        this.gerentes = gerentes;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }


    @Override
    public boolean crearEmpleado(EmpleadoBuilder NuevoEmpleado) {
        System.out.println("Creando Empleado");
        Empleado nuevoEmpleado=NuevoEmpleado.build();
        if(obtenerEmpleado(nuevoEmpleado.getId())==null){
            Empleados.add(nuevoEmpleado);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarEmpleado(String id) {
        return Empleados.removeIf(empleado -> empleado.getId().equals(id));
    }


    @Override
    public boolean ActualizarEmpleado(String id, String nombre, Proyecto proyectoAsociado) {
        Empleado empleado = obtenerEmpleado(id);
        if (empleado != null) {
            empleado.setId(id);
            empleado.setNombre(nombre);
            empleado.setProyectoAsociado(proyectoAsociado);
            return true;
        }
        return false;
    }

    @Override
    public Empleado obtenerEmpleado(String id) {
        for (Empleado empleado : Empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }

    /// CRUD Proyecto
    public boolean crearProyecto(String nombreProyecto, String codigoProyecto, Departamento departamentoAsociado, Empleado empleadosAsignado) {
        Proyecto nuevoProyecto = new Proyecto();
        nuevoProyecto.setNombreProyecto(nombreProyecto);
        nuevoProyecto.setCodigoProyecto(codigoProyecto);
        nuevoProyecto.setListaDepartamentos();
        nuevoProyecto.setListaEmpleadosAsignados();
        if (proyectos == null) {
            proyectos = new ArrayList<>();
        }
        proyectos.add(nuevoProyecto);
        return true;
    }

    @Override
    public boolean modificarProyecto(String nombreProyecto, String codigoProyecto, Empleado listaEmpleados, Departamento listaDepartamento) {
        Proyecto nuevoProyecto = obtenerProyecto(codigoProyecto);
        if (nuevoProyecto != null) {
            nuevoProyecto.setNombreProyecto(nombreProyecto);
            nuevoProyecto.setCodigoProyecto(codigoProyecto);
            nuevoProyecto.setListaDepartamentos();
            nuevoProyecto.setListaEmpleadosAsignados();
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarProyecto(String codigoProyecto) {
        return proyectos.removeIf(proyecto -> proyecto.getCodigoProyecto().equals(codigoProyecto));
    }

    @Override
    public Proyecto obtenerProyecto(String codigoProyecto) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getCodigoProyecto().equals(codigoProyecto)) {
                return proyecto;
            }
        }
        return null;
    }

    ///  asociacion gerente proyecto
    @Override
    public boolean agregarProyectoAsociadaGerente(String id) {
        Proyecto proyectoAsociado = new Proyecto("manzana", "abc");
        for (Gerente gerente : getGerentes()) {
            if (gerente.getId().equals(id)) {
                gerente.setProyectoAsociado(proyectoAsociado);
            }
        }
        return false;
    }

    /// CRUD Gerente
    @Override
    public boolean crearGerente(String nombre, String id, Proyecto proyectoAsociado, Departamento departamentoAsociado) {
        Gerente gerenteExistente = obtenerGerente(id);
        if (gerenteExistente == null) {
            Gerente gerente = new Gerente(nombre, id, proyectoAsociado, departamentoAsociado);
            gerentes.add(gerente);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarGerente(String nombre, String id, Proyecto proyectoAsociado, Departamento departamentoAsociado) {
        Gerente gerente = obtenerGerente(id);
        if (gerente != null) {
            gerente.setId(id);
            gerente.setNombre(nombre);
            gerente.setProyectoAsociado(proyectoAsociado);
            gerente.setDepartamentoAsociado(departamentoAsociado);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarGerente(String id) {
        return gerentes.removeIf(gerente -> gerente.getId().equals(id));
    }

    @Override
    public Gerente obtenerGerente(String id) {
        for (Gerente gerente : gerentes) {
            if (gerente.getId().equals(id)) {
                return gerente;
            }
        }
        return null;
    }

    @Override
    public boolean crearTecnico(String nombre, String id, Proyecto proyectoAsociado, Departamento departamentoAsociado, String especialidad) {
        Tecnico tecnicoExistente = obtenerTecnico(id);
        if (tecnicoExistente == null) {
            Tecnico tecnico = new Tecnico(nombre, id, proyectoAsociado, departamentoAsociado, especialidad);
            tecnicos.add(tecnico);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarTecnico(String nombre, String id, Proyecto proyectoAsociado, Departamento departamentoAsociado, String especialidad) {
        Tecnico tecnico = obtenerTecnico(id);
        if (tecnico != null) {
            tecnico.setId(id);
            tecnico.setNombre(nombre);
            tecnico.setProyectoAsociado(proyectoAsociado);
            tecnico.setDepartamentoAsociado(departamentoAsociado);
            tecnico.setEspecialidad(especialidad);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarTecnico(String id) {
        return tecnicos.removeIf(tecnico -> tecnico.getId().equals(id));
    }

    @Override
    public Tecnico obtenerTecnico(String id) {
        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getId().equals(id)) {
                return tecnico;
            }
        }
        return null;
    }

    @Override
    public boolean crearDepartamento(String nombreDepartamento, String codigoDepartamento, Gerente gerenteAsociado, Proyecto proyectoAsociado, Tecnico listaTecnico) {
        Departamento nuevoDepartamento = new Departamento();
        nuevoDepartamento.setNombreDepartamento(nombreDepartamento);
        nuevoDepartamento.setCodigoDepartamento(codigoDepartamento);
        nuevoDepartamento.setProyectoAsociado(proyectoAsociado);
        nuevoDepartamento.setGerenteAsociado(gerenteAsociado);
        nuevoDepartamento.setListaTecnicos(listaTecnico);
        nuevoDepartamento.setProyectoAsociado(proyectoAsociado);
        ///nuevoDepartamento.setGerenteAsociado();
        if (departamentos == null) {
            departamentos = new ArrayList<>();
        }
        departamentos.add(nuevoDepartamento);
        return true;
    }

    @Override
    public boolean actualizarDepartamento(String nombreDepartamento, String codigoDepartamento, Gerente gerenteAsociado, Proyecto proyectoAsociado, Tecnico listaTecnicos) {
        Departamento departamento = ObtenerDepartamento(codigoDepartamento);
        if (departamento != null) {
            departamento.setNombreDepartamento(nombreDepartamento);
            departamento.setCodigoDepartamento(codigoDepartamento);
            departamento.setProyectoAsociado(proyectoAsociado);
            departamento.setGerenteAsociado(gerenteAsociado);
            departamento.setListaTecnicos(listaTecnicos);

        }
        return false;
    }

    @Override
    public Departamento ObtenerDepartamento(String codigoDepartamento) {
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigoDepartamento().equals(codigoDepartamento)) {
                return departamento;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarDepartamento(String codigoDepartamento) {
        //  Verificar que la lista no sea null
        if (departamentos == null || departamentos.isEmpty()) {
            System.out.println(" No hay departamentos registrados.");
            return false;
        }
        //  Buscar el empleado por ID
        for (Departamento departamento : departamentos) {
            if (departamento.getCodigoDepartamento().equals(codigoDepartamento)) {
                departamentos.remove(departamento); //  Eliminar de la lista
                System.out.println(" Departamento con ID " + codigoDepartamento + " eliminado correctamente.");
                return true;
            }
        }
        System.out.println(" No se encontró un Departamento con ID " + codigoDepartamento);
        return false;
    }

    /// Mostrar informacion empresa
    @Override
    public void mostrarInfoEmpresa() {
        System.out.println("\n--- Información de la Empresa ---");
        //mostrar proyectos
        System.out.println("\n Proyectos: ");
        for (Proyecto proyecto : getProyectos()) {
            System.out.println("    Nombre: " + proyecto.getNombreProyecto() +
                    ", codigo " + proyecto.getCodigoProyecto());
        }

        //  Mostrar empleados
        System.out.println("\n Empleados:");
        for (Empleado empleado : getEmpleados()) {
            System.out.println("   - Nombre: " + empleado.getNombre() +
                    ", ID: " + empleado.getId() +
                    ", Proyecto: " + (empleado.getProyectoAsociado() != null ? empleado.getProyectoAsociado().getNombreProyecto() : "Sin proyecto"));
        }

        //  Mostrar técnicos
        System.out.println("\n Técnicos:");
        for (Tecnico tecnico : getTecnicos()) {
            System.out.println("   - Nombre: " + tecnico.getNombre() +
                    ", ID: " + tecnico.getId() +
                    ", Especialidad: " + tecnico.getEspecialidad() +
                    ", Proyecto: " + (tecnico.getProyectoAsociado() != null ? tecnico.getProyectoAsociado().getNombreProyecto() : "Sin proyecto"));
        }

        //  Mostrar gerentes
        System.out.println("\n Gerentes:");
        for (Gerente gerente : getGerentes()) {
            System.out.println("   - Nombre: " + gerente.getNombre() +
                    ", ID: " + gerente.getId() +
                    ", Departamento: " + (gerente.getDepartamentoAsociado() != null ? gerente.getDepartamentoAsociado().getNombreDepartamento() : "Sin departamento") +
                    ", Proyecto: " + (gerente.getProyectoAsociado() != null ? gerente.getProyectoAsociado().getNombreProyecto() : "Sin proyecto"));
        }

        //  Mostrar departamentos
        System.out.println("\n Departamentos:");
        for (Departamento departamento : getDepartamentos()) {
            System.out.println("   - Nombre: " + departamento.getNombreDepartamento() +
                    ", Código: " + departamento.getCodigoDepartamento() +
                    ", Proyecto Asociado: " + (departamento.getProyectoAsociado() != null ? departamento.getProyectoAsociado().getNombreProyecto() : "Ninguno"));
        }

    }

    @Override
    public boolean listarGerentesYProyectos() {
        if (gerentes.isEmpty()) {
            System.out.println("No hay gerentes registrados.");
            return false;
        }
        for (Gerente gerente : gerentes) {
            String nombre = gerente.getNombre();
            String id = gerente.getId();
            /// ? es una condiconal if- else en este caso si proyectoAsociado es nulo: es sin proyecto asignado
            String nombreProyecto = (gerente.getProyectoAsociado() != null)
                    ? gerente.getProyectoAsociado().getNombreProyecto()
                    : "Sin proyecto asignado";
            /// este seria el else: muestra el proyecto
            System.out.println("Gerente: " + nombre + " (ID: " + id + "), Proyecto: " + nombreProyecto);
        }
        return false;
    }

    @Override
    public boolean tecnicoPerteneceProyecto() {
        if (tecnicos.isEmpty()) {
            System.out.println("No hay tecnicos registrados.");
            return false;
        }
        for (Tecnico tecnico : tecnicos) {
            String nombre = tecnico.getNombre();
            String id = tecnico.getId();
            /// ? es una condiconal if- else en este caso si proyectoAsociado es nulo: es sin proyecto asignado
            String nombreProyecto = (tecnico.getProyectoAsociado() != null)
                    ? tecnico.getProyectoAsociado().getNombreProyecto()
                    : "Sin proyecto asignado";
            /// este seria el else: muestra el proyecto
            System.out.println("Tecnico: " + nombre + " (ID: " + id + "), Proyecto: " + nombreProyecto);
        }
        return false;
    }

    @Override
    public boolean buscarPropietarioVocales() {
        System.out.println("\n📌 Empleados con más de 3 vocales en su nombre:");
        for (Empleado empleado : getEmpleados()) {
            if (contarVocales(empleado.getNombre()) < 3) {
                System.out.println("   - " + empleado.getNombre() + " (ID: " + empleado.getId() + ")");
            }
        }
        return false;
    }
    private int contarVocales(String nombre) {
        int contador = 0;
        String vocales = "sebas";

        // Convertir el nombre a minúsculas para hacer la comparación uniforme
        nombre = nombre.toLowerCase();

        // Recorrer el nombre y verificar si cada letra es una vocal
        for (int i = 0; i < nombre.length(); i++) {
            char letra = nombre.charAt(i);

            // Recorrer las vocales y comparar una por una
            for (int j = 0; j < vocales.length(); j++) {
                if (letra == vocales.charAt(j)) {
                    contador++;
                    break; // Salir del loop cuando encuentra una vocal
                }
            }
        }
        return contador;
    }
    @Override
    public boolean mostrarListaEmpleados() {
        Collections.reverse(getEmpleados());
        System.out.println("\n Lista de empleados:");
        for(Empleado empleado : getEmpleados()){
            System.out.println(empleado);
        }
        return false;
    }
}


