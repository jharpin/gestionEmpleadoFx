package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model;

import co.edu.uniquindio.GestionEmpleados.services.IContribuyente;

public class Empleado implements IContribuyente {
    private String nombre;
    private String id;
    private Proyecto proyectoAsociado;
    public Empleado() {}
    Empleado(String nombre, String id,
             Proyecto proyectoAsociado) {
        this.nombre = nombre;
        this.id = id;
        this.proyectoAsociado = proyectoAsociado;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public Proyecto getProyectoAsociado(){
        return proyectoAsociado;
    }
    public void setProyectoAsociado(Proyecto proyectoAsociado){
        this.proyectoAsociado = proyectoAsociado;
    }
    @Override
    public String toString() {
        return "Empleado{id='" + id + "', nombre='" + nombre + "}";
    }

    @Override
    public String contribuir() {
        return "el empleado ha contribuido con lo necesario";
    }
    public static EmpleadoBuilder builder(){
        return new EmpleadoBuilder();
    }

}
