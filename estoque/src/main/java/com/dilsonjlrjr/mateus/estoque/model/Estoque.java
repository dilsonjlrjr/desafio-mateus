package com.dilsonjlrjr.mateus.estoque.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estoque {
    int id;
    int quantidade;
    Produto produto;
}
