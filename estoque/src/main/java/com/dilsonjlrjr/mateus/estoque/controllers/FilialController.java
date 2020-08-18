package com.dilsonjlrjr.mateus.estoque.controllers;

import com.dilsonjlrjr.mateus.estoque.model.dto.FilialDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = { "/api/filial" })
@Log4j2
public class FilialController {

    @PostMapping
    public ResponseEntity<FilialDTO> created(@Valid @RequestBody FilialDTO filialDTO) {
        return new ResponseEntity<>(filialDTO, HttpStatus.CREATED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleExceptionConstraintDTO(MethodArgumentNotValidException e) {
        log.error(e.getMessage(),e);

        Map<String, String> erros = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach(field -> erros.put(field.getCode(), field.getDefaultMessage()));
        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }
}
