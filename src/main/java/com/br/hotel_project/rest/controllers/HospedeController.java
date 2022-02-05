package com.br.hotel_project.rest.controllers;

import com.br.hotel_project.exceptions.HospedeException;
import com.br.hotel_project.models.Hospede;
import com.br.hotel_project.rest.dtos.get.HospedeDTO;
import com.br.hotel_project.rest.dtos.insert.HospedeInsertDTO;
import com.br.hotel_project.servicesImpl.HospedeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hospede")
public class HospedeController {

    @Autowired
    private HospedeServiceImpl hospedeService;

    @GetMapping
    public List<HospedeDTO> findAll(){

        return hospedeService
                .findAll()
                .stream()
                .map(HospedeDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{cpf}")
    public HospedeDTO findByCpf(@PathVariable("cpf") String cpf){
      return hospedeService
              .findByCpf(cpf)
              .map(HospedeDTO::new)
              .orElseThrow(HospedeException::new);
    }

    @GetMapping("/ex_hospedes")
    public List<HospedeDTO> findExHospedes(){
        return hospedeService
                .findExHospedes()
                .stream()
                .map(HospedeDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeDTO insertHospede(@RequestBody @Valid HospedeInsertDTO hospedeInsertDTO){

        Hospede hospede = hospedeInsertDTO.coverter();
        hospedeService.save(hospede);

        return new HospedeDTO(hospede);
    }

    @PutMapping("/{cpf}")
    public HospedeDTO updateHospede(@PathVariable String cpf,
                                    @RequestBody @Valid HospedeInsertDTO hospedeInsertDTO){

        Hospede hospede = hospedeService
                .findByCpf(cpf)
                .map(h -> {
                    h.setNome(hospedeInsertDTO.getNome());
                    h.setEmail(hospedeInsertDTO.getEmail());
                    h.setTelefone(hospedeInsertDTO.getTelefone());
                    return h;})
                .orElseThrow(HospedeException::new);

      return new HospedeDTO(hospedeService.save(hospede));
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String cpf){

        Hospede hospede = hospedeService
                .findByCpf(cpf)
                .orElseThrow(HospedeException::new);

        hospedeService.delete(hospede);
    }
}
