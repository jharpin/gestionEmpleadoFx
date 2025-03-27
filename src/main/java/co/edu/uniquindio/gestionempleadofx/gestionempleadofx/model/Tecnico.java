package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model;
public class Tecnico extends Empleado {
    private Departamento departamentoAsociado;
    private String especialidad;
    public Tecnico(String nombre, String id,Proyecto proyectoAsociado,Departamento departamentoAsociado,String especialidad) {
        super(nombre, id,proyectoAsociado);
        this.departamentoAsociado = departamentoAsociado;
        this.especialidad = especialidad;
    }
    public Tecnico(){
    }
    public Tecnico(String nombre, String id,Proyecto proyectoAsociado,Departamento departamentoAsociado) {
        super(nombre, id,proyectoAsociado);
        this.departamentoAsociado = departamentoAsociado;
    }
    public Departamento getDepartamentoAsociado() {
        return departamentoAsociado;
    }
    public void setDepartamentoAsociado(Departamento departamentoAsociado) {
        this.departamentoAsociado = departamentoAsociado;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    @Override
    public String contribuir() {
        return "El técnico " + getNombre() + " contribuye con su especialidad en: " + especialidad;
    }

}