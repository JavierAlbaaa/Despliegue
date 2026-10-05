/**
 * Funciones para trabajar con textos (String).
 * <p>
 * Todos los métodos son estáticos, por lo que no hace falta crear
 * ninguna instancia de la clase para usarlos.
 * </p>
 */
public class Cadenas {

    /**
     * Devuelve el texto al revés.
     * <p>
     * Ejemplo: {@code invertir("hola")} devuelve {@code "aloh"}.
     * </p>
     *
     * @param texto el texto que se quiere invertir; no debe ser {@code null}
     * @return un nuevo String con los caracteres de {@code texto} en orden inverso
     */
    public static String invertir(String texto) {
        String resultado = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado += texto.charAt(i);
        }
        return resultado;
    }

    /**
     * Comprueba si un texto es palíndromo, es decir, si se lee igual
     * de izquierda a derecha que de derecha a izquierda.
     * <p>
     * La comprobación ignora los espacios y las diferencias entre mayúsculas
     * y minúsculas. No elimina signos de puntuación ni tildes.
     * </p>
     *
     * @param texto el texto que se quiere comprobar; no debe ser {@code null}
     * @return {@code true} si el texto es palíndromo, {@code false} en caso contrario
     */
    public static boolean esPalindromo(String texto) {
        String limpio = texto.replace(" ", "").toLowerCase();
        return limpio.equals(invertir(limpio));
    }

    /**
     * Cuenta las vocales (a, e, i, o, u) de un texto sin distinguir
     * entre mayúsculas y minúsculas.
     * <p>
     * Las vocales con tilde (á, é, í, ó, ú) no se cuentan.
     * </p>
     *
     * @param texto el texto en el que se cuentan las vocales; no debe ser {@code null}
     * @return el número de vocales que contiene el texto
     */
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