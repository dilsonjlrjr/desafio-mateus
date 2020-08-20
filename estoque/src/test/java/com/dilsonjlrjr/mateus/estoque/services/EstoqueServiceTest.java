package com.dilsonjlrjr.mateus.estoque.services;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.EstoqueServiceException;
import com.dilsonjlrjr.mateus.estoque.exceptions.services.ProdutoServiceException;
import com.dilsonjlrjr.mateus.estoque.mapper.EstoqueMapper;
import com.dilsonjlrjr.mateus.estoque.mapper.ProdutoMapper;
import com.dilsonjlrjr.mateus.estoque.model.Estoque;
import com.dilsonjlrjr.mateus.estoque.model.Produto;
import com.dilsonjlrjr.mateus.estoque.services.implement.EstoqueServiceImpl;
import com.dilsonjlrjr.mateus.estoque.services.implement.ProdutoServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EstoqueServiceTest {

    EstoqueMapper estoqueMapper;
    EstoqueServiceImpl estoqueServiceImpl;

    ProdutoMapper produtoMapper;
    ProdutoServiceImpl produtoServiceImpl;
    Produto produto;

    Estoque estoque;

    @BeforeEach
    void setUp() {
        this.estoqueMapper = Mockito.mock(EstoqueMapper.class);
        this.produtoServiceImpl = Mockito.mock(ProdutoServiceImpl.class);

        this.estoqueServiceImpl = new EstoqueServiceImpl(this.estoqueMapper, this.produtoServiceImpl);
        this.estoque = new Estoque();

        this.produto = new Produto();
        this.produto.setId(1);
        this.produto.setNome("Pizza");

        this.estoque.setId(1);
        this.estoque.setQuantidade(15);
        this.estoque.setProduto(produto);
    }

    void deveTestarInsercaoPedidoEstoque() {

    }

    @Test
    void deveTestarAtualizacaoPedidoEstoque() throws ProdutoServiceException, EstoqueServiceException {

        Mockito.spy(this.estoqueMapper);

        Mockito.doNothing()
                .when(this.estoqueMapper)
                .update(Mockito.any(Estoque.class));

        Mockito.when(this.produtoServiceImpl.buscarProdutoId(Mockito.anyInt()))
                .thenReturn(this.produto);

        this.estoqueServiceImpl.updateStock(estoque);

        Mockito.verify(this.estoqueMapper, Mockito.times(1))
                .update(Mockito.isA(Estoque.class));
    }

    @Test
    void deveTestarExcecaoProdutoNaoEncontrado() throws ProdutoServiceException {

        Mockito.when(this.produtoServiceImpl.buscarProdutoId(Mockito.anyInt()))
                .thenThrow(ProdutoServiceException.class);

        Assertions.assertThrows(ProdutoServiceException.class, () -> this.estoqueServiceImpl.updateStock(estoque));
    }

    void deveTestarExcecaoBancoDados() {

    }

    @Test
    void deveTestarExcecaoEstoqueNegativo() {
        this.estoque.setQuantidade(-1);

        Assertions.assertThrows(
                EstoqueServiceException.class,
                () -> this.estoqueServiceImpl.updateStock(estoque),
                "Estoque irá ficar negativo com esta retirada! Operação abortada."
        );
    }

    @AfterEach
    void tearDown() {
        Mockito.reset(this.estoqueMapper, this.produtoServiceImpl);
    }
}
