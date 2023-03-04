package com.example.automobilesapi.modules.client.model;

import com.example.automobilesapi.modules.car.model.Carro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "FK_CARRO")
    private Carro carro;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false)
    private String email;

    @Column(name = "EMAIL", nullable = false)
    private String senha;

    @Column(name = "ADMIN")
    private Boolean admin = false;


}
