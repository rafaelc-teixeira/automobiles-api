package com.example.automobilesapi.modules.car.model;

import com.example.automobilesapi.modules.car.dto.CarroDTO;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "VALOR_DIA", nullable = false)
    private Double valorDia;

    @Column(name = "TAXA", nullable = false)
    private Double taxa;

    public CarroDTO convertToDTO() {
        return new CarroDTO(
                this.getId(),
                this.getPlaca(),
                this.getModelo(),
                this.getDescricao(),
                this.getDisponibilidade(),
                this.getCombustivel(),
                this.getNome(),
                this.getMotor(),
                this.getPotencia(),
                this.getAutonomia(),
                this.getValorDia(),
                this.getTaxa()
        );
    }

}
