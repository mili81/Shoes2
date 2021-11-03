package com.company;

import java.util.Scanner;

public class InputValues {
    public static void main(String[] args) {

    }

    public static void inputSize() {
        Scanner input = new Scanner(System.in);
        System.out.println("Size:");
        int size = input.nextInt();

    }

    public static void inputColour() {
        Scanner input = new Scanner(System.in);
        System.out.println("Colour:");
        String colour = input.next();
    }

    public static void inputBrand() {
        Scanner input = new Scanner(System.in);
        System.out.println("Brand:");
        String brand = input.next();
    }
}
