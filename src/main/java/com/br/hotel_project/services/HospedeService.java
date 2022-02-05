package com.br.hotel_project.services;

import com.br.hotel_project.models.Hospede;
import java.util.List;
import java.util.Optional;

public interface HospedeService {

   Optional<Hospede> findByCpf(String cpf);

    List<Hospede> findAll();

    Hospede save(Hospede hospede);

    List<Hospede> findExHospedes();

    void delete(Hospede hospede);
}
