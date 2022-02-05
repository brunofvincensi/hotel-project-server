package com.br.hotel_project.rest.controllers;

import com.br.hotel_project.exceptions.HospedagemException;
import com.br.hotel_project.models.Hospedagem;
import com.br.hotel_project.rest.dtos.get.HospedagemDTO;
import com.br.hotel_project.rest.dtos.get.PagamentoDTO;
import com.br.hotel_project.rest.dtos.insert.HospedagemInsertDTO;
import com.br.hotel_project.servicesImpl.HospedagemServiceImpl;
import com.br.hotel_project.servicesImpl.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/hospedagem")
public class HospedagemController {

    @Autowired
    private HospedagemServiceImpl hospedagemService;

    @Autowired
    private ReservaServiceImpl reservaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hospedagem checkIn(@RequestBody @Valid HospedagemInsertDTO hospedagemInsertDTO){

        return reservaService.checkIn(hospedagemInsertDTO);
    }

    @PatchMapping("/{cpf}")
    public HospedagemDTO checkOut(@PathVariable("cpf") String cpf){

      Hospedagem hospedagem = reservaService.checkOut(cpf);
      return new HospedagemDTO(hospedagem);
    }

    @PatchMapping("/pay/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PagamentoDTO pay(@PathVariable("id") Integer id){
      return reservaService.pay(id);
    }

    @PutMapping("{id}")
    public HospedagemDTO updateHospedagem(@PathVariable("id") Integer id,
                                          @RequestBody HospedagemInsertDTO hospedagemInsertDTO ){

        Hospedagem hospedagem = hospedagemService
                .findById(id)
                .map(h -> {
                    h.setNumeroQuarto(hospedagemInsertDTO.getNumeroQuarto());
                    h.setComGaragem(hospedagemInsertDTO.getComGaragem());

                    return h;
                })
                .orElseThrow(HospedagemException::new);

        return new HospedagemDTO(hospedagem);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHospedagem(@PathVariable("id") Integer id){
      Hospedagem hospedagem =  hospedagemService
              .findById(id)
              .orElseThrow(HospedagemException::new);

        hospedagemService.delete(hospedagem);
    }

}
