package CodeWars;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) {
        camelCase("camelCasing");


    }

    public static int[] minMax(int[] arr) {
        // Your awesome code here
        int[] res = new int[2];

        OptionalInt min = Arrays.stream(arr).min();
        OptionalInt max = Arrays.stream(arr).max();

        if (max.equals(min)) {
            res[0] = min.getAsInt();
            res[1] = min.getAsInt();
            return res;
        }
        res[0] = min.getAsInt();
        res[1] = max.getAsInt();


        return res;
    }

    public static int solution(int number) {
        //TODO: Code stuff here
        int sum = 0;
        for (int i = 0; i < number; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                sum += i;
            }
        }

        return sum;
    }

    public static int persistence(long n) {
        int count = 0;
        int digit = 1;
        while (n / 10 != 0) {


            if (n / 10 == 0) {
                return 0;
            }
            while (true) {
                digit *= n % 10;
                n /= 10;
                if ((n / 10 == 0) && (n % 10 == 0)) {
                    n = digit;
                    digit = 1;
                    break;
                }
            }

            count++;
        }

        return count; // your code
    }

    public static boolean ifUpperCase(char ch) {
        String upperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
        List<Character> listChars = new ArrayList<>();
        for (int i = 0; i < upperCase.length(); i++) {
            listChars.add(upperCase.charAt(i));
        }
        for (int i = 0; i < listChars.size(); i++) {
            if (ch == listChars.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static String camelCase(String input) {
        List<Character> listChars = new ArrayList<>();
        String newInput = "";
        for (int i = 0; i < input.length(); i++) {
            listChars.add(input.charAt(i));
        }
        for (int i = 0; i < listChars.size(); i++) {
            if (ifUpperCase(listChars.get(i))) {
                newInput += " " + listChars.get(i);

            }else {newInput += listChars.get(i);}


        }


        return newInput;
    }

    public static String makeReadable(int seconds) {
        // Do something
        return Integer.toString(seconds);
    }
}

