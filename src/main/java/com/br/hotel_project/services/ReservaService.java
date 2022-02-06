package com.br.hotel_project.services;

import com.br.hotel_project.models.Hospedagem;
import com.br.hotel_project.rest.dtos.get.PagamentoDTO;
import com.br.hotel_project.rest.dtos.insert.HospedagemInsertDTO;

public interface ReservaService {

    //faz o check in da hospedagem
    Hospedagem checkIn(HospedagemInsertDTO hospedagemDTO);

    //faz o check out da hospedagem calculando o valor gasto
    Hospedagem checkOut(Integer id);

    //faz o pagamento da hospedagem e se for pago após o dia do check-out será cobrado uma multa
    PagamentoDTO pay(Integer hospedagemId);
}
