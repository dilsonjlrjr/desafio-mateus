package com.dilsonjlrjr.mateus.estoque.mapper;

import com.dilsonjlrjr.mateus.estoque.model.Estoque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@Sql(
        scripts = { "classpath:/esquema_destroy_schema.sql", "classpath:/estoque_schema.sql", "classpath:/estoque_data.sql" }
)
public class EstoqueMapperTest {

    @Autowired
    EstoqueMapper estoqueMapper;

    int idProduct = 2;

    @Test
    void shouldGetOneProductStock() {

        Estoque estoque = estoqueMapper.findByProduct(idProduct);

        Assertions.assertEquals(30, estoque.getQuantidade());
        Assertions.assertEquals("PIZZA", estoque.getProduto().getNome());
    }

    void shouldInsertProductStock() {

    }
}
