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
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/{id}")
    public HospedeDTO findById(@PathVariable("id") Integer id){
      return hospedeService
              .findById(id)
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

    @PutMapping("/{id}")
    public HospedeDTO updateHospede(@PathVariable("id") Integer id,
                                    @RequestBody @Valid HospedeInsertDTO hospedeInsertDTO){

        Hospede hospede = hospedeService
                .findById(id)
                .map(h -> {
                    h.setCpf(hospedeInsertDTO.getCpf());
                    h.setNome(hospedeInsertDTO.getNome());
                    h.setEmail(hospedeInsertDTO.getEmail());
                    h.setTelefone(hospedeInsertDTO.getTelefone());
                    return h;})
                .orElseThrow(HospedeException::new);

      return new HospedeDTO(hospedeService.update(hospede));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){

        Hospede hospede = hospedeService
                .findById(id)
                .orElseThrow(HospedeException::new);

        hospedeService.delete(hospede);
    }
}
