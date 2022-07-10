package com.br.hotel_project.services;

import com.br.hotel_project.models.Hospedagem;

import java.util.Optional;

public interface HospedagemService {

    Optional<Hospedagem> findById(Integer id);

    void delete(Hospedagem hospedagem);
}
