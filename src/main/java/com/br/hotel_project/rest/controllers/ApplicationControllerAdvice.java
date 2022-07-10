package com.br.hotel_project.rest.controllers;

import com.br.hotel_project.rest.dtos.ApiErrors;
import com.br.hotel_project.exceptions.CheckOutException;
import com.br.hotel_project.exceptions.HospedagemException;
import com.br.hotel_project.exceptions.HospedeException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(CheckOutException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleCheckOutException(CheckOutException ex){
        String messageError = ex.getMessage();
        return new ApiErrors(messageError);
    }

    @ExceptionHandler(HospedeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleHospedeNaoEncontradoException(HospedeException ex){
        String messageError = ex.getMessage();
        return new ApiErrors(messageError);
    }

    @ExceptionHandler(HospedagemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleHospedagemNaoEncontradaException(HospedagemException ex){
        String messageError = ex.getMessage();
        return new ApiErrors(messageError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors hendleMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return new ApiErrors(errors);
    }
}
