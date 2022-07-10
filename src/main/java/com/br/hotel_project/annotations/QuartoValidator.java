package com.br.hotel_project.annotations;

import com.br.hotel_project.servicesImpl.HospedeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QuartoValidator implements ConstraintValidator<Quarto, Integer> {

    @Autowired
    HospedeServiceImpl hospedeService;

    public void initialize(Quarto constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    public boolean isValid(Integer quartoParaEnviar, ConstraintValidatorContext constraintValidatorContext) {
      if(quartoParaEnviar == null){
          return false;
      }

        return hospedeService
              .findAll()
              .stream()
                .filter(x -> x.getHospedagemAtual() != null)
              .noneMatch(x -> quartoParaEnviar.equals(x.getHospedagemAtual().getNumeroQuarto()));
    }
}
