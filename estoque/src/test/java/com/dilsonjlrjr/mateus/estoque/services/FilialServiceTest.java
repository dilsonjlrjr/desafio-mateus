package com.dilsonjlrjr.mateus.estoque.services;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.FilialServiceException;
import com.dilsonjlrjr.mateus.estoque.mapper.FilialMapper;
import com.dilsonjlrjr.mateus.estoque.model.Filial;
import com.dilsonjlrjr.mateus.estoque.services.implement.FilialServiceImpl;
import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FilialServiceTest {


    FilialService filialService;

    FilialMapper filialMapper;

    Filial filial;

    @BeforeEach
    void setUp() {
        this.filialMapper = Mockito.mock(FilialMapper.class);
        this.filialService = new FilialServiceImpl(filialMapper);
    }

    @Test
    void shouldCreateFilial() throws FilialServiceException {

        //#region Cenário
        filial = new Filial();
        filial.setNome("Mateus");
        //#endregion

        Mockito
                .doNothing().when(filialMapper)
                .save(Mockito.any(Filial.class));

        this.filialService.createFilial(filial);

        Mockito
                .verify(filialMapper, Mockito.times(1))
                .save(Mockito.any(Filial.class));
    }

    @Test
    void shouldCreateFilialException() {

        //#region Cenário
        filial = new Filial();
        filial.setNome("Mateus");
        //#endregion

        Mockito.doThrow(PersistenceException.class)
                .when(filialMapper)
                .save(Mockito.any(Filial.class));

        Assertions.assertThrows(FilialServiceException.class, () -> {
            this.filialService.createFilial(filial);
        });
    }

    @AfterEach
    void tearDown() {
        Mockito.reset(this.filialMapper);
    }
}
