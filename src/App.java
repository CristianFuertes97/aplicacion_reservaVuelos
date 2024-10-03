import java.util.Scanner;

import com.aluracursos.reservasvuelo.modelos.Avion;
import com.aluracursos.reservasvuelo.modelos.Pasajero;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // Creacion de la instancia avion
        var avion = new Avion();
        // sitema del avion
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("***********Bienvenidos al sistema****************");
            System.out.println("""
                    Ingrese la opcion:
                    1.Reservar silla
                    2.Elminar reservacion
                    3.Consultar si tiene reservacion 
                    4.Información de ocupacion del Avion
                    0.Salir
                    """);
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                // codigo para reservar una silla
                    System.out.println("Registro de datos personales del pasajero");
                    System.out.println("Ingrese su nombre");
                    String name = sc.next();
                    System.out.println("Ingrese su cedula");
                    int cc = sc.nextInt();

                    // creamos una instacia de pasajero
                    var pasajero1 = new Pasajero(cc, name);
                    // Verificamos si el pasajero ya tiene silla reservada 
                    if (avion.buscarPasajero(pasajero1)!= null) {
                        System.out.println("Este numero de cedula ya tiene reservado una silla");

                    }
                    // Si no tiene reservado ingresamos los datos correspondientes para reservar la silla
                    else{
                        System.out.println("""
                                Tipo de clase a viajar:
                                1. Ejecutiva
                                2.Economica
                                """);
                                int letra =sc.nextInt();
                                if (letra == 1) {
                                    System.out.println("""
                                            Ubicacion de su asiento:
                                            1.Ventana
                                            3.Pasillo
                                            """);
                                    int ubicacion = sc.nextInt();
                                    avion.asignarSilla(1,ubicacion ,pasajero1);
                                }else{
                                    System.out.println("""
                                            Ubicacion de su asiento:
                                            1.Ventana
                                            2.Centro
                                            3.Pasillo
                                            """);
                                    int ubicacion = sc.nextInt();
                                    avion.asignarSilla(2,ubicacion ,pasajero1);
                                }
                        
                    }
                    break;
                case 2:
                // codigo para eliminar una reservacion de un usuario que anteriormente reservó
                    System.out.println("ingrese la cedula del pasajero a eliminar la reservacion");
                    int cedula = sc.nextInt();
                    Pasajero pasajero = new Pasajero(cedula);
                    // verificamos si el usuario si tiene reservacion y eliminamos
                    if (avion.buscarPasajero(pasajero)!= null) {
                        avion.desasignarSilla(pasajero);
                        System.out.println("Se ha eliminado tu reservacion");
                    }else{
                        System.out.println("El pasajero no ingresado no tiene reserva");
                    }
                    break;
                case 3:
                    // codigo para consultar si un usuario tiene reservado una silla
                    System.out.println("ingrese la cedula del pasajero para consultar si tiene reservacion");
                    int valor = sc.nextInt();
                    Pasajero pasajeroBuscar = new Pasajero(valor);
                    if (avion.buscarPasajero(pasajeroBuscar)!= null) {
                        System.out.println(avion.buscarPasajero(pasajeroBuscar));
                    }else{
                        System.out.println("El pasajero no tiene silla reservada");
                    }
                    break;
                case 4:
                    System.out.println("Sillas ejecutivas ocupadas: "+avion.contarSillasEjecutivasOcupadas());
                    System.out.println("Sillas economicos ocupadas: "+avion.contarSillasEconomicasOcupadas());
                    System.out.println("Porcentaje de ocupacion del avion: "+avion.calcularPorcentajeOcupacion()+"%");

                default:
                    System.out.println("Saliendo del sistema");
                    break;
            }
        }
        sc.close();
        
        
        

       
    }
}
