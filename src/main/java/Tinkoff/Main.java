package Tinkoff;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Integer> arr = new ArrayList<>();
    private static int COUNT;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите количество оценок: ");
        COUNT = sc.nextInt();
        System.out.println();

        System.out.print("Введите последовательность ");
        for (int i = 0; i < COUNT; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(get());

        arr.clear();


    }

    public static int get() {
        int goodNum = 0;
        int goodNum1 = 0;
        int badNum = 0;
        int badNum1 = 0;

        for (int i = (COUNT - 7); i < COUNT; i++) {
            if (arr.get(i) == 2 || arr.get(i) == 3) {
                badNum++;
            }
            if (arr.get(i) == 5) {
                goodNum++;
            }
        }
        for (int j = 0; j < 7; j++) {
            if (arr.get(j) == 2 || arr.get(j) == 3) {
                badNum1++;
            }
            if (arr.get(j) == 5) {
                goodNum1++;
            }
        }
        if (goodNum1 > goodNum) {
            badNum = badNum1;
            goodNum = goodNum1;

        }

        if (badNum != 0) {
            return -1;
        }
        return goodNum;
    }
}

