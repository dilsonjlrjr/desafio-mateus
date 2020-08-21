package com.dilsonjlrjr.mateus.estoque.services;


import com.dilsonjlrjr.mateus.estoque.model.Filial;
import com.dilsonjlrjr.mateus.estoque.model.ItemPedido;
import com.dilsonjlrjr.mateus.estoque.model.PedidoEstoque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoEstoqueServiceTest {

    PedidoEstoque pedidoEstoque;

    PedidoEstoqueService pedidoEstoqueService;

    @BeforeEach
    void setUp() {
        Filial filial = new Filial();
        filial.setId(1);

        List<ItemPedido> itemPedidos = new ArrayList<>();

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(1);
        itemPedido.setTipoDeRegistro('E');
        itemPedido.setQuantidade(50);

        itemPedidos.add(itemPedido);
        itemPedidos.add(itemPedido);

        this.pedidoEstoque.setDataInclusao(LocalDate.now());
        this.pedidoEstoque.setFilial(filial);
        this.pedidoEstoque.setJustificativa("Loren Ipsum");
        this.pedidoEstoque.setItemPedidos(itemPedidos);
    }


    void deveSalvarUmPedidoDeEstoque() {

        this.pedidoEstoqueService.salvarPedidoDeEstoque(this.pedidoEstoque);

    }
}
