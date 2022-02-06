package com.br.hotel_project.rest.dtos.get;

import com.br.hotel_project.enums.StatusHospedagem;
import com.br.hotel_project.models.Hospedagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospedagemDTO {

    private Integer numeroQuarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private Double valor;
    private StatusHospedagem status;
    private Boolean comGaragem;

    public HospedagemDTO(Hospedagem hospedagem){
        this.numeroQuarto = hospedagem.getNumeroQuarto();
        this.dataCheckIn = hospedagem.getDataCheckIn();
        this.dataCheckOut = hospedagem.getDataCheckOut();
        this.valor = hospedagem.getValor();
        this.status = hospedagem.getStatus();
        this.comGaragem = hospedagem.getComGaragem();
    }

}
