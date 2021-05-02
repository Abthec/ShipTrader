package me.charlie.Exceptions;

public class IllegalNameException extends IllegalStateException{

    public IllegalNameException() {}

    public IllegalNameException(String message) {
        super(message);
    }
}
