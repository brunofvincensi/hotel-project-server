package com.br.hotel_project.servicesImpl;

import com.br.hotel_project.enums.StatusHospedagem;
import com.br.hotel_project.exceptions.HospedagemException;
import com.br.hotel_project.exceptions.HospedeException;
import com.br.hotel_project.models.Hospedagem;
import com.br.hotel_project.models.Hospede;
import com.br.hotel_project.repositories.HospedagemRepository;
import com.br.hotel_project.rest.dtos.get.PagamentoDTO;
import com.br.hotel_project.rest.dtos.insert.HospedagemInsertDTO;
import com.br.hotel_project.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Autowired
    private HospedeServiceImpl hospedeService;

    @Override
    @Transactional
    public Hospedagem checkIn(HospedagemInsertDTO hospedagemDTO) {

        Hospede hospede =  hospedeService
                .findById(hospedagemDTO.getHospedeId())
                .orElseThrow(HospedeException::new);

        if(hospede.getHospedagemAtual() == null){

            Hospedagem hospedagem = hospedagemRepository.save(new Hospedagem(hospedagemDTO.getNumeroQuarto(),
                    hospede, hospedagemDTO.getComGaragem()));

            hospede.setHospedagemAtual(hospedagem);

            hospedeService.save(hospede);

            return hospedagem;}
        else {
            throw new HospedagemException("Hóspede já tem uma hospedagem ativa");
        }
    }

    @Override
    @Transactional
    public Hospedagem checkOut(Integer id) {

        Hospede hospede = hospedeService
                .findById(id)
                .orElseThrow(HospedeException::new);

        Hospedagem hospedagemAtual = hospede.getHospedagemAtual();

        if(hospedagemAtual != null){

            setValorDiarias(hospedagemAtual);
            hospedagemAtual.setDataCheckOut(LocalDate.now());
            hospedagemAtual.setStatus(StatusHospedagem.CHECKED_OUT);
            hospede.setHospedagemAtual(null);

            return hospedagemRepository.save(hospedagemAtual);
        }
        else {
            throw new HospedagemException("Hóspede não tem nenhuma hospedagem ativa");
        }
    }

    public void setValorDiarias(Hospedagem hospedagem){

        LocalDate dataCheckIn = hospedagem.getDataCheckIn();

        int periodo = dataCheckIn.until(LocalDate.now()).getDays();

        if(periodo != 0){

            for (int i = 0; i < periodo; i++){

                hospedagem.addDaily(dataCheckIn.plusDays(i));
            }

            if(LocalTime.now().isAfter(LocalTime.of(16, 30))){

                hospedagem.addDaily(LocalDate.now());
            }}

        else {
            hospedagem.addDaily(dataCheckIn);
        }
    }

    @Override
    @Transactional
    public PagamentoDTO pay(Integer hospedagemId){
        Hospedagem hospedagem = hospedagemRepository.getById(hospedagemId);

        switch (hospedagem.getStatus()){
            case CHECKED_IN:throw new HospedagemException("Não foi realizado o check out ainda.");
            case PAID:throw new HospedagemException("A hospedagem já foi paga.");
        }

        if(LocalDate.now().isAfter(hospedagem.getDataCheckOut())){

            Double multa = fine(hospedagem.getValor());
        }

        hospedagem.setStatus(StatusHospedagem.PAID);
        hospedagemRepository.save(hospedagem);

        return new PagamentoDTO(hospedagem.getValor());
    }

    public Double fine(Double valor){

        return valor + (valor * 0.10);
    }
}
