package com.dilsonjlrjr.mateus.estoque.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedido {
    private Integer id;
    private Character tipoDeRegistro;
    private Integer quantidade;
    private Produto produto;
}
