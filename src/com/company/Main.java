package com.company;

public class Main {

    public static void main(String[] args) {

    boolean result = Validation.check("java_skypro.go","D_1hWiKjjP_","D_1hWiKjjP_");
    if (result) {
        System.out.println("Логин и пароль корректные");
    } else {
        System.out.printf("Логин и/или пароль некорректные ");

    }

    }
}
