package com.dilsonjlrjr.mateus.estoque.services.implement;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.ProdutoServiceException;
import com.dilsonjlrjr.mateus.estoque.mapper.ProdutoMapper;
import com.dilsonjlrjr.mateus.estoque.model.Produto;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements com.dilsonjlrjr.mateus.estoque.services.ProdutoService {

    ProdutoMapper produtoMapper;

    public ProdutoServiceImpl(ProdutoMapper produtoMapper) {
        this.produtoMapper = produtoMapper;
    }

    @Override
    public Produto buscarProdutoId(int id) throws ProdutoServiceException {
        try {
            return this.produtoMapper.findById(id);
        } catch (PersistenceException e) {
            throw new ProdutoServiceException("Produto não encontrado.");
        }
    }
}
