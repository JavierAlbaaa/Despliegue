/**
 * Clase con atributos, constructor, getters y métodos de instancia.
 */
public class Estudiante {

    private static final int MAX_NOTAS = 10;

    private String nombre;
    private int edad;
    private double[] notas;
    private int numNotas;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.notas = new double[MAX_NOTAS];
        this.numNotas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    /** Añade una nota (0-10). Devuelve false si no es válida o no hay hueco. */
    public boolean anadirNota(double nota) {
        if (nota < 0 || nota > 10 || numNotas == MAX_NOTAS) {
            return false;
        }
        notas[numNotas] = nota;
        numNotas++;
        return true;
    }

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

    public double notaMaxima() {
        double max = 0;
        for (int i = 0; i < numNotas; i++) {
            if (notas[i] > max) {
                max = notas[i];
            }
        }
        return max;
    }

    public boolean estaAprobado() {
        return calcularMedia() >= 5;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años) - Media: "
                + String.format("%.2f", calcularMedia())
                + " - " + (estaAprobado() ? "APROBADO" : "SUSPENSO");
    }
}
