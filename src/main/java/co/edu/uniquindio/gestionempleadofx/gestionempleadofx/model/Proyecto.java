package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model;
import java.util.ArrayList;
public class Proyecto {
    private String nombreProyecto;
    private String codigoProyecto;
    private ArrayList<Empleado> ListaEmpleadosAsignados;
    private ArrayList<Departamento>ListaDepartamentos;
    public Proyecto() {}
    public Proyecto(String nombreProyecto, String codigoProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.codigoProyecto = codigoProyecto;
        this.ListaEmpleadosAsignados = new ArrayList<>();
        this.ListaDepartamentos = new ArrayList<>();
    }
    public String getNombreProyecto() {
        return nombreProyecto;
    }
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    public String getCodigoProyecto() {
        return codigoProyecto;
    }
    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }
    public ArrayList<Empleado> getListaEmpleadosAsignados() {
        return ListaEmpleadosAsignados;
    }
    public void setListaEmpleadosAsignados(){

        this.ListaEmpleadosAsignados = new ArrayList<>();
    }
    public ArrayList<Departamento> getListaDepartamentos(Departamento listaDepartamento) {
        return ListaDepartamentos;
    }
    public void setListaDepartamentos(){
        this.ListaDepartamentos = new ArrayList<>();
    }
    public String toString(){
        return "proyecto= "+nombreProyecto+", codigoProyecto= "+codigoProyecto;
    }
}