import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
//        firstTask();
        secondTask();
//      thirdTask();
//            forthTask();
//            fifthTask();
//            sixthTask();
//            seventhTask();
//            eighthTask();
    }

    // Написать программу для проверки нахождения заданого элемента в массиве.
    private static void firstTask() {
        try {
            System.out.println("Введи число, которое необходимо найти в массиве.");
            int wantedNum = Integer.parseInt(reader.readLine());
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать.");
            String inputStr = reader.readLine();
            String [] inputArr = inputStr.split(",");
            System.out.println(isNumInArray(wantedNum, inputArr));
        } catch (Exception e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
    }
    private static String isNumInArray(int inputNum, String[] inputArr) {
        for (String arrElement: inputArr) {
            if (Integer.parseInt(arrElement) == inputNum) return "true";
        }
        return "false";
    }

    // Написать программу для нахождения индекса минимального элемента в массиве.
    private static void secondTask() {
        try {
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать индекс самого маленького числа.");
            String inputStr = reader.readLine();
            String [] inputArr = inputStr.split(",");
            System.out.println(minNumInArrayIndex(inputArr));
        } catch (Exception e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
    }
    private static String minNumInArrayIndex(String[] inputArr) {
        int minNum = 0;
        for (String arrElementStr : inputArr) {
            int arrElement = Integer.parseInt(arrElementStr);
            if (arrElement < minNum) minNum = arrElement;
        }
        int i = 0;
        while (i < inputArr.length) {
            if (Integer.parseInt(inputArr[i]) == minNum) break;
            i++;
        }
        return String.valueOf(i);
    }



    // утилитны метод ввода данных с консоли
    private static int inputNumRead() throws RuntimeException {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            throw new RuntimeException("Введен некорректный символ (не число)", e);
        }
    }
}