package com.company;

import java.util.Objects;

public class Validation {

    private static final String valid_symbols = "abcdefghijklmnopqrstuvwzyzABCDEFGIJKLMNOPQRSUVWXYZ1234567890_.";

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
        if (Objects.isNull(login) || login.length() > 20 || !containsValidSymbols(login)) {
            throw new WrongLoginException("Длина логина должна быть <= 20 ");
        }

        if (Objects.isNull( confirmPassword) || confirmPassword.length() > 20 || !containsValidSymbols(password)) {
            throw new WrongLoginException("Длина логина должна быть <= 20 ");
        }
        if(!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают! ");
        }
    }

    private static boolean checkPassword(String password) {
        return Objects.isNull(password) || password.length() >= 20 || !containsValidSymbols(password);
    }

    private static boolean containsValidSymbols(String s){
        char[] symbols = s.toCharArray();
        char[] validSymbols = valid_symbols.toCharArray();
        for (char symbol : symbols) {
            for (char validSymbol : validSymbols) {
                if (symbol != validSymbol) {
                    return false;
                }
            }
        }
        return true;
    }


}