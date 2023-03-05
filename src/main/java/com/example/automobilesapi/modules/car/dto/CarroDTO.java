package com.example.automobilesapi.modules.car.dto;

import com.example.automobilesapi.modules.car.model.Carro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    private Integer id;
    private String placa;
    private String modelo;
    private String descricao;
    private Boolean disponibilidade;
    private String combustivel;
    private String nome;
    private String motor;
    private String potencia;
    private String autonomia;
    private Double valorDia;
    private Double taxa;

    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.placa = carro.getPlaca();
        this.modelo = carro.getModelo();
        this.descricao = carro.getDescricao();
        this.disponibilidade = carro.getDisponibilidade();
        this.combustivel = carro.getCombustivel();
        this.nome = carro.getNome();
        this.motor = carro.getMotor();
        this.potencia = carro.getPotencia();
        this.autonomia = carro.getAutonomia();
        this.valorDia = carro.getValorDia();
        this.taxa = carro.getTaxa();
    }

    public Carro toCarro() {
        Carro carro = new Carro();
        carro.setPlaca(this.getPlaca());
        carro.setModelo(this.getModelo());
        carro.setDescricao(this.getDescricao());
        carro.setDisponibilidade(this.getDisponibilidade());
        carro.setCombustivel(this.getCombustivel());
        carro.setNome(this.getNome());
        carro.setMotor(this.getMotor());
        carro.setPotencia(this.getPotencia());
        carro.setAutonomia(this.getAutonomia());
        carro.setValorDia(this.getValorDia());
        carro.setTaxa(this.getTaxa());
        return carro;
    }

    public void updateFromDTO(CarroDTO carroDTO) {
        this.setId(carroDTO.getId());
        this.setPlaca(carroDTO.getPlaca());
        this.setModelo(carroDTO.getModelo());
        this.setDescricao(carroDTO.getDescricao());
        this.setDisponibilidade(carroDTO.getDisponibilidade());
        this.setCombustivel(carroDTO.getCombustivel());
        this.setNome(carroDTO.getNome());
        this.setMotor(carroDTO.getMotor());
        this.setPotencia(carroDTO.getPotencia());
        this.setAutonomia(carroDTO.getAutonomia());
        this.setValorDia(carroDTO.getValorDia());
        this.setTaxa(carroDTO.getTaxa());
    }
}
