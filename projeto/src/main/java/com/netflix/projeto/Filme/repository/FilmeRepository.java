package com.netflix.projeto.Filme.repository;

import com.netflix.projeto.Filme.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme,Integer> {
}
