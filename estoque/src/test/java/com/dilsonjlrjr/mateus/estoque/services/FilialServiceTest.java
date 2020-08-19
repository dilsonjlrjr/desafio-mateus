package com.dilsonjlrjr.mateus.estoque.services;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.FilialServiceException;
import com.dilsonjlrjr.mateus.estoque.mapper.FilialMapper;
import com.dilsonjlrjr.mateus.estoque.model.Filial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class FilialServiceTest {

    @Autowired
    @MockBean
    FilialService filialService;

    @MockBean
    FilialMapper filialMapper;

    Filial filial;

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
                .verify(filialService, Mockito.times(1))
                .createFilial(Mockito.any(Filial.class));
    }

    @Test
    void shouldCreateFilialException() throws FilialServiceException {

        //#region Cenário
        filial = new Filial();
        filial.setNome("Mateus");
        //#endregion

        Mockito.doThrow(new FilialServiceException("Erro ao salvar uma filial"))
                .when(this.filialService).createFilial(Mockito.any(Filial.class));

        Assertions.assertThrows(FilialServiceException.class, () -> {
            this.filialService.createFilial(filial);
        });
    }
}
