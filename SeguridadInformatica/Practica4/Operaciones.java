public class Operaciones {
    public Operaciones() {
    }

    public float log(float x, float base) {
        return (float) (Math.log10(x) / Math.log10(base));
    }

    public String toBinario(long entero){
        String binario = Long.toBinaryString(entero);
        return binario;
    }
}
