package com.br.hotel_project.services;

import com.br.hotel_project.models.Hospedagem;
import java.util.List;
import java.util.Optional;

public interface HospedagemService {

    List<Hospedagem> findAll();

    Optional<Hospedagem> findById(Integer id);

    void delete(Hospedagem hospedagem);
}
