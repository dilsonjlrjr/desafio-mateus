package com.dilsonjlrjr.mateus.estoque.mapper;

import com.dilsonjlrjr.mateus.estoque.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProdutoMapper {
    Produto findById(@Param("id") int id);
}
