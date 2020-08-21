package com.dilsonjlrjr.mateus.estoque.services;

import com.dilsonjlrjr.mateus.estoque.exceptions.services.FilialServiceException;
import com.dilsonjlrjr.mateus.estoque.model.Filial;

public interface FilialService {
    public abstract void createFilial(Filial filial) throws FilialServiceException;
}
