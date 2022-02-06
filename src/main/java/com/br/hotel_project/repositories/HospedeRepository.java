package com.br.hotel_project.repositories;

import com.br.hotel_project.models.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {

    @Query("select h from Hospede h where h.cpf = :cpf")
    Hospede findByCpf(@Param("cpf") String cpf);

}
