package homeWorks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HomeWork3 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Написать программу для сортировки массива методом выбора natural order.
    public static void firstTask() {
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
    public static void secondTask() {
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
            for(int j = i; j > 0 && outputArray[j-1] < outputArray[j]; j--) {
                int arrElement = outputArray[j];
                outputArray[j] = outputArray[j - 1];
                outputArray[j - 1] = arrElement;
            }
        }
        return outputArray;
    }

    // Написать программу для сортировки методом вставки по убыванию.
    public static void thirdTask() {
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
        int outputNum = -1;

        for (int i = 0; i < outputArray.length; i++) {
            if (outputArray[i] == inputNum) outputNum =  i;

        }
        return outputNum;
    }
}
