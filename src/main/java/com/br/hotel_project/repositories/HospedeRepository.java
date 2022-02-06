package com.br.hotel_project.repositories;

import com.br.hotel_project.models.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {
}
