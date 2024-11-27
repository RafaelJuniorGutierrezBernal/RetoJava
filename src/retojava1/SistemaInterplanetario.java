package retojava1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SistemaInterplanetario {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<String> planetas = new ArrayList<>(Arrays.asList(
            "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno")); 
    static ArrayList<Integer> distancias = new ArrayList<>(Arrays.asList(
            77, 41, 78, 628, 1275, 2723, 4351)); // Distancias sin la Tierra
    static String[] naves = { "Exploradora", "Carga pesada", "Velocidad maxima" };

    static double[] velocidades = { 20000.0, 15000.0, 30000.0 };

    static int naveSeleccionada = -1; // Aseguramos que inicialmente no hay nave seleccionada.
    
    static int pasajeros;

    static double gasolina, comida;

    
    static ArrayList<String> descripciones = new ArrayList<>(Arrays.asList(
            "Mercurio: El planeta más cercano al Sol, con una distancia promedio de 77 millones de km desde la Tierra.",
            "Venus: Similar en tamaño a la Tierra, con una distancia promedio de 41 millones de km desde la Tierra.",
            "Marte: Conocido como el planeta rojo, a una distancia promedio de 78 millones de km desde la Tierra.",
            "Júpiter: El planeta más grande del sistema solar, a una distancia promedio de 628 millones de km desde la Tierra.",
            "Saturno: Famoso por sus anillos, a una distancia promedio de 1,275 millones de km desde la Tierra.",
            "Urano: Un gigante de hielo, a una distancia promedio de 2,723 millones de km desde la Tierra.",
            "Neptuno: El planeta más lejano del Sol, a una distancia promedio de 4,351 millones de km desde la Tierra."));
    // Metodo para verificaciond de entradas
    public static int obtenerEntradaValida(int min, int max) {
        int entrada;
        while (true) {
            try {
                entrada = Integer.parseInt(scanner.nextLine());
                if (entrada >= min && entrada <= max) {
                    return entrada;
                }
                System.out.println("Por favor, ingrese un número entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
    }

    public static void seleccionDestino() {
        System.out.println("Seleccione un destino: ");
        for (int i = 0; i < planetas.size(); i++) {
            System.out.println((i + 1) + ". " + planetas.get(i));
        }
        System.out.println("Ingrese el número del planeta que desea visitar:");

        int seleccion = obtenerEntradaValida(1, planetas.size());
        System.out.println("Planeta seleccionado: " + planetas.get(seleccion - 1));
        System.out.println("Descripción: " + descripciones.get(seleccion - 1));

        // Confirmar la selección
        System.out.println("¿Está seguro de que desea viajar a " + planetas.get(seleccion - 1) + " (si/no)?");
        String confirmacion = scanner.nextLine();
        if (!confirmacion.equalsIgnoreCase("si")) {
            System.out.println("Selección de destino cancelada.");
            return;
        }

        naveSeleccionada = seleccion - 1;
    }

    public static void seleccionarNave() {
        System.out.println("Seleccione una nave: ");
        for (int i = 0; i < naves.length; i++) {
            System.out.println((i + 1) + ". " + naves[i] + " (velocidad: " + velocidades[i] + " km/h)");
        }
        System.out.println("Ingrese el número de la nave que desea utilizar:");

        int seleccion = obtenerEntradaValida(1, naves.length); // Aseguramos que el valor esté dentro del rango
        naveSeleccionada = seleccion - 1;
        System.out.println("Nave seleccionada: " + naves[naveSeleccionada]);
    }

    public static void ajustarRecursos(double tiempoHoras, int pasajeros) {
        // Calculamos los valores por defecto según el tiempo del viaje y el número de pasajeros
        double gasolinaCalculada = tiempoHoras * 100 * pasajeros; // Ejemplo de cálculo
        double comidaCalculada = tiempoHoras * 2 * pasajeros; // Ejemplo de cálculo
    
        // Mostramos los recursos calculados por defecto
        System.out.println("Recursos calculados automáticamente para el viaje:");
        System.out.println("Gasolina estimada: " + gasolinaCalculada + " litros");
        System.out.println("Comida estimada: " + comidaCalculada + " raciones");
    
        // Permitimos al usuario ajustar estos valores
        System.out.println("¿Deseas ajustar los recursos? (si/no)");
        String respuesta = scanner.nextLine();
    
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Ingrese la cantidad de combustible (litros) para el viaje:");
            gasolina = obtenerEntradaValida((int) gasolinaCalculada, 10000); // Ajuste de gasolina
            System.out.println("Ingrese la cantidad de comida (raciones) para el viaje:");
            comida = obtenerEntradaValida((int) comidaCalculada, 1000); // Ajuste de comida
            System.out.println("Recursos ajustados: Gasolina = " + gasolina + " litros, Comida = " + comida + " raciones.");
        } else {
            // Si el usuario no ajusta, mantenemos los valores calculados automáticamente
            gasolina = gasolinaCalculada;
            comida = comidaCalculada;
            System.out.println("Se utilizaron los valores predeterminados: Gasolina = " + gasolina
                    + " litros, Comida = " + comida + " raciones.");
        }
    }
    

    public static void iniciarSimulacion() {
        if (naveSeleccionada == -1) {
            System.err.println("Error: Debes seleccionar una nave antes de iniciar la simulación.");
            return;
        }
    
        if (naveSeleccionada >= 0 && naveSeleccionada < planetas.size()) {
            System.out.println("Ingrese el número de pasajeros:");
            pasajeros = obtenerEntradaValida(1, 100);
    
            double distancia = distancias.get(naveSeleccionada) * 1_000_000; // Convertimos la distancia a kilómetros
            double velocidad = velocidades[naveSeleccionada];
            double tiempoHoras = distancia / velocidad;
    
            if (tiempoHoras < 1) {
                tiempoHoras = 1; // Establecemos un mínimo de 1 hora
            }
    
            // Llamamos al método de ajuste de recursos
            ajustarRecursos(tiempoHoras, pasajeros);
    
            // Continuamos con la simulación
            System.out.println("Distancia al planeta: " + distancia + " km");
            System.out.println("Tiempo de viaje estimado: " + tiempoHoras + " horas");
            mostrarBarraDeProgreso(tiempoHoras, 0, gasolina, comida);
        }
    }

    public static void mostrarBarraDeProgreso(double tiempoTotal, double retraso, double gasolina, double comida) {
        int total = Math.max(1, (int) tiempoTotal + (int) retraso); // Aseguramos que el total sea al menos 1 hora

        System.out.println("Tiempo total del viaje (incluyendo retrasos): " + total + " horas.");

        int progreso = 0;
        int incremento = Math.max(1, total / 100); // Aseguramos que el incremento sea al menos 1

        while (progreso <= total) {
            int porcentaje = (progreso * 100) / total; // Calculamos el porcentaje real basado en "total"
            System.out.print("\rProgreso: [" + "=".repeat(porcentaje / 10) + " ".repeat(10 - porcentaje / 10) + "] "
                    + porcentaje + "%");

            if (porcentaje % 20 == 0 && porcentaje != 0) { // Cada 20% del progreso, consumimos recursos y generamos
                                                           // eventos
                // Reducimos los valores de gasolina y comida
                gasolina -= 100 * pasajeros;
                comida -= 20 * pasajeros;

                // Usamos DecimalFormat para redondear los valores a dos decimales
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.print(
                        " | Gasolina restante: " + df.format(gasolina) + " | Comida restante: " + df.format(comida));

                if (gasolina <= 0 || comida <= 0) {
                    System.out.println("\n¡Recursos insuficientes! La misión ha fracasado.");
                    return;
                }

                if (porcentaje < 100) { // Solo generamos eventos si no hemos completado el 100%
                    Random random = new Random();
                    double retrasoExtra = eventosAleatorios(random);
                    total += (int) retrasoExtra; // Aumentamos el total con el retraso adicional
                }
            }

            try {
                Thread.sleep(200); // Reducimos el tiempo de espera para acelerar el progreso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            progreso += incremento; // Avanzamos el progreso en bloques más grandes
        }
        System.out.println("\n¡Viaje completado!");
    }

    // Método para simular eventos aleatorios durante el viaje
    public static double eventosAleatorios(Random random) {
        int evento = random.nextInt(4);
        double retrasoExtra = 0;

        switch (evento) {
            case 0 -> {
                System.out.println("\n¡Falla en el sistema de navegación!");
                System.out.println("1. Intentar reparar el sistema.\n2. Continuar sin reparar.");
                int eleccion = obtenerEntradaValida(1, 2);
                retrasoExtra = eleccion == 1 ? 2 : 4;
            }
            case 1 -> {
                System.out.println("\n¡Lluvia de asteroides detectada!");
                System.out.println("1. Desviar el curso.\n2. Mantener el rumbo y arriesgar daños.");
                int eleccion = obtenerEntradaValida(1, 2);
                retrasoExtra = eleccion == 1 ? 3 : 5;
            }
            case 2 -> {
                System.out.println("\n¡Falta de combustible detectada!");
                System.out.println("1. Hacer una parada para recargar.\n2. Intentar llegar con lo que queda.");
                int eleccion = obtenerEntradaValida(1, 2);
                retrasoExtra = eleccion == 1 ? 3 : 6;
            }
            case 3 -> {
                System.out.println("\n¡Problemas de comunicación con la Tierra!");
                System.out.println("1. Detenerse para solucionar el problema.\n2. Continuar sin comunicación.");
                int eleccion = obtenerEntradaValida(1, 2);
                retrasoExtra = eleccion == 1 ? 2 : 1;
            }
        }

        System.out.println("Retraso adicional por evento: " + retrasoExtra + " horas.");
        return retrasoExtra;
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ INTERPLANETARIO ===");
            System.out.println("1. Seleccionar destino.");
            System.out.println("2. Seleccionar nave.");
            System.out.println("3. Iniciar simulación.");
            System.out.println("4. Salir.");
            opcion = obtenerEntradaValida(1, 4);

            switch (opcion) {
                case 1 -> seleccionDestino();
                case 2 -> seleccionarNave();
                case 3 -> iniciarSimulacion();
                case 4 -> System.out.println("Saliendo del programa...");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}
