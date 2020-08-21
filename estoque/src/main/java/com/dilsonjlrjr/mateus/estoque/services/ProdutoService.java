package com.dilsonjlrjr.mateus.estoque.services;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.ProdutoServiceException;
import com.dilsonjlrjr.mateus.estoque.model.Produto;

public interface ProdutoService {
    Produto buscarProdutoId(int id) throws ProdutoServiceException;
}
