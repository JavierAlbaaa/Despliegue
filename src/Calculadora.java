/**
 * Funciones matemáticas básicas (métodos estáticos).
 * <p>
 * Incluye operaciones aritméticas, factorial, comprobación de números
 * primos y la sucesión de Fibonacci.
 * </p>
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     *
     * @param a primer sumando
     * @param b segundo sumando
     * @return el resultado de {@code a + b}
     */
    public static int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros.
     *
     * @param a minuendo
     * @param b sustraendo
     * @return el resultado de {@code a - b}
     */
    public static int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     *
     * @param a primer factor
     * @param b segundo factor
     * @return el resultado de {@code a * b}
     */
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide un número entre otro.
     *
     * @param a dividendo
     * @param b divisor; no puede ser 0
     * @return el resultado de {@code a / b}
     * @throws IllegalArgumentException si {@code b} es 0
     */
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }
        return a / b;
    }

    /**
     * Calcula el factorial de un número (n!) mediante un bucle {@code for}.
     * <p>
     * El factorial de 0 y de 1 es 1. Para valores de {@code n} mayores que 20
     * el resultado no cabe en un {@code long} y se produce un desbordamiento.
     * </p>
     *
     * @param n número del que se calcula el factorial; se espera {@code n >= 0}
     * @return el factorial de {@code n}
     */
    public static long factorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /**
     * Comprueba si un número es primo.
     * <p>
     * Un número es primo si es mayor que 1 y solo es divisible entre 1 y
     * entre sí mismo. Solo se prueban divisores hasta la raíz cuadrada de {@code n}.
     * </p>
     *
     * @param n número que se quiere comprobar
     * @return {@code true} si {@code n} es primo, {@code false} en caso contrario
     */
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

    /**
     * Devuelve el n-ésimo número de la sucesión de Fibonacci
     * (0, 1, 1, 2, 3, 5...), empezando a contar desde la posición 0.
     * <p>
     * Ejemplo: {@code fibonacci(5)} devuelve 5.
     * </p>
     *
     * @param n posición en la sucesión; se espera {@code n >= 0}
     * @return el número de Fibonacci en la posición {@code n}
     */
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