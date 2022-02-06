package com.br.hotel_project.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOutDTO {

    @NotNull(message = "{campo.hospede-id.obrigatorio}")
    private Integer id;
}
