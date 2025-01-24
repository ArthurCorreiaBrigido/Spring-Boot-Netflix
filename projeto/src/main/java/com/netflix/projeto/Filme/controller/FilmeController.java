package com.netflix.projeto.Filme.controller;

import com.netflix.projeto.Filme.entity.Filme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
// Api Rest, consumir ou salvar informação de usuario nesse contexto
// Configurar a URL para fazer isso, para disponibilizar serviço
public class FilmeController {

    // Quando quero salvar uma informação em uma api rest uso post
    @PostMapping
    // Requesbuddy permite pegar conteudo do corpo na api rest, pega o objeto do cliente
    public Filme salvar(@RequestBody Filme filme) {
        // Validar o usuario
        System.out.println(filme);

        // Retorna usuario
        return filme;
    }

    @GetMapping
    public List<Filme> listar() {
        Filme f = new Filme();
        f.setId(1);

        List<Filme> filmes = new ArrayList<>();
        filmes.add(f);
        return filmes;
    }

}
