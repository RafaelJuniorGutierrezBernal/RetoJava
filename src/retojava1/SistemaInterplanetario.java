package retojava1;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SistemaInterplanetario {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> planetas = new ArrayList<>(
            Arrays.asList("Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"));

    static ArrayList<Integer> distancias = new ArrayList<>(Arrays.asList(
       41, // Venus, millones de km en todos
            77, // Mercurio
            78, // Marte
            628, // Júpiter
            1275, // Saturno
            2723, // Urano
            4351 // Neptuno
    ));
    static int pasajeros;
    static String[] naves = { "Exploradora", "Carga pesada", "Velocidad maxima" };
    static double[] velocidades = { 20000.0, 15000.0, 30000.0 };
    
       static ArrayList<String> descripciones = new ArrayList<>(Arrays.asList(
                "Mercurio: El planeta más cercano al Sol, con una distancia promedio de 77 millones de km desde la Tierra.",
                "Venus: Similar en tamaño a la Tierra, con una distancia promedio de 41 millones de km desde la Tierra.",
                "Marte: Conocido como el planeta rojo, a una distancia promedio de 78 millones de km desde la Tierra.",
                "Júpiter: El planeta más grande del sistema solar, a una distancia promedio de 628 millones de km desde la Tierra.",
                "Saturno: Famoso por sus anillos, a una distancia promedio de 1,275 millones de km desde la Tierra.",
                "Urano: Un gigante de hielo, a una distancia promedio de 2,723 millones de km desde la Tierra.",
                "Neptuno: El planeta más lejano del Sol, a una distancia promedio de 4,351 millones de km desde la Tierra."));
    ;

    
        

    // Me traigo el escaner creado arriba para no tener que crear otro
    public static int ingresoPasajeros(Scanner scanner) {
        System.out.println("Ingrese el numero de pasajeros para la nave");
        int numeroPasajeros = scanner.nextInt();
        return numeroPasajeros;
    }

    

    public static void seleccionDestino(Scanner scanner) {
        System.out.println("Seleccione un destino: ");
        for (int i = 0; i < descripciones.size(); i++) {
            System.out.println((i + 1) + ". " + descripciones.get(i).split(":")[0]);
        }

        System.out.println("Ingrese el numero del planeta que desea visitar: ");
        int seleccion = scanner.nextInt();

        if (seleccion > 0 && seleccion <= descripciones.size()) {
            System.out.println("Planeta seleccionado: " + descripciones.get(seleccion - 1));
            System.out.println("Planeta seleccionado correctamente");
        } else {
            System.out.println("Seleccion invalida. Por favor ingresar un numero valido");
        }
        
    }

    public static void calculoDistanciaYtiempo(int indicePlaneta, ArrayList<Integer> distancias, Scanner scanner) {
        System.out.println("Seleccione una nave: ");
        for (int i = 0; i < naves.length; i++) {
            System.out.println((i + 1) + ". " + naves[i] + " (velocidad: " + velocidades[i] + " km/h)");

        }
        System.out.println("Ingrese el numero de la nave que desea utilizar: ");
        int seleccioneNave = scanner.nextInt();

        if (seleccioneNave > 0 && seleccioneNave <= naves.length) {
            double distancia = distancias.get(indicePlaneta) * 1_000_000;// convertir a km
            double velocidad = velocidades[seleccioneNave - 1];
            double tiempoHoras = distancia / velocidad;

            System.out.println("Distancia al planeta: " + distancia + " km");
            System.out.println("Tiempo de viaje: " + tiempoHoras + " horas");

            gestionRecursos(tiempoHoras, indicePlaneta);   
        } else {
            System.out.println("Seleccion invalida. porfavor, ingrese un numero valido");
        }
        
    }


    public static void gestionRecursos(double tiempoHoras, int indicePlaneta) {
        double[] consumoGasolina = {100, 90, 110, 120, 130, 140, 150}; // consumo de gasolina por hora segun planeta relativamente
        double[] consumoComida = {2, 1.8, 2.2, 2.4, 2.6, 2.8, 3}; //consumo de comida por hora segun el planeta
       
        double gasolina = tiempoHoras * consumoGasolina[indicePlaneta]; // Ejemplo: 100 litros por hora
        double comida = tiempoHoras * consumoComida[indicePlaneta]; // Ejemplo: 2 raciones por hora

        
        System.out.println("Gasolina necesaria: " + gasolina + " litros");
        System.out.println("Comida necesaria: " + comida + " raciones");
    }
    // se usa la clase Random para elegir entre varias opciones aleatorias 
    public static void eventosAleatorios(Random random) {
     int evento = random.nextInt(5); 
        switch(evento){
            case 0:
                System.out.println("Alerta....Falla en el sistema!!");
                
                break;
            case 1:
                 System.out.println("Alerta...Falta de combustible!!");
                break;
            case 2:
                 System.out.println("Alerta...Lluvia de asteroides!!");
                break;
            case 3:
                 System.out.println("Alerta...Desvio a la derecha!!");
                break;
            case 4:
                 System.out.println("Alerta...Desvio a la izquierda!!");
                break;
            case 5:
                 System.out.println("Alerta...Mala comunicacion con la tierra!!");
                break;
        }
    }

    public static void estadoViaje() {

    }

    public static void mostrarMenu() {

    }

    public static void mostrarBarraDeProgreso() {
        int total = 100; // Total del viaje
        int progreso = 0;
        while (progreso <= total) {
            // mostrar la barra de progreso
            System.out.print("\rProgreso: [" + "=".repeat(progreso / 10) + " ".repeat((total - progreso) / 10) + "] "
                    + progreso + "%");

            // simular el progreso del viaje
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progreso++;
        }

        System.out.println("\n Viaje completado. FELICIDADES!!");
    }
  }


