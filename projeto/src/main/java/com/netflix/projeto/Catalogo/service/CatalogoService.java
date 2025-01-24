package com.netflix.projeto.Catalogo.service;

import com.netflix.projeto.Catalogo.entity.Catalogo;
import com.netflix.projeto.Catalogo.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    public void salvar(Catalogo catalogo) {
        catalogoRepository.save(catalogo);
    }

    public List<Catalogo> listar() {
        return catalogoRepository.findAll();
    }

}
