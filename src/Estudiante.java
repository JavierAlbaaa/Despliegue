/**
 * Representa a un estudiante con su nombre, su edad y una lista de notas.
 * <p>
 * La clase tiene atributos privados, un constructor, getters y métodos
 * de instancia para gestionar las notas y calcular la media.
 * </p>
 */
public class Estudiante {

    /** Número máximo de notas que puede almacenar un estudiante. */
    private static final int MAX_NOTAS = 10;

    /** Nombre del estudiante. */
    private String nombre;

    /** Edad del estudiante, en años. */
    private int edad;

    /** Array donde se guardan las notas (de tamaño {@link #MAX_NOTAS}). */
    private double[] notas;

    /** Cantidad de notas guardadas actualmente en el array. */
    private int numNotas;

    /**
     * Crea un estudiante sin ninguna nota.
     *
     * @param nombre nombre del estudiante
     * @param edad   edad del estudiante, en años
     */
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.notas = new double[MAX_NOTAS];
        this.numNotas = 0;
    }

    /**
     * Devuelve el nombre del estudiante.
     *
     * @return el nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la edad del estudiante.
     *
     * @return la edad del estudiante, en años
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Añade una nota al estudiante.
     * <p>
     * La nota solo se guarda si está entre 0 y 10 (ambos incluidos)
     * y todavía queda espacio para más notas.
     * </p>
     *
     * @param nota nota que se quiere añadir, entre 0 y 10
     * @return {@code true} si la nota se ha añadido; {@code false} si no es
     *         válida o ya se ha alcanzado el máximo de notas
     */
    public boolean anadirNota(double nota) {
        if (nota < 0 || nota > 10 || numNotas == MAX_NOTAS) {
            return false;
        }
        notas[numNotas] = nota;
        numNotas++;
        return true;
    }

    /**
     * Calcula la nota media del estudiante.
     *
     * @return la media de las notas guardadas, o 0 si todavía no tiene ninguna
     */
    public double calcularMedia() {
        if (numNotas == 0) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < numNotas; i++) {
            suma += notas[i];
        }
        return suma / numNotas;
    }

    /**
     * Devuelve la nota más alta del estudiante.
     *
     * @return la nota máxima guardada, o 0 si todavía no tiene ninguna
     */
    public double notaMaxima() {
        double max = 0;
        for (int i = 0; i < numNotas; i++) {
            if (notas[i] > max) {
                max = notas[i];
            }
        }
        return max;
    }

    /**
     * Indica si el estudiante está aprobado, es decir, si su media es
     * igual o superior a 5.
     *
     * @return {@code true} si la media es mayor o igual que 5, {@code false} en caso contrario
     */
    public boolean estaAprobado() {
        return calcularMedia() >= 5;
    }

    /**
     * Devuelve una representación en texto del estudiante con su nombre,
     * edad, media (con dos decimales) y estado (APROBADO o SUSPENSO).
     *
     * @return el texto con los datos del estudiante
     */
    @Override
    public String toString() {
        return nombre + " (" + edad + " años) - Media: "
                + String.format("%.2f", calcularMedia())
                + " - " + (estaAprobado() ? "APROBADO" : "SUSPENSO");
    }
}