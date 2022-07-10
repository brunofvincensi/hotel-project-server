package com.br.hotel_project.servicesImpl;

import com.br.hotel_project.models.Hospedagem;
import com.br.hotel_project.repositories.HospedagemRepository;
import com.br.hotel_project.services.HospedagemService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospedagemServiceImpl implements HospedagemService {

    private final HospedagemRepository hospedagemRepository;

    public HospedagemServiceImpl(HospedagemRepository hospedagemRepository) {
        this.hospedagemRepository = hospedagemRepository;
    }

    @Override
    public Optional<Hospedagem> findById(Integer id) {
        return hospedagemRepository.findById(id);
    }

    @Override
    public void delete(Hospedagem hospedagem) {
        hospedagemRepository.delete(hospedagem);
    }
}
