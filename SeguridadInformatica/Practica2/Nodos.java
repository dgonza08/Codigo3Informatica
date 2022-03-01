/**
 * Esta clase hace referencia a los nodos del algoritmo de Huffmann
 */
public class Nodos {
    private int frecuencia;
    private float probabilidad;
    private int codigo;

    public Nodos(int frecuencia, float probabilidad, int codigo) {
        this.frecuencia = frecuencia;
        this.probabilidad = probabilidad;
        this.codigo = codigo;
    }

    public Nodos(){

    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public float getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(float probabilidad) {
        this.probabilidad = probabilidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
