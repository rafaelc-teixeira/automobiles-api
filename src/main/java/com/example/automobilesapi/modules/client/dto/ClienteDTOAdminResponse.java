package com.example.automobilesapi.modules.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTOAdminResponse {

    private boolean admin;
    private String senha;
}
