package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length - 1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
// Obtener el número de filas y columnas de la primera capa
        int filas = intArrayTri[0].length;
        int columnas = intArrayTri[0][0].length;

        // Crear un array bidimensional para almacenar los resultados
        int[][] flatMatrix = new int[filas][columnas];

        // Aplanar la matriz tridimensional
        for (int depth = 0; depth < intArrayTri.length; depth++) {
            for (int fila = 0; fila < filas; fila++) {
                for (int col = 0; col < columnas; col++) {
                    flatMatrix[fila][col] += intArrayTri[depth][fila][col];
                }
            }
        }

        return flatMatrix;
    }


    // TODO
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();

        // Recorre cada fila del array bidimensional
        for (int i = 0; i < intArrayBi.length; i++) {

            // Invoca a stringFlatMatrixRow() para obtener la fila
            sb.append(stringFlatMatrixRow(intArrayBi, i));

            // Añade un salto de línea
            if (i < intArrayBi.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();

    }

    // TODO
    public static String getUnidimensionalString(int[] uniArray) {

        StringBuilder sb = new StringBuilder();

        //Se añade el contenido del array al stringbuilder
        for (int i = 0; i < uniArray.length; i++) {
            sb.append(uniArray[i]);

            if (i < uniArray.length - 1) sb.append(" ");

        }
        return sb.toString();
    }

    // TODO
    public static int[] createAndPopulateUnidimensionalArray(int columns) {

        int[] unidimensional = new int[columns];
        for (int i = 0; i < unidimensional.length; i++) {
            unidimensional[i] = i + 1;
        }
        return unidimensional;
    }

    // TODO
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {

        int[][] bidimensional = new int[rows][columns];

        //contador para añadir los numeros
        int contador = 1;

        //Con 2 bucles for se rellenan ambas dimensiones
        for (int i = 0; i<bidimensional.length;i++){
            for (int j = 0; j<bidimensional[i].length;j++){


                //Se añade el numero a la posicion y se suma 1 al contador
                bidimensional[i][j] = contador;
                contador++;
            }
        }

        return bidimensional;

    }

    // TODO
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {

        int[][][] tridimensional = new int[rows][columns][depth];

        //Se crea el contador para rellenar el array
        int contador = 1;

        for (int i = 0; i<depth;i++){
            for (int j = 0; j<rows;j++){
                for (int x = 0; x<columns;x++){
                    tridimensional[i][j][x] = contador;
                    contador++;
                }
            }
        }

        return tridimensional;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
