import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) {
        try {
            // Визначення розміру матриць
            int rows = 6;
            int cols = 6;

            // Ініціалізація матриць A та B
            int[][] matrixA = generateMatrix(rows, cols);
            int[][] matrixB = generateMatrix(rows, cols);

            // Вивід початкових матриць
            System.out.println("Матриця A:");
            printMatrix(matrixA);

            System.out.println("Матриця B:");
            printMatrix(matrixB);

            // Виконання дії C = A ⊕ B (побітове виключне АБО)
            int[][] matrixC = xorMatrices(matrixA, matrixB);

            System.out.println("Результуюча матриця C (A ⊕ B):");
            printMatrix(matrixC);

            // Обчислення суми найбільших елементів кожного рядка матриці C
            int sumOfMaxElements = calculateSumOfMaxElements(matrixC);
            System.out.println("Сума найбільших елементів кожного рядка матриці C: " + sumOfMaxElements);

        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Метод для генерації матриці випадкових чисел
    private static int[][] generateMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // Числа від 0 до 99
            }
        }
        return matrix;
    }

    // Метод для друку матриці
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Метод для виконання побітового виключного АБО між двома матрицями
    private static int[][] xorMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] ^ matrixB[i][j];
            }
        }
        return result;
    }

    // Метод для обчислення суми найбільших елементів кожного рядка матриці
    private static int calculateSumOfMaxElements(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            int max = row[0];
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
            sum += max;
        }
        return sum;
    }
}

