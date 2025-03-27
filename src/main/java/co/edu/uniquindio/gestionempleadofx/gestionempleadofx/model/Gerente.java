package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model;

import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services.*;

public class Gerente extends Empleado {
    private Departamento departamentoAsociado;

    public Gerente(String nombre,
                   String id,
                   Proyecto proyectoAsociado,
                   Departamento departamentoAsociado) {
        super(nombre, id, proyectoAsociado);
        this.departamentoAsociado = departamentoAsociado;
    }
    public Gerente(){};
    public Departamento getDepartamentoAsociado() {
        return departamentoAsociado;
    }
    public void setDepartamentoAsociado(Departamento departamentoAsociado) {
        this.departamentoAsociado = departamentoAsociado;
    }
    public void setProyectoAsociado(Proyecto proyectoAsociado) {
        super.setProyectoAsociado(proyectoAsociado);

    }

    @Override
    public String contribuir() {
        return "el gerente:" + getNombre() + " a contribuido con los empleados";
    }
}




