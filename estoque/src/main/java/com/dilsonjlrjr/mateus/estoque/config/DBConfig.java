package com.dilsonjlrjr.mateus.estoque.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.dilsonjlrjr.mateus.estoque.mapper")
public class DBConfig {
}
