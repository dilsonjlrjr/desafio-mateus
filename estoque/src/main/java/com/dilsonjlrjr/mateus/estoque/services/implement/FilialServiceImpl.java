package com.dilsonjlrjr.mateus.estoque.services.implement;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.FilialServiceException;
import com.dilsonjlrjr.mateus.estoque.mapper.FilialMapper;
import com.dilsonjlrjr.mateus.estoque.model.Filial;
import com.dilsonjlrjr.mateus.estoque.services.FilialService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FilialServiceImpl implements FilialService {

    FilialMapper filialMapper;

    public FilialServiceImpl(FilialMapper filialMapper) {
        this.filialMapper = filialMapper;
    }

    @Override
    public void createFilial(Filial filial) throws FilialServiceException {
        try {
            this.filialMapper.save(filial);
        } catch (PersistenceException e) {
            log.error(e.getStackTrace());
            throw new FilialServiceException("Ocorreu um erro ao salvar uma Filial", e);
        }
    }
}
