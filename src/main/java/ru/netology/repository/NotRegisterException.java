package ru.netology.repository;

public class NotRegisterException extends RuntimeException {
    public NotRegisterException(String s) {
        super(s);
    }
}