package com.aluracursos.reservasvuelo.modelos;

public class Silla {
    // constantes
    public final static int clase_ejecutiva = 1;
    public final static int clase_economica = 2;
    public final static int ventana = 1;
    public final static int centro = 2;
    public final static int pasillo = 3;
    
    // atributos 
    private int numero;
    private int clase;
    private int ubicacion;
    private Pasajero pasajero;

    // constructor

    public Silla(int numero, int clase, int ubicacion) {
        this.numero = numero;
        this.clase = clase;
        this.ubicacion = ubicacion;
        this.pasajero = null;
    }

    // getters and setters
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getClase() {
        return this.clase;
    }
    public void setClase(int clase) {
        this.clase = clase;
    }

    public int getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    // metodos
    public void asignarPasajero(Pasajero p){
        this.pasajero = p;
    }

    public void desasignarPasajero(){
        this.pasajero = null;
    }

    public boolean sillaAsignada(){
        if (this.pasajero == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean sillaAsignadaPasajero(Pasajero p){
        if(this.pasajero == null){
            return false;
        }else if(this.pasajero.igualA(p)){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public String toString() {
        return """
                Datos del pasajero:
                %s
                ----------------------------
                Datos del vuelo:
                Clase: %s
                Ubicacion: %s
                Silla N°: %d
                """.formatted(getPasajero(),getClase(),getUbicacion(),getNumero());

    }

}
