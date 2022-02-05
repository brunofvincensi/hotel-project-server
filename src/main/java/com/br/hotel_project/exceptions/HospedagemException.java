package com.br.hotel_project.exceptions;

public class HospedagemException extends RuntimeException{
    public HospedagemException(String message) {
        super(message);
    }

    public HospedagemException() {
        super("Hospedagem não encontrada.");
    }
}
