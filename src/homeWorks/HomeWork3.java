package homeWorks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HomeWork3 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int NEGATIVE_RESULT_OUTPUT = -1;

    // Написать программу для сортировки массива методом выбора natural order.
    public static void firstEasyTask() {
        try {
            System.out.println("Введи через запятую числа, входящие в массив, который будем сортировать выбором.");
            String inputStr = reader.readLine();
            String[] inputArr = inputStr.split(",");
            System.out.println(Arrays.toString(naturalOrderSelectionSort(inputArr)));
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    private static int[] naturalOrderSelectionSort(String[] inputArr) {
        int[] outputArray = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            outputArray[i] = Integer.parseInt(inputArr[i]);
        }

        for (int i = 0; i < outputArray.length; i++) {
            int minNum = outputArray[i];
            int index = i;
            for (int j = i + 1; j < outputArray.length; j++) {
                int arrElement = outputArray[j];
                if (arrElement < minNum) {
                    minNum = arrElement;
                    index = j;
                }
            }
            outputArray[index] = outputArray[i];
            outputArray[i] = minNum;
        }
        return outputArray;
    }

    // Написать программу для сортировки методом вставки по убыванию.
    public static void secondEasyTask() {
        try {
            System.out.println("Введи через запятую числа, входящие в массив, который будем сортировать вставкой по убыванию.");
            String inputStr = reader.readLine();
            String[] inputArr = inputStr.split(",");
            System.out.println(Arrays.toString(reverseOrderInsertionSort(inputArr)));
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    private static int[] reverseOrderInsertionSort(String[] inputArr) {
        int[] outputArray = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            outputArray[i] = Integer.parseInt(inputArr[i]);
        }
        if (outputArray.length == 1) return outputArray;

        for (int i = 1; i < outputArray.length; i++) {
            for (int j = i; j > 0 && outputArray[j - 1] < outputArray[j]; j--) {
                int arrElement = outputArray[j];
                outputArray[j] = outputArray[j - 1];
                outputArray[j - 1] = arrElement;
            }
        }
        return outputArray;
    }

    // Написать программу для сортировки методом вставки по убыванию.
    public static void thirdEasyTask() {
        try {
            System.out.println("Введи число, которое необходимо найти в массиве.");
            int wantedNum = Integer.parseInt(reader.readLine());
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать число с использованием линейного поиска.");
            String inputStr = reader.readLine();
            String[] inputArr = inputStr.split(",");
            System.out.println(linearSearch(wantedNum, inputArr));
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    private static int linearSearch(int inputNum, String[] inputArr) {
        int[] outputArray = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            outputArray[i] = Integer.parseInt(inputArr[i]);
        }
        if (outputArray.length == 1) return outputArray[0];
        int outputNum = NEGATIVE_RESULT_OUTPUT;

        for (int i = 0; i < outputArray.length; i++) {
            if (outputArray[i] == inputNum) outputNum = i;

        }
        return outputNum;
    }

    // Написать программу для поиска числа в неупорядоченном массиве, используя бинарный поиск и сортировку массива пузырьком
    public static void firstMiddleTask() {
        try {
            System.out.println("Введи число, которое необходимо найти в массиве.");
            int wantedNum = Integer.parseInt(reader.readLine());
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать число с использованием бинарного поиска.");
            String inputStr = reader.readLine();
            String[] inputArr = inputStr.split(",");
            System.out.println(binarySearch(bubbleSort(inputArr), wantedNum));
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    private static int[] bubbleSort(String[] inputArr) {
        int[] outputArray = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            outputArray[i] = Integer.parseInt(inputArr[i]);
        }
        if (outputArray.length == 1) return outputArray;

        for (int i = 0; i < outputArray.length; i++) {
            for (int j = 0; j < outputArray.length - i - 1; j++) {
                if (outputArray[j] > outputArray[j + 1]) {
                    int arrElement = outputArray[j];
                    outputArray[j] = outputArray[j + 1];
                    outputArray[j + 1] = arrElement;
                }
            }
        }

        System.out.printf("Отсортированный массив: %s%n", Arrays.toString(outputArray));

        return outputArray;
    }

    private static int binarySearch(int[] inputArr, int inputNum) {
        if (inputArr.length == 0) return NEGATIVE_RESULT_OUTPUT;

        int midIndex = inputArr.length / 2;

        if (inputNum > inputArr[midIndex]) {
            return binarySearch(Arrays.copyOfRange(inputArr, midIndex + 1, inputArr.length), inputNum);
        } else if (inputNum < inputArr[midIndex]) {
            return binarySearch(Arrays.copyOfRange(inputArr, 0, midIndex), inputNum);
        } else {
            return inputNum;
        }
    }


    public static void secondHardTask() {
        try {
            System.out.println("Введи число, которое необходимо найти в массиве.");
            int wantedNum = Integer.parseInt(reader.readLine());
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать число с использованием бинарного поиска.");
            String inputStr = reader.readLine();
            String[] inputArr = inputStr.split(",");

            int[][] resultsOfSort = bubbleSortedArrayAndIndexArray(inputArr);

            System.out.println(binarySearchOfIndex(resultsOfSort[0], resultsOfSort[1], wantedNum));
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    private static int[][] bubbleSortedArrayAndIndexArray(String[] inputArr) {
        int[] outputArray = new int[inputArr.length];
        int[] inputArrIndexes = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            outputArray[i] = Integer.parseInt(inputArr[i]);
            inputArrIndexes[i] = i;
        }
        if (outputArray.length == 1) return new int[][]{outputArray, inputArrIndexes};


        for (int i = 0; i < outputArray.length; i++) {
            for (int j = 0; j < outputArray.length - i - 1; j++) {
                if (outputArray[j] > outputArray[j + 1]) {
                    int arrElement = outputArray[j];
                    outputArray[j] = outputArray[j + 1];
                    outputArray[j + 1] = arrElement;

                    int inputArrIndex = inputArrIndexes[j];
                    inputArrIndexes[j] = inputArrIndexes[j + 1];
                    inputArrIndexes[j + 1] = inputArrIndex;
                }
            }
        }

        System.out.printf("Отсортированный массив: %s%n", Arrays.toString(outputArray));
        System.out.printf("Отсортированный массив индексов исходного массива: %s%n", Arrays.toString(inputArrIndexes));

        return new int[][]{outputArray, inputArrIndexes};
    }


    private static int binarySearchOfIndex(int[] inputArr, int[] inputArrIndexes, int inputNum) {
        if (inputArr.length == 0) return NEGATIVE_RESULT_OUTPUT;

        int midIndex = inputArr.length / 2;
        int midValue = inputArr[midIndex];

        if (midValue == inputNum) {
            return inputArrIndexes[midIndex];
        } else if (inputNum > midValue) {
            return binarySearchOfIndex(Arrays.copyOfRange(inputArr, midIndex + 1, inputArr.length),
                    Arrays.copyOfRange(inputArrIndexes, midIndex + 1, inputArrIndexes.length), inputNum);
        } else {
            return binarySearchOfIndex(Arrays.copyOfRange(inputArr, 0, midIndex),
                    Arrays.copyOfRange(inputArrIndexes, 0, midIndex), inputNum);
        }
    }
}
