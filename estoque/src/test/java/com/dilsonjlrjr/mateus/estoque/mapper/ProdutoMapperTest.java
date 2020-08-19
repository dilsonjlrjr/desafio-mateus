package com.dilsonjlrjr.mateus.estoque.mapper;

import com.dilsonjlrjr.mateus.estoque.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ProdutoMapperTest {

    @Autowired
    ProdutoMapper produtoMapper;

    @Test
    void shouldFindProductById() {
        // Cenário e Execução
        Produto produto = produtoMapper.findById(1);

        //Validação
        Assertions.assertEquals(produto.getId(), 1);
        Assertions.assertEquals(produto.getNome(), "MAÇÃ");
        Assertions.assertEquals(produto.getFilial().getNome(), "NOSSO CHEFF");
    }
}
