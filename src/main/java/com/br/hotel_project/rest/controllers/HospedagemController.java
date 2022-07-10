package com.br.hotel_project.rest.controllers;

import com.br.hotel_project.exceptions.HospedagemException;
import com.br.hotel_project.models.Hospedagem;
import com.br.hotel_project.rest.dtos.CheckOutDTO;
import com.br.hotel_project.rest.dtos.get.HospedagemDTO;
import com.br.hotel_project.rest.dtos.get.PagamentoDTO;
import com.br.hotel_project.rest.dtos.insert.HospedagemInsertDTO;
import com.br.hotel_project.servicesImpl.HospedagemServiceImpl;
import com.br.hotel_project.servicesImpl.ReservaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/hospedagem")
@CrossOrigin("http://localhost:4200")
public class HospedagemController {

    private final HospedagemServiceImpl hospedagemService;

    private final ReservaServiceImpl reservaService;

    public HospedagemController(HospedagemServiceImpl hospedagemService, ReservaServiceImpl reservaService) {
        this.hospedagemService = hospedagemService;
        this.reservaService = reservaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hospedagem checkIn(@RequestBody @Valid HospedagemInsertDTO hospedagemInsertDTO){

        return reservaService.checkIn(hospedagemInsertDTO);
    }

    @PatchMapping
    public HospedagemDTO checkOut(@RequestBody CheckOutDTO checkOutDTO){

      Hospedagem hospedagem = reservaService.checkOut(checkOutDTO.getId());
      return new HospedagemDTO(hospedagem);
    }

    @PatchMapping("/pay/{hospedagemId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PagamentoDTO pay(@PathVariable("hospedagemId") Integer hospedagemId){
      return reservaService.pay(hospedagemId);
    }

    @PutMapping("{hospedagemId}")
    public HospedagemDTO updateHospedagem(@PathVariable("hospedagemId") Integer hospedagemId,
                                          @RequestBody HospedagemInsertDTO hospedagemInsertDTO ){

        Hospedagem hospedagem = hospedagemService
                .findById(hospedagemId)
                .map(h -> {
                    h.setNumeroQuarto(hospedagemInsertDTO.getNumeroQuarto());
                    h.setComGaragem(hospedagemInsertDTO.getComGaragem());
                    return h;
                })
                .orElseThrow(HospedagemException::new);

        return new HospedagemDTO(hospedagem);
    }

    @DeleteMapping("/{hospedagemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHospedagem(@PathVariable("hospedagemId") Integer hospedagemId){
      Hospedagem hospedagem =  hospedagemService
              .findById(hospedagemId)
              .orElseThrow(HospedagemException::new);

        hospedagemService.delete(hospedagem);
    }

}
