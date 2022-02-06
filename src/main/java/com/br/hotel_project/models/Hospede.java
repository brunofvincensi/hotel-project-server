package com.br.hotel_project.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_hospede")
public class Hospede{

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "cpf", length = 15)
    private String cpf;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telefone", length = 50)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospedagem_id")
    private Hospedagem hospedagemAtual;

    @OneToMany(mappedBy = "hospede", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Hospedagem> hospedagemList;

    public Hospede(String cpf, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public List<Hospedagem> getHospedagemList(){
        if(this.hospedagemList == null){
            this.hospedagemList = new ArrayList<>();
        }
        return this.hospedagemList;
    }

}
