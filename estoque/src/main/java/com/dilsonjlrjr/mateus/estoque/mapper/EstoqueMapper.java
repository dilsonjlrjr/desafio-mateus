package com.dilsonjlrjr.mateus.estoque.mapper;

import com.dilsonjlrjr.mateus.estoque.model.Estoque;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EstoqueMapper {

    void update(@Param("estoque") Estoque estoque);
    Estoque findByProduct(@Param("id") int id);
}
