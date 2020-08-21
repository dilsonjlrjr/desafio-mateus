package com.dilsonjlrjr.mateus.estoque.services;

import com.dilsonjlrjr.mateus.estoque.model.ItemPedido;

import java.util.List;

public interface ItemPedidoService {
    List<ItemPedido> unificaListaItemPedido(List<ItemPedido> itemPedidos);
}
