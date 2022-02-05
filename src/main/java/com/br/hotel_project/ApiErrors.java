package com.br.hotel_project;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class ApiErrors {

    private List<String> errors;

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String mensagemErro) {
        this.errors = new ArrayList<>(Collections.singletonList(mensagemErro));
    }
}
