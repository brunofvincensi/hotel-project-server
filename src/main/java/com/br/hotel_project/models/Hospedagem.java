package com.br.hotel_project.models;

import com.br.hotel_project.enums.StatusHospedagem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_hospedagem")
public class Hospedagem {
    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_quarto")
    private Integer numeroQuarto;

    @Column(name = "data_check_in")
    private LocalDate dataCheckIn;

    @Column(name = "data_check_out")
    private LocalDate dataCheckOut;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private StatusHospedagem status;

    @Column(name = "com_garagem")
    private Boolean comGaragem;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hospede_id", nullable = false)
    private Hospede hospede;

    public Hospedagem(Integer numeroQuarto, Hospede hospede, Boolean comGaragem){
        this.valor = 0.0;
        this.dataCheckIn = LocalDate.now();
        this.numeroQuarto = numeroQuarto;
        this.status = StatusHospedagem.CHECKED_IN;
        this.hospede = hospede;
        this.comGaragem = comGaragem;
    }

    public void addDaily(LocalDate dia){

        DayOfWeek dayOfWeek = dia.getDayOfWeek();

        boolean isWeekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;

        if(this.comGaragem){
            this.valor += isWeekend ? 170.0 : 135.0;
        } else {
            this.valor +=  isWeekend ?  150.0 : 120.0;
        }
    }

}
