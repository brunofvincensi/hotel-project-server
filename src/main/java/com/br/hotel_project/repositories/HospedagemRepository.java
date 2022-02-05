package com.br.hotel_project.repositories;

import com.br.hotel_project.models.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer> {
}
