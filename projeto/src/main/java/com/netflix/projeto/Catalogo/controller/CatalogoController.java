package com.netflix.projeto.Catalogo.controller;

import com.netflix.projeto.Catalogo.entity.Catalogo;
import com.netflix.projeto.Catalogo.repository.CatalogoRepository;
import com.netflix.projeto.Catalogo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/catalogo")
// Api Rest, consumir ou salvar informação de usuario nesse contexto
// Configurar a URL para fazer isso, para disponibilizar serviço
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;
    // Quando quero salvar uma informação em uma api rest uso post
    @PostMapping("/salvar")
    // Requesbuddy permite pegar conteudo do corpo na api rest, pega o objeto do cliente
    public void salvar(@RequestBody Catalogo catalogo) {
      catalogoService.salvar(catalogo);
    }



    @GetMapping("/listar")
    public List<Catalogo> listar() {
        return catalogoService.listar();
    }

}
