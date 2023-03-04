package com.example.automobilesapi.modules.car.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "PLACA", nullable = false)
    private String placa;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "DISPONIBILIDADE")
    private Boolean disponibilidade = true;

    @Column(name = "COMBUSTIVEL", nullable = false)
    private String combustivel;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "MOTOR", nullable = false)
    private String motor;

    @Column(name = "POTENCIA", nullable = false)
    private String potencia;

    @Column(name = "AUTONOMIA", nullable = false)
    private String autonomia;


}
