package com.netflix.projeto.usuario.controller;

import com.netflix.projeto.security.SecurityScheme;
import com.netflix.projeto.security.SecuritySchemeType;
import com.netflix.projeto.usuario.entity.Usuario;
import com.netflix.projeto.usuario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")



    // Api Rest, consumir ou salvar informação de usuario nesse contexto
// Configurar a URL para fazer isso, para disponibilizar serviço
public class UsuarioController {

        // Quando quero salvar uma informação em uma api rest uso post
        @PostMapping
        // Requesbuddy permite pegar conteudo do corpo na api rest, pega o objeto do cliente
        public Usuario salvar(@RequestBody Usuario usuario) {
            // Validar o usuario
            System.out.println(usuario);

            // Retorna usuario
            return usuario;
        }

        @GetMapping
        public List<Usuario> listar() {
            Usuario u = new Usuario();
            u.setId(1);


            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(u);
            return usuarios;
        }

        @GetMapping("/{id}")
        public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") Integer id) {
            try {
                Usuario usuario = UsuarioService.buscarPorId(id);
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            } catch (NoSuchElementException ex) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        public void excluir(@PathVariable("id") Integer id) {
            UsuarioService.excluir(id);
        }

    }

