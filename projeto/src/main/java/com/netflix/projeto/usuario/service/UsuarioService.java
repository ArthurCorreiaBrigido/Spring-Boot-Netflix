package com.netflix.projeto.usuario.service;

import com.netflix.projeto.usuario.entity.Usuario;
import com.netflix.projeto.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private static UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();

    }
    public static Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public static void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }
}