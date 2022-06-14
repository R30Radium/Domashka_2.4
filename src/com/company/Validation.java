package com.company;

import java.util.Objects;

public class Validation {

    private static final String valid_symbols = "abcdefghijklmnopqrstuvwzyzABCDEFGIJKLMNOPQRSUVWXYZ1234567890_";

    private Validation() {
    }

    static boolean check(String login, String password, String confirmPassword) {

        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }


    private static void validate(String login, String password, String confirmPassword)
            throws WrongPasswordException, WrongLoginException {

        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть <= 20 ");
        }

        if (!containsValidSymbols(login)) {
            throw new WrongLoginException("Логин содержит невалидные символы");
        }

        if (checkPassword(password) || checkPassword(confirmPassword)) {
            throw new WrongPasswordException("Длина пароля должна быть < 20");
        }

        if (!containsValidSymbols(password)) {
            throw new WrongLoginException("Пароль содержит невалидные символы ");
        }
        if(!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают! ");
        }
    }

    private static boolean checkPassword(String password) {
        return Objects.isNull(password) || password.length() >= 20;
    }

    private static boolean containsValidSymbols(String s){
        /* char[] symbols = s.toCharArray();
        char[] validSymbols = valid_symbols.toCharArray();
        for (char symbol : symbols) {
            for (char validSymbol : validSymbols) {
                if (symbol != validSymbol) {
                    return false;
                }
            }
        }
        return true;*/

        return s.matches("^\\w" +
                "+$");
    }


}