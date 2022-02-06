package com.br.hotel_project.servicesImpl;

import com.br.hotel_project.models.Hospede;
import com.br.hotel_project.repositories.HospedeRepository;
import com.br.hotel_project.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospedeServiceImpl implements HospedeService {


    @Autowired
    private HospedeRepository repository;

    @Override
    public Optional<Hospede> findById(Integer id){
       return repository.findById(id);
    };

    @Override
    public List<Hospede> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Hospede save(Hospede hospede){
        return repository.save(hospede);
    }

    @Override
    @Transactional
    public Hospede update(Hospede hospede){
        return repository.save(hospede);
    }

    @Override
    public List<Hospede> findExHospedes() {

        return repository
                .findAll()
                .stream()
                .filter(x -> !x.getHospedagemList().isEmpty() && x.getHospedagemAtual() == null)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Hospede hospede) {
        repository.delete(hospede);
    }
}
