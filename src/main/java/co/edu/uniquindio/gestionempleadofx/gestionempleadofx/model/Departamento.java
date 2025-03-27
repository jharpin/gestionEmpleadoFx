package co.edu.uniquindio.gestionempleadofx.gestionempleadofx.model;

import co.edu.uniquindio.gestionempleadofx.gestionempleadofx.services.*;

import java.util.ArrayList;

public class Departamento {
    private String nombreDepartamento;
    private String codigoDepartamento;
    private Proyecto proyectoAsociado;
    private Gerente gerenteAsociado;
    private ArrayList<Tecnico> listaTecnicos;

    public Departamento(String nombreDepartamento, String codigoDepartamento, Proyecto proyectoAsociado, Gerente gerenteAsociado) {
        this.nombreDepartamento = nombreDepartamento;
        this.codigoDepartamento = codigoDepartamento;
        this.proyectoAsociado = proyectoAsociado;
        this.gerenteAsociado = gerenteAsociado;
        this.listaTecnicos = new ArrayList<>();
    }
    public Departamento(){
    }
    
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }
    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }
    public Proyecto getProyectoAsociado(){
        return proyectoAsociado;
    }
    public void setProyectoAsociado(Proyecto proyectoAsociado){
        this.proyectoAsociado = proyectoAsociado;
    }
    public Gerente getGerenteAsociado(){
        return gerenteAsociado;
    }
    public void setGerenteAsociado(Gerente gerenteAsociado){
        this.gerenteAsociado = gerenteAsociado;
    }
    public ArrayList<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }
    public void setListaTecnicos(Tecnico listaTecnicos){
        this.listaTecnicos = new ArrayList<>();
    }
}
