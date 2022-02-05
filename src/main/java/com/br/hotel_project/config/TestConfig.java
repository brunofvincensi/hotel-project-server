package com.br.hotel_project.config;

import com.br.hotel_project.annotations.Test;
import com.br.hotel_project.models.Hospede;
import com.br.hotel_project.rest.dtos.insert.HospedagemInsertDTO;
import com.br.hotel_project.services.HospedagemService;
import com.br.hotel_project.servicesImpl.HospedeServiceImpl;
import com.br.hotel_project.servicesImpl.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Test
public class TestConfig {

    @Autowired
    private HospedeServiceImpl hospedeService;

    @Autowired
    private HospedagemService checkService;

    @Autowired
    private ReservaServiceImpl reservaService;

    @Bean
    public CommandLineRunner runTest(){
        return args -> {
            Hospede hospede1 = new Hospede("032.994.880-66", "Bruno", "bruno@gmail.com", "2222-2222");
            Hospede hospede2 = new Hospede("019.058.530-76", "Joao", "joao@gmail.com", "9999-9999");

            hospedeService.save(hospede1);
            hospedeService.save(hospede2);


            reservaService.checkIn(new HospedagemInsertDTO(3, true, "032.994.880-66"));
            reservaService.checkIn(new HospedagemInsertDTO(5, false, "019.058.530-76"));

            reservaService.checkOut("032.994.880-66");

            reservaService.checkIn(new HospedagemInsertDTO(6, false, "032.994.880-66"));
        };
    }
}
