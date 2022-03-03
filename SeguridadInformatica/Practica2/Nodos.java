import java.util.LinkedList;

/**
 * Esta clase hace referencia a los nodos del algoritmo de Huffmann
 * 
 * @author David Gonzalez Alvarez
 * @version 1.0
 * 
 */
public class Nodos {
    private int frecuencia;
    private float probabilidad;
    private LinkedList<Integer> codigo;

    /**
     * Constructor de la clase Nodos con 3 parametros
     * 
     * @param frecuencia
     * @param probabilidad
     * @param codigo
     */
    public Nodos(int frecuencia, float probabilidad, LinkedList<Integer> codigo) {
        this.frecuencia = frecuencia;
        this.probabilidad = probabilidad;
        this.codigo = codigo;
    }

    /**
     * Constructor de la clase Nodos con 2 parametros
     * 
     * @param frecuencia
     * @param probabilidad
     */
    public Nodos(int frecuencia, float probabilidad) {
        this.frecuencia = frecuencia;
        this.probabilidad = probabilidad;
    }

    /**
     * Constructor vacio de la clase Nodos
     */
    public Nodos() {

    }

    /**
     * Metodo que nos devuelve la frecuencia del nodo
     * 
     * @return frecuencia
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * Metodo que nos permite cambiar la frecuencia del nodo
     * 
     * @param frecuencia
     */
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * Metodo que nos devuelve la probabilidad del nodo
     * 
     * @return probabilidad
     */
    public float getProbabilidad() {
        return probabilidad;
    }

    /**
     * Metodo que nos permite cambiar la probabilidad del nodo
     * 
     * @param probabilidad
     */
    public void setProbabilidad(float probabilidad) {
        this.probabilidad = probabilidad;
    }

    /**
     * Metodo que nos devuelve el codigo del nodo
     * 
     * @return codigo
     */
    public LinkedList<Integer> getCodigo() {
        return codigo;
    }

    /**
     * Metodo que nos permite cambiar el codigo del nodo
     * 
     * @param codigo
     */
    public void setCodigo(LinkedList<Integer> codigo) {
        this.codigo = codigo;
    }
}
