package com.br.hotel_project.services;

import com.br.hotel_project.models.Hospede;
import java.util.List;
import java.util.Optional;

public interface HospedeService {

    Optional<Hospede> findById(Integer id);

    List<Hospede> findAll();

    Hospede save(Hospede hospede);

    List<Hospede> findExHospedes();

    void delete(Hospede hospede);

    Hospede update(Hospede hospede);
}
