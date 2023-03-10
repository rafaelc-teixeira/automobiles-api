package com.example.automobilesapi.modules.client.model;

import com.example.automobilesapi.modules.car.model.Carro;
import com.example.automobilesapi.modules.client.dto.ClienteDTO;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "IS_ADMIN")
    private Boolean admin = false;

    public ClienteDTO convertToDTO() {
        return new ClienteDTO(
                this.getId(),
                this.getNome(),
                this.getEmail(),
                this.getCpf(),
                this.getSenha(),
                this.getAdmin()
        );
    }
}
