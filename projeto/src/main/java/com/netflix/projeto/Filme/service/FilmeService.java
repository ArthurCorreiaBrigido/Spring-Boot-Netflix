package com.netflix.projeto.Filme.service;

import com.netflix.projeto.Filme.entity.Filme;
import com.netflix.projeto.Filme.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void salvar(Filme filme) {
        filmeRepository.save(filme);
    }

    public List<Filme> listar() {
        return filmeRepository.findAll();
    }

}
