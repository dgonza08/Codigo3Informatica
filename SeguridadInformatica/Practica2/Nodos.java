import java.util.LinkedList;

/**
 * Esta clase hace referencia a los nodos del algoritmo de Huffmann
 * 
 * @author David Gonzalez Alvarez
 * @version 1.0
 * 
 */
public class Nodos {
    private Nodos izquierda;
    private Nodos derecha;
    private int frecuencia;
    private float probabilidad;
    private boolean cogido;
    private LinkedList<Integer> codigo;

    /**
     * Constructor de la clase Nodos con 3 parametros
     * 
     * @param frecuencia
     * @param probabilidad
     * @param cogido
     * @param codigo
     */
    public Nodos(int frecuencia, float probabilidad, boolean cogido, LinkedList<Integer> codigo) {
        this.frecuencia = frecuencia;
        this.probabilidad = probabilidad;
        this.cogido = cogido;
        this.codigo = codigo;
    }
    
    /**
     * Constructor de la clase Nodos con 2 parametros
     * 
     * @param frecuencia
     * @param cogido
     * @param probabilidad
     */
    public Nodos(int frecuencia, boolean cogido, float probabilidad) {
        this.frecuencia = frecuencia;
        this.cogido = cogido;
        this.probabilidad = probabilidad;
    }

    /**
     * Constructor de la clase nodos para un solo parametro
     * 
     * @param frecuencia
     */
    public Nodos(int frecuencia){
        this.frecuencia = frecuencia;
    }
    /**
     * Constructor vacio de la clase Nodos
     */
    public Nodos() {

    }

    /**
     * Metodo que devuelve el nodo de la izquierda al actual
     * 
     * @return izquierda
     */
    public Nodos getIzquierda(){
        return this.izquierda;
    }

    /**
     * Metodo que devuelve el nodo de la derecha del actual
     * 
     * @return derecha
     */
    public Nodos getDerecha(){
        return this.derecha;
    }
    
    /**
     * Metodo que cambia el valor al que apunta el nodo hacia la izquierda
     */
    public void setIzquierda(Nodos nuevaIzquierda){
        this.izquierda = nuevaIzquierda;
    }

    /**
     * Metodo que cambia el valor al que apunta el nodo hacia la derecha
     */
    public void setDerecha(Nodos nuevaDerecha){
        this.derecha = nuevaDerecha;
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
     * Metodo que nos devuelve si el nodo esta cogido o no
     * 
     * @return cogido
     */
    public boolean isCogido() {
        return cogido;
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
