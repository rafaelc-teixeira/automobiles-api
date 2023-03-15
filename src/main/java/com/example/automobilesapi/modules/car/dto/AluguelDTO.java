package com.example.automobilesapi.modules.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AluguelDTO {
    private Integer carroId;

    private String cpf;

    private String data;
}
