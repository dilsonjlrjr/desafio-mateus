package com.dilsonjlrjr.mateus.estoque.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class FilialDTO {

    private Integer id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Size(min=5, max = 200, message = "O nome deve ter no mínimo {min} e limite máximo de {max} caracteres.")
    private String nome;
}
