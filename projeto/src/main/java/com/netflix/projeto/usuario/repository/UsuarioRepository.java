package com.netflix.projeto.usuario.repository;

import com.netflix.projeto.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findUsername(String username);
}
