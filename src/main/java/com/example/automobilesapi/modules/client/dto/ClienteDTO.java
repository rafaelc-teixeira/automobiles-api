package com.example.automobilesapi.modules.client.dto;

import com.example.automobilesapi.modules.client.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Integer id;

    private String nome;

    private String email;

    private String cpf;

    private String senha;

    private Boolean admin = false;

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.getNome());
        cliente.setEmail(this.getEmail());
        cliente.setCpf(this.getCpf());
        cliente.setSenha(this.getSenha());
        cliente.setAdmin(this.getAdmin());
        return cliente;
    }
}
