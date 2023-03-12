package com.example.automobilesapi.modules.client.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTOAdminRequest {

    private String senha;
    private String cpf;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
