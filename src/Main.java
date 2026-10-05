import java.util.Scanner;

/**
 * Programa principal: menú de consola que usa el resto de clases
 * ({@link Calculadora}, {@link Cadenas} y {@link Estudiante}).
 * <p>
 * El menú se repite hasta que el usuario elige la opción 0 (salir).
 * </p>
 */
public class Main {

    /**
     * Punto de entrada del programa. Muestra el menú, lee la opción elegida
     * y ejecuta la operación correspondiente hasta que se elige salir.
     *
     * @param args argumentos de la línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Elige una opción: ");

            switch (opcion) {
                case 1:
                    int a = leerEntero(sc, "Primer número: ");
                    int b = leerEntero(sc, "Segundo número: ");
                    System.out.println("Resultado: " + Calculadora.sumar(a, b));
                    break;
                case 2:
                    double x = leerDecimal(sc, "Dividendo: ");
                    double y = leerDecimal(sc, "Divisor: ");
                    try {
                        System.out.println("Resultado: " + Calculadora.dividir(x, y));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    int n = leerEntero(sc, "Número: ");
                    System.out.println(n + "! = " + Calculadora.factorial(n));
                    break;
                case 4:
                    int p = leerEntero(sc, "Número: ");
                    System.out.println(p + (Calculadora.esPrimo(p) ? " es primo" : " no es primo"));
                    break;
                case 5:
                    int f = leerEntero(sc, "Posición: ");
                    System.out.println("Fibonacci(" + f + ") = " + Calculadora.fibonacci(f));
                    break;
                case 6:
                    System.out.print("Texto: ");
                    String frase = sc.nextLine();
                    System.out.println(Cadenas.esPalindromo(frase) ? "Es palíndromo" : "No es palíndromo");
                    break;
                case 7:
                    System.out.print("Texto: ");
                    String texto = sc.nextLine();
                    System.out.println("Vocales: " + Cadenas.contarVocales(texto));
                    break;
                case 8:
                    gestionarEstudiante(sc);
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        sc.close();
    }

    /**
     * Muestra por consola el menú con todas las opciones disponibles.
     */
    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ =====");
        System.out.println("1. Sumar");
        System.out.println("2. Dividir");
        System.out.println("3. Factorial");
        System.out.println("4. ¿Es primo?");
        System.out.println("5. Fibonacci");
        System.out.println("6. ¿Es palíndromo?");
        System.out.println("7. Contar vocales");
        System.out.println("8. Crear estudiante y calcular media");
        System.out.println("0. Salir");
    }

    /**
     * Pide por consola los datos de un estudiante (nombre, edad y tres notas),
     * lo crea y muestra sus datos, su media y su nota máxima.
     * <p>
     * Las notas que no estén entre 0 y 10 se ignoran y se avisa al usuario.
     * </p>
     *
     * @param sc objeto {@link Scanner} usado para leer los datos de la consola
     */
    private static void gestionarEstudiante(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        int edad = leerEntero(sc, "Edad: ");
        Estudiante e = new Estudiante(nombre, edad);

        for (int i = 1; i <= 3; i++) {
            double nota = leerDecimal(sc, "Nota " + i + " (0-10): ");
            if (!e.anadirNota(nota)) {
                System.out.println("Nota no válida, se ignora.");
            }
        }
        System.out.println(e);
        System.out.println("Nota máxima: " + e.notaMaxima());
    }

    /**
     * Muestra un mensaje por consola y lee un número entero escrito por el usuario.
     *
     * @param sc      objeto {@link Scanner} usado para leer la entrada
     * @param mensaje texto que se muestra al usuario antes de leer
     * @return el número entero introducido
     * @throws NumberFormatException si lo escrito no es un número entero válido
     */
    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(sc.nextLine().trim());
    }

    /**
     * Muestra un mensaje por consola y lee un número decimal escrito por el usuario.
     *
     * @param sc      objeto {@link Scanner} usado para leer la entrada
     * @param mensaje texto que se muestra al usuario antes de leer
     * @return el número decimal introducido
     * @throws NumberFormatException si lo escrito no es un número decimal válido
     */
    private static double leerDecimal(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(sc.nextLine().trim());
    }
}