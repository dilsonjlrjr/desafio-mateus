package com.dilsonjlrjr.mateus.estoque.services.implement;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.EstoqueServiceException;
import com.dilsonjlrjr.mateus.estoque.exceptions.services.ProdutoServiceException;
import com.dilsonjlrjr.mateus.estoque.mapper.EstoqueMapper;
import com.dilsonjlrjr.mateus.estoque.model.Estoque;
import com.dilsonjlrjr.mateus.estoque.services.EstoqueService;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    EstoqueMapper estoqueMapper;

    ProdutoServiceImpl produtoServiceImpl;

    public EstoqueServiceImpl(EstoqueMapper estoqueMapper, ProdutoServiceImpl produtoServiceImpl) {
        this.estoqueMapper = estoqueMapper;
        this.produtoServiceImpl = produtoServiceImpl;
    }

    public void updateStock(Estoque estoque) throws EstoqueServiceException, ProdutoServiceException {

        if (estoque.getQuantidade() < 0)
            throw new EstoqueServiceException("Estoque irá ficar negativo com esta retirada! Operação abortada.");

        this.produtoServiceImpl.buscarProdutoId(estoque.getProduto().getId());

        try {
            this.estoqueMapper.update(estoque);
        } catch (PersistenceException e) {
            throw new EstoqueServiceException("Ocorreu um erro ao atualizar o estoque.", e);
        }
    }
}
