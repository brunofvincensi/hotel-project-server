package com.br.hotel_project.servicesImpl;

import com.br.hotel_project.exceptions.HospedeException;
import com.br.hotel_project.models.Hospede;
import com.br.hotel_project.repositories.HospedeRepository;
import com.br.hotel_project.services.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeServiceImpl implements HospedeService {

    @Autowired
    private HospedeRepository repository;

    @Override
    public Optional<Hospede> findByCpf(String cpf){

       Hospede hospede = repository.findByCpf(cpf);
       if (hospede != null){
           return Optional.of(hospede);
       }
        return Optional.empty();
    }

    @Override
    public List<Hospede> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Hospede save(Hospede hospede){
       if( repository.findByCpf(hospede.getCpf()) != null){
           throw new HospedeException("cpf já cadastrado");
       }

       return repository.save(hospede);
    }

    @Override
    public List<Hospede> findExHospedes() {
        return repository.findExHospedes();
    }

    @Override
    public void delete(Hospede hospede) {
        repository.delete(hospede);
    }
}
