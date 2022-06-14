package com.company;

public class Main {

    public static void main(String[] args) {

    boolean result = Validation.check("java","123","123");
    if (result) {
        System.out.println("Логин и пароль корректные");
    } else {
        System.out.println("Логин и/или пароль некорректные ");

    }

    }
}
