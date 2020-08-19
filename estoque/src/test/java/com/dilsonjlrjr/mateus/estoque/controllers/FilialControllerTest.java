package com.dilsonjlrjr.mateus.estoque.controllers;

import com.dilsonjlrjr.mateus.estoque.model.Filial;
import com.dilsonjlrjr.mateus.estoque.model.dto.FilialDTO;
import com.dilsonjlrjr.mateus.estoque.services.FilialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class FilialControllerTest {

    static String API = "/api/filial";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilialService filialService;

    @Captor
    private ArgumentCaptor<Filial> argumentCaptor;

    private MockHttpServletRequestBuilder mountRequestPost(String content) {
        return MockMvcRequestBuilders.post(API)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
    }

    @Test
    void shouldPostFilial() throws Exception {

        //#region Cenário
        FilialDTO filialDTO = new FilialDTO();
        filialDTO.setNome("Mateus");

        Filial filial = new Filial();
        filial.setNome("Mateus");

        String jsonContent = new ObjectMapper().writeValueAsString(filialDTO);
        //#endregion

        MockHttpServletRequestBuilder requestPost = mountRequestPost(jsonContent);

        this.mockMvc.perform(requestPost)
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated());

        BDDMockito
                .verify(this.filialService, BDDMockito.times(1))
                .createFilial(this.argumentCaptor.capture());

        Assertions.assertEquals(filial.getNome(), argumentCaptor.getValue().getNome());
    }

    @Test
    void shouldTestExceptionPostFilial() throws Exception {

        //#region Cenário
        FilialDTO filialDTO = new FilialDTO();
        filialDTO.setId(1);

        String jsonContent = new ObjectMapper().writeValueAsString(filialDTO);
        //#endregion

        MockHttpServletRequestBuilder requestPost = mountRequestPost(jsonContent);

        this.mockMvc.perform(requestPost)
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("NotNull").value("O nome não pode ser nulo."));

        //#region Cenário
        FilialDTO filialDTO2 = new FilialDTO();
        filialDTO2.setId(1);
        filialDTO2.setNome("M");
        jsonContent = new ObjectMapper().writeValueAsString(filialDTO2);
        //#endregion

        requestPost = mountRequestPost(jsonContent);

        this.mockMvc.perform(requestPost)
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("Size").value("O nome deve ter no mínimo 5 e limite máximo de 200 caracteres."));

    }
}
