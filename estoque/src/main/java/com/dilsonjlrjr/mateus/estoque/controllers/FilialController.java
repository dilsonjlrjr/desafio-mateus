package com.dilsonjlrjr.mateus.estoque.controllers;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.FilialServiceException;
import com.dilsonjlrjr.mateus.estoque.model.Filial;
import com.dilsonjlrjr.mateus.estoque.model.dto.FilialDTO;
import com.dilsonjlrjr.mateus.estoque.services.FilialService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = { "/api/filial" })
@Log4j2
public class FilialController {

    @Autowired
    FilialService filialService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @Transactional(rollbackFor = FilialServiceException.class)
    @SneakyThrows(FilialServiceException.class)
    public ResponseEntity<HttpStatus> created(@Valid @RequestBody FilialDTO filialDTO) {
        Filial filial = this.modelMapper.map(filialDTO, Filial.class);
        filialService.createFilial(filial);

        return new ResponseEntity<>(HttpStatus.CREATED, HttpStatus.CREATED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleExceptionConstraintDTO(MethodArgumentNotValidException e) {
        log.error(e.getMessage(),e);

        Map<String, String> erros = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach(field -> erros.put(field.getCode(), field.getDefaultMessage()));
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FilialServiceException.class)
    public ResponseEntity<Map<String, String>> handleFilialServiceException(FilialServiceException e) {
        log.error(e.getMessage(), e);

        Map<String,String> mapError = new HashMap<>();
        mapError.put("error", e.getMessage());
        return new ResponseEntity<Map<String,String>>(mapError, HttpStatus.BAD_REQUEST);
    }
}
