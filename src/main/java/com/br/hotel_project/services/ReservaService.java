package com.br.hotel_project.services;

import com.br.hotel_project.models.Hospedagem;
import com.br.hotel_project.rest.dtos.get.PagamentoDTO;
import com.br.hotel_project.rest.dtos.insert.HospedagemInsertDTO;

public interface ReservaService {

    Hospedagem checkIn(HospedagemInsertDTO hospedagemDTO);

    Hospedagem checkOut(Integer id);

    PagamentoDTO pay(Integer hospedagemId);
}
