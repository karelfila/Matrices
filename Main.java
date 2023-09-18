package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 5;
            System.out.println("Kalkulačka Matic");
            System.out.println("----------------");
            while (0 < a) {
            System.out.println();
            System.out.println("Jakou akci chcete provést?");
            System.out.println("1) Sčítání");
            System.out.println("2) Odečítání");
            System.out.println("3) Násobení");
            System.out.println("4) Ukončit program");
            System.out.println("------------------");
            int option = sc.nextInt();

            int[][] matice1 = {{1, 2, 4},
                               {8, 5, 9},
                               {9, 8, 4}};

            int[][] matice2 = {{8, 4, 3},
                               {5, 1, 3},
                               {5, 8, 6}};

            int[][] soucet = {{0, 0, 0},
                              {0, 0, 0},
                              {0, 0, 0}};

            int[][] soucin = {{0, 0, 0},
                              {0, 0, 0},
                              {0, 0, 0}};
            if (option == 1) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        soucet[i][j] = matice1[i][j] + matice2[i][j];
                    }
                }
                System.out.println("Součet:");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(soucet[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            if (option == 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            soucin[i][j] = soucin[i][j] + matice1[i][k] * matice2[k][j];
                        }
                    }
                }
                System.out.println("Součin:");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(soucin[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            if (option == 2) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        soucet[i][j] = matice1[i][j] - matice2[i][j];
                    }
                }
                System.out.println("Rozdíl:");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(soucet[i][j] + " ");
                    }
                    System.out.println();
                }

            }
            if (option == 4) {
                break;
            }
        }
    }
}
