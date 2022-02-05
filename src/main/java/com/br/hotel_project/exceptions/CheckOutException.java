package com.br.hotel_project.exceptions;

public class CheckOutException extends RuntimeException{
    public CheckOutException(){
        super("Data do check out não pode ser mais nova que a de check in");
    }
}
