/**
 * Funciones para trabajar con textos (String).
 */
public class Cadenas {

    /** Devuelve el texto al revés. */
    public static String invertir(String texto) {
        String resultado = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado += texto.charAt(i);
        }
        return resultado;
    }

    /** Comprueba si un texto es palíndromo (ignora espacios y mayúsculas). */
    public static boolean esPalindromo(String texto) {
        String limpio = texto.replace(" ", "").toLowerCase();
        return limpio.equals(invertir(limpio));
    }

    /** Cuenta las vocales (a, e, i, o, u) de un texto. */
    public static int contarVocales(String texto) {
        int contador = 0;
        String vocales = "aeiou";
        for (char c : texto.toLowerCase().toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }
}
