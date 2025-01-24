package com.netflix.projeto.usuario.controller;

import com.netflix.projeto.security.model.Autenticacao;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;

import javax.naming.AuthenticationNotSupportedException;
import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class UsuarioFiltroAutenticacaoSenha {
    public abstract GerencAutenticacao autenticacao(HttpServletRequest req,
                                                                HttpServletResponse res) throws AuthenticationException;

    protected abstract void autenticacaoConcedida(HttpServletRequest req,
                                                  HttpServletResponse res,
                                                  FilterChain chain,
                                                  Autenticacao auth) throws IOException;
}
