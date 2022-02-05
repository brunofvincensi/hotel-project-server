package com.br.hotel_project.exceptions;

public class HospedeException extends RuntimeException {
    public HospedeException(String message) {
        super(message);
    }

    public HospedeException() {
        super("Hospede não encontrado.");
    }
}
