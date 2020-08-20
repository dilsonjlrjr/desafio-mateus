package com.dilsonjlrjr.mateus.estoque.services;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.EstoqueServiceException;
import com.dilsonjlrjr.mateus.estoque.exceptions.services.ProdutoServiceException;
import com.dilsonjlrjr.mateus.estoque.model.Estoque;

public interface EstoqueService {
    void updateStock(Estoque estoque) throws EstoqueServiceException, ProdutoServiceException;
}
