package com.dilsonjlrjr.mateus.estoque.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
public class PedidoEstoque {
    private Integer id;
    private LocalDate dataInclusao;
    private String justificativa;
    private Filial filial;
    private Collection<ItemPedido> itemPedidos;
}
