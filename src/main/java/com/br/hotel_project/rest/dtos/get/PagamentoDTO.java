package com.br.hotel_project.rest.dtos.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO {

    private String extrato;

    public PagamentoDTO(Double valor){

        this.extrato ="Valor total do pagamento: " + valor;
    }



}
