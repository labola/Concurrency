package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int SIZE = 10_000_000;
    public static void main(String[] args) {

        withConcurrency();
        withoutConcurrency();
    }

    public static void withConcurrency() {
        Float[] arrwcon = new Float[SIZE];

        for (int i = 0; i < arrwcon.length; i++) {
            arrwcon[i] = 1f;
        }
        Float[] arr1 = new Float[arrwcon.length/2];
        Float[] arr2 = new Float[arrwcon.length/2];
        long before = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arrwcon, 0, arr1, 0, arrwcon.length / 2);
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i]=(float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.arraycopy(arrwcon, 5_000_000, arr2, 0, arrwcon.length / 2);
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        thread1.start();
        thread2.start();
        try {

            thread1.join();
            thread2.join();
            System.arraycopy(arr1, 0, arrwcon, 0, (arrwcon.length / 2));
            System.arraycopy(arr2, 0, arrwcon, 5_000_000, (arrwcon.length / 2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long after = System.currentTimeMillis();
        System.out.println("Time withConcurrency: " + (after - before));
    }

    public static void withoutConcurrency() {
       Float[] arrwocon = new Float[SIZE];
        for (int i = 0; i < arrwocon.length; i++) {
            arrwocon[i]=1f;
        }
        long before = System.currentTimeMillis();
        for (int i = 0; i < arrwocon.length; i++) {
            arrwocon[i]= (float) (arrwocon[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }

        long after = System.currentTimeMillis();
        System.out.println("Time withoutConcurrency: " + (after - before));
    }
}