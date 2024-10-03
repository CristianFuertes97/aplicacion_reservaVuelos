package com.aluracursos.reservasvuelo.modelos;

public class Pasajero {

    // atrributos
    private int cedula;
    private String nombre;

    // Constructor
    public Pasajero(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Pasajero(int cedula){
        this.cedula = cedula;
    }
    // Getters and setters

    public int getCedula() {
        return this.cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // metodos
    public boolean igualA(Pasajero otropasajero){
        if(this.cedula == otropasajero.getCedula()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return """
                Nombre: %s
                Cedula: %d
                """.formatted(getNombre(),getCedula());
    }

}