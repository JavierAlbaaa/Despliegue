/**
 * Funciones matemáticas básicas (métodos estáticos).
 */
public class Calculadora {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    /** Divide a entre b. Lanza excepción si b es 0. */
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }
        return a / b;
    }

    /** Factorial de n (n!) con un bucle for. */
    public static long factorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /** Devuelve true si n es primo. */
    public static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /** Devuelve el n-ésimo número de Fibonacci (0, 1, 1, 2, 3, 5...). */
    public static long fibonacci(int n) {
        long anterior = 0;
        long actual = 1;
        for (int i = 0; i < n; i++) {
            long siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }
        return anterior;
    }
}
