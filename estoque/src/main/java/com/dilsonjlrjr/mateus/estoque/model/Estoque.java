package com.dilsonjlrjr.mateus.estoque.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estoque {
    Integer id;
    Integer quantidade;
    Produto produto;
}
