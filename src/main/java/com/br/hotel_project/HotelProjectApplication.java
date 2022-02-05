package com.br.hotel_project;


import com.br.hotel_project.services.HospedagemService;
import com.br.hotel_project.servicesImpl.HospedeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.time.Period;

@SpringBootApplication
public class HotelProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HotelProjectApplication.class, args);
	}

	@Autowired
	HospedeServiceImpl hospedeService;

	@Autowired
	HospedagemService checkService;

	@Override
	public void run(String... args) throws Exception {



	/*	Hospede hospede1 = new Hospede("032.994.880-66", "Bruno", "bruno@gmail", "2222-2222");
		Hospede hospede2 = new Hospede("019.058.530-76", "Joao", "joao@gmail", "9999-9999");

		hospedeRepository.save(hospede1);
		hospedeRepository.save(hospede2);


		checkService.checkIn(new HospedagemInsertDTO(3, true, "032.994.880-66"));
		checkService.checkIn(new HospedagemInsertDTO(5, false, "019.058.530-76"));

		checkService.checkOut("032.994.880-66");

		checkService.checkIn(new HospedagemInsertDTO(6, false, "032.994.880-66"));

	 */


		LocalDate dataCheckIn = LocalDate.now().minusDays(6);


		Period until = dataCheckIn.until(LocalDate.now());

		System.out.println(until.getDays());
	}
}
