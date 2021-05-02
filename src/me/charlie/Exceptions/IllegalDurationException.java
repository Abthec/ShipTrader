package me.charlie.Exceptions;

public class IllegalDurationException extends IllegalStateException {

    public IllegalDurationException() {}

    public IllegalDurationException(String message) {
        super(message);
    }
}
