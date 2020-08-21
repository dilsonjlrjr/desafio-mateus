package com.dilsonjlrjr.mateus.estoque.services;

import com.dilsonjlrjr.mateus.estoque.model.ItemPedido;
import com.dilsonjlrjr.mateus.estoque.services.implement.ItemPedidoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoServiceTest {
    ItemPedidoService itemPedidoService;

    @BeforeEach
    void setUp() {
        this.itemPedidoService = new ItemPedidoServiceImpl();
    }

    @Test
    void deveFormalizarItemDeEstoque() {
        //Cenário
        List<ItemPedido> itemPedidos = new ArrayList<>();

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(1);
        itemPedido.setQuantidade(50);

        itemPedidos.add(itemPedido);
        itemPedidos.add(itemPedido);

        //Execução
        List<ItemPedido> itemPedidosNova = this.itemPedidoService.unificaListaItemPedido(itemPedidos);

        //Assertiva
        Assertions.assertEquals(1, itemPedidosNova.size());
        Assertions.assertEquals(100, itemPedidosNova.get(0).getQuantidade());
    }
}
