package com.aluracursos.reservasvuelo.modelos;

public class Avion {
    // Constantes
    public final static int silla_ejecutiva = 8;
    public final static int silla_economica = 42;

    // Atributos
    private Silla[] sillasEjecutivas;
    private Silla[] sillasEconomicas;

    // getters and setters
    public Silla[] getSillasEjecutivas() {
        return this.sillasEjecutivas;
    }

    public Silla[] getSillasEconomicas() {
        return this.sillasEconomicas;
    }

    // Constructor
    public Avion(){

        sillasEjecutivas = new Silla[silla_ejecutiva];
        sillasEconomicas = new Silla[silla_economica];

        // creacion de sillas ejecutivas
        sillasEjecutivas[0] = new Silla(1,Silla.clase_ejecutiva, Silla.ventana);
        sillasEjecutivas[1] = new Silla(2,Silla.clase_ejecutiva, Silla.pasillo);
        sillasEjecutivas[2] = new Silla(3,Silla.clase_ejecutiva, Silla.pasillo);
        sillasEjecutivas[3] = new Silla(4,Silla.clase_ejecutiva, Silla.ventana);
        sillasEjecutivas[4] = new Silla(5,Silla.clase_ejecutiva, Silla.ventana);
        sillasEjecutivas[5] = new Silla(6,Silla.clase_ejecutiva, Silla.pasillo);
        sillasEjecutivas[6] = new Silla(7,Silla.clase_ejecutiva, Silla.pasillo);
        sillasEjecutivas[7] = new Silla(8,Silla.clase_ejecutiva, Silla.ventana);

        // creacion de sillas economicas
        for (int i = 9,j = 0; i <= 50; j++,i++){
            if (i % 6 == 3 || i % 6 == 2) {
                sillasEconomicas[j] = new Silla(i,Silla.clase_economica,Silla.ventana);
            }else if (i % 6 == 4 || i % 6 == 1){
                sillasEconomicas[j] = new Silla(i,Silla.clase_economica,Silla.centro);
            }else if (i % 6 == 5 || i % 6 == 0){
                sillasEconomicas[j] = new Silla(i, Silla.clase_economica, Silla.pasillo);
            }
        }


    }
    public void mostrarListaEjecutivas(){
        for (Silla lista : sillasEjecutivas) {
            System.out.println(lista);
        }
    }

    // metodos
    
    public Silla asignarSilla(int clase, int ubicacion, Pasajero pasajero){
        Silla silla = null;
        if(clase == 1){
            silla = buscarSillaEjecutivaLibre(ubicacion);
        }else if(clase == 2){
            silla = buscarSillaEconomicaLibre(ubicacion);
        }
        if(silla != null){
             silla.asignarPasajero(pasajero);

        }
        return silla;
    
    }

    public Silla buscarSillaEjecutivaLibre(int ubicacion){
        
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < silla_ejecutiva && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == ubicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;

    }

    public Silla buscarSillaEconomicaLibre(int ubicacion){
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < silla_economica && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == ubicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    public Silla buscarPasajero(Pasajero pasajero){
        Silla silla = buscarPasajeroEjecutivo(pasajero);
        if (null == silla) {
            silla = buscarPasajeroEconomico(pasajero);
        }
        return silla;

    }
    public Silla buscarPasajeroEjecutivo(Pasajero pasajero){
        boolean encontrado = false;
        Silla silla = null;
        for (int i = 0; i < silla_ejecutiva && !encontrado; i++) {
            silla = sillasEjecutivas[i];
            if (silla.sillaAsignada() && silla.getPasajero().igualA(pasajero)){
                encontrado = true;
            }
        }
        if(encontrado){
            return silla;
        }else{
            return null;
        }
    }

    public Silla buscarPasajeroEconomico(Pasajero pasajero){
        boolean encontrado = false;
        Silla silla = null;
        for (int i=0; i< silla_economica && !encontrado; i++) {
            silla = sillasEconomicas[i];

            if (silla.sillaAsignada() && silla.getPasajero().igualA(pasajero)){
                encontrado = true;
            }
        }
        if(encontrado){
            return silla;
        }else{
            return null;
        }
    }
    
    public int contarSillasEjecutivasOcupadas(){
        int contador = 0;
        for (Silla silla : sillasEjecutivas) {
            if(silla.sillaAsignada()){
                contador++;
            }
        }
        return contador;
    }

    public int contarSillasEconomicasOcupadas(){
        int contador = 0;
        for (Silla silla : sillasEconomicas) {
            if (silla.sillaAsignada()) {
                contador++;
            }
        }
        return contador;
    }

    public boolean desasignarSilla(Pasajero pasajero){
        Silla silla =buscarPasajero(pasajero);
        if (silla != null){
            silla.desasignarPasajero();
            return true;
        }else{
            return false;
        }
    }
    public double calcularPorcentajeOcupacion(){
        int resultado = contarSillasEconomicasOcupadas() + contarSillasEjecutivasOcupadas();
        double porcentaje = (double)resultado / 50*100;
        return porcentaje;
    }

}
