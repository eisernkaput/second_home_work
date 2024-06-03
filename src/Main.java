import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        firstTask();
        secondTask();
      thirdTask();
            forthTask();
            fifthTask();
//        sixthTask();
//            seventhTask();
    }

    // Написать программу для проверки нахождения заданого элемента в массиве.
    private static void firstTask() {
        try {
            System.out.println("Введи число, которое необходимо найти в массиве.");
            int wantedNum = Integer.parseInt(reader.readLine());
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать.");
            String inputStr = reader.readLine();
            String[] inputArr = inputStr.split(",");
            System.out.println(isNumInArray(wantedNum, inputArr));
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    private static boolean isNumInArray(int inputNum, String[] inputArr) {
        for (String arrElement : inputArr) {
            if (Integer.parseInt(arrElement) == inputNum) return true;
        }
        return false;
    }

    // Написать программу для нахождения индекса минимального элемента в массиве.
    private static void secondTask() {
        try {
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать индекс самого маленького числа.");
            String inputStr = reader.readLine();
            String[] inputArr = inputStr.split(",");
            System.out.println(minNumInArrayIndex(inputArr));
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    private static int minNumInArrayIndex(String[] inputArr) {
        int minNum = Integer.parseInt(inputArr[0]);
        int index = 0;
        for (int i = 0; i < inputArr.length; i++) {
            int arrElement = Integer.parseInt(inputArr[i]);
            if (arrElement < minNum) {
                minNum = arrElement;
                index = i;
            }
        }
        return index;
    }

    // Написать программу для нахождения индексов минимального элемента в двумерном массиве.
    private static void thirdTask() {
        try {
            ArrayList<String[]> inputList = new ArrayList<>();
            inputArrReadAndPutIntoList(inputList);
            String[][] inputArr = new String[inputList.size()][];
            System.out.println(
                    Arrays.toString(minNumInDoubleArrayIndex(inputList.toArray(inputArr)))
            );
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    private static void inputArrReadAndPutIntoList(ArrayList<String[]> inputList) throws RuntimeException {
        System.out.println("Введи через запятую числа, входящие в массив, нажми Enter.\nВведи \"Конец\" для завершения создания двумерного массива.");
        try {
            String inputStr = reader.readLine();
            if (inputStr.equals("Конец")) return;
            String[] inputArr = inputStr.split(",");
            inputList.add(inputArr);
            inputArrReadAndPutIntoList(inputList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] minNumInDoubleArrayIndex(String[][] inputArr) {
        int minNum = Integer.parseInt(inputArr[0][0]);
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j < inputArr[i].length; j++) {
                int arrElement = Integer.parseInt(inputArr[i][j]);
                if (arrElement < minNum) {
                    minNum = arrElement;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        return new int[]{index1, index2};
    }

    // Реализовать программу для расчета положительного n-го ряда числа Фибоначчи с помощью цикла.
    private static void forthTask() {
        System.out.println("Введи номер элемента ряда числа Фибоначчи.");
        System.out.println(fibonacciElementFromItsNum(inputNumRead()));
    }

    private static int fibonacciElementFromItsNum(int inputNum) {
        return switch (inputNum) {
            case 1 -> 0;
            case 2 -> 1;
            default -> {
                int iMinusTwo = 1, iMinusOne = 1, element = 1;
                int i = 3;
                while (i < inputNum) {
                    element = iMinusTwo + iMinusOne;
                    iMinusTwo = iMinusOne;
                    iMinusOne = element;
                    i++;
                }
                yield element;
            }
        };
    }

    //  Написать программу для нахождения индексов дубликатов в целочисленном непустом отсортированном массиве.
    private static void fifthTask() {
        try {
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать индексы дубликатов.");
            String inputStr = reader.readLine();
            String[] inputArrStr = inputStr.split(",");
            List<Integer> result = new ArrayList<>(new ArrayList<>(List.of(inputArrStr)).stream().map(Integer::valueOf).toList());
            result.sort(Comparator.naturalOrder());
            System.out.printf("Отсортированный массив: %s", result);
            Integer[] inputArrInt = new Integer[result.size()];
            System.out.printf("\nИндексы дубликатов: %s", duplicateIndex(result.toArray(inputArrInt)));
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }

    //  Написать программу для нахождения индексов дубликатов в целочисленном непустом неотсортированном массиве.
    private static void sixthTask() {
        try {
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать индексы дубликатов.");
            String inputStr = reader.readLine();
            String[] inputArrStr = inputStr.split(",");
            List<Integer> result = new ArrayList<>(new ArrayList<>(List.of(inputArrStr)).stream().map(Integer::valueOf).toList());
            Integer[] inputArrInt = new Integer[result.size()];
            inputArrInt = result.toArray(inputArrInt);
            mergeSort(result.toArray(inputArrInt));
            System.out.println("Отсортированный массив: ");
            System.out.print(Arrays.toString(inputArrInt));
            System.out.printf("\nИндексы дубликатов: %s", duplicateIndex(inputArrInt));
        } catch (Exception e) {
            throw new NumberFormatException(String.format("Введен некорректный символ (не число). %s", e));
        }
    }

    private static void mergeSort(Integer[] inputArr) {
        if (inputArr.length <= 1) return;

        int halfArrayIndex = inputArr.length / 2;
        Integer[] leftSideArr = Arrays.copyOfRange(inputArr, 0, halfArrayIndex);
        Integer[] rightSideArr = Arrays.copyOfRange(inputArr, halfArrayIndex, inputArr.length);

        mergeSort(leftSideArr);
        mergeSort(rightSideArr);

        arraysMerge(inputArr, leftSideArr, rightSideArr);
    }

    private static void arraysMerge(Integer[] inputArr, Integer[] leftSideArr, Integer[] rightSideArr) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
        while (leftIndex < leftSideArr.length && rightIndex < rightSideArr.length) {
            if (leftSideArr[leftIndex] <= rightSideArr[rightIndex]) {
                inputArr[resultIndex++] = leftSideArr[leftIndex++];
            } else {
                inputArr[resultIndex++] = rightSideArr[rightIndex++];
            }
        }

        while (leftIndex < leftSideArr.length) {
            inputArr[resultIndex++] = leftSideArr[leftIndex++];
        }

        while (rightIndex < rightSideArr.length) {
            inputArr[resultIndex++] = rightSideArr[rightIndex++];
        }
    }

    private static List<Integer> duplicateIndex(Integer[] inputArr) {
        ArrayList<Integer> outputList = new ArrayList<>();
        int halfArrayIndex = inputArr.length / 2;
        for (int i = 0; i < inputArr.length; i++) {
            int nextIndex = i + 1;
            if (Objects.equals(inputArr[i], inputArr[halfArrayIndex])) {
                //добавить все от следующего элемента до половины и искать дальше
                for (int j = nextIndex; j < inputArr.length; j++) {
                    if (j <= halfArrayIndex || Objects.equals(inputArr[i], inputArr[j])) {
                        if (j == nextIndex) outputList.add(i);
                        outputList.add(j);
                    }
                }
            } else {
                //искать от следующего элемента только до половины
                for (int j = nextIndex; j < halfArrayIndex; j++) {
                    if (Objects.equals(inputArr[i], inputArr[j])) {
                        if (j == nextIndex) outputList.add(i);
                        outputList.add(j);
                    }
                }
            }
            //если нашли дубликаты - выходим
            if (!outputList.isEmpty()) break;
        }
        return outputList;
    }

    //  Написать программу для нахождения уникального элемента среди парных дубликатов в целочисленном непустом неотсортированном массиве.
    private static void seventhTask() {
        try {
            System.out.println("Введи через запятую числа, входящие в массив, в котором будем искать индекс уникального элемента.");
            String inputStr = reader.readLine();
            String[] inputArrStr = inputStr.split(",");
            List<Integer> result = new ArrayList<>(new ArrayList<>(List.of(inputArrStr)).stream().map(Integer::valueOf).toList());
            Integer[] inputArrInt = new Integer[result.size()];
            inputArrInt = result.toArray(inputArrInt);
            mergeSort(result.toArray(inputArrInt));
            System.out.println("Отсортированный массив: ");
            System.out.print(Arrays.toString(inputArrInt));
            System.out.printf("\nИндексы дубликатов: %s", uniqueNumIndex(inputArrInt));
        } catch (Exception e) {
            throw new NumberFormatException(String.format("Введен некорректный символ (не число). %s", e));
        }
    }

    private static List<Integer> uniqueNumIndex(Integer[] inputArr) {
        ArrayList<Integer> outputList = new ArrayList<>();
        int halfArrayIndex = inputArr.length / 2;
        for (int i = 0; i < inputArr.length; i++) {
            int nextIndex = i + 1;
            if (Objects.equals(inputArr[i], inputArr[halfArrayIndex])) {
                //добавить все от следующего элемента до половины и искать дальше
                for (int j = nextIndex; j < inputArr.length; j++) {
                    if (j <= halfArrayIndex || Objects.equals(inputArr[i], inputArr[j])) {
                        if (j == nextIndex) outputList.add(i);
                        outputList.add(j);
                    }
                }
            } else {
                //искать от следующего элемента только до половины
                for (int j = nextIndex; j < halfArrayIndex; j++) {
                    if (Objects.equals(inputArr[i], inputArr[j])) {
                        if (j == nextIndex) outputList.add(i);
                        outputList.add(j);
                    }
                }
            }
            //если нашли дубликаты - выходим
            if (!outputList.isEmpty()) break;
        }
        return outputList;
    }

    // утилитный метод ввода данных с консоли
    private static int inputNumRead() throws RuntimeException {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            throw new NumberFormatException("Введен некорректный символ (не число)");
        }
    }
}