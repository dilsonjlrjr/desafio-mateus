package com.dilsonjlrjr.mateus.estoque.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private int id;
    private String nome;
    private Filial filial;
}