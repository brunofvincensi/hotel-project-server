package com.br.hotel_project.rest.dtos.get;

import com.br.hotel_project.models.Hospede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospedeDTO {

    private String nome;
    private String email;
    private String telefone;
    private HospedagemDTO hospedagemAtual;
    private List<HospedagemDTO> hospedagens;

    public HospedeDTO(Hospede hospede) {
        this.nome = hospede.getNome();
        this.email = hospede.getEmail();
        this.telefone = hospede.getTelefone();

        if(hospede.getHospedagemAtual() != null){
        this.hospedagemAtual = new HospedagemDTO(hospede.getHospedagemAtual());}

        this.hospedagens =  hospede.getHospedagemList()
                .stream()
                .map(HospedagemDTO::new)
                .collect(Collectors.toList());

    }
}
