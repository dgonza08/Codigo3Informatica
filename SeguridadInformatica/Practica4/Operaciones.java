public class Operaciones {
    public Operaciones() {
    }

    public float log(float x, float base) {
        return (float) (Math.log10(x) / Math.log10(base));
    }

    public String toBinario(long entero) {
        String binario = Long.toBinaryString(entero);
        return binario;
    }

    public int[][] construirMatrizGI(int[][] matrizIdentidad, int[][] matrizGeneradora) {
        int dimensiones = matrizGeneradora.length;
        int filas = dimensiones;
        int columnas = dimensiones * 2;
        int[][] matrizFinal = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                matrizFinal[i][j] = matrizIdentidad[i][j];
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                matrizFinal[i][j + filas] = matrizGeneradora[i][j];
            }
        }

        return matrizFinal;
    }
}
