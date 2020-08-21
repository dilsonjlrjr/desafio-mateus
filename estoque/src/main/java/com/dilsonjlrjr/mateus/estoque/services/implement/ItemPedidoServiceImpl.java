package com.dilsonjlrjr.mateus.estoque.services.implement;

import com.dilsonjlrjr.mateus.estoque.model.ItemPedido;
import com.dilsonjlrjr.mateus.estoque.services.ItemPedidoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

    public List<ItemPedido> unificaListaItemPedido(List<ItemPedido> itemPedidos) {
        HashMap<Integer, ItemPedido> hashItemPedido = new HashMap<>();

        if (itemPedidos.size() == 0) return itemPedidos;

        itemPedidos.stream().forEach(itemPedido -> {
            ItemPedido itemPedidoHash;
            if (hashItemPedido.containsKey(itemPedido.getId())) {
                itemPedidoHash = hashItemPedido.get(itemPedido.getId());
                itemPedidoHash.setQuantidade(itemPedidoHash.getQuantidade() + itemPedido.getQuantidade());

                hashItemPedido.put(itemPedido.getId(), itemPedidoHash);
            } else {
                hashItemPedido.put(itemPedido.getId(), itemPedido);
            }
        });

        return new ArrayList<>(hashItemPedido.values());
    }
}
