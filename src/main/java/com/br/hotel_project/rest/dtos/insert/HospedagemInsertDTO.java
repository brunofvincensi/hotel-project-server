package com.br.hotel_project.rest.dtos.insert;

import com.br.hotel_project.exceptions.HospedeException;
import com.br.hotel_project.models.Hospedagem;
import com.br.hotel_project.models.Hospede;
import com.br.hotel_project.servicesImpl.HospedeServiceImpl;
import com.br.hotel_project.annotations.Quarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospedagemInsertDTO {

    @NotNull(message = "{campo.numero-quarto.obrigatorio}")
    @Quarto
    private Integer numeroQuarto;

    @NotNull(message = "{campo.com-garagem.obrigatorio}")
    private Boolean comGaragem;

    @NotNull(message = "{campo.hospede-id.obrigatorio}")
    private Integer hospedeId;

    public Hospedagem coverter(HospedeServiceImpl hospedeService) {

       Hospede hospede = hospedeService
               .findById(hospedeId)
               .orElseThrow(HospedeException::new);


        return new Hospedagem(numeroQuarto, hospede, comGaragem);
    }

}
