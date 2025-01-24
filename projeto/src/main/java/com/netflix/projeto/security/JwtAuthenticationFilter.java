package com.netflix.projeto.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.projeto.security.model.Autenticacao;
import com.netflix.projeto.usuario.controller.GerencAutenticacao;
import com.netflix.projeto.usuario.controller.UsuarioSenhaAutenticacaoToken;
import com.netflix.projeto.usuario.entity.Usuario;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.web.filter.GenericFilterBean;
import com.netflix.projeto.security.component.TokenAuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JwtAuthenticationFilter extends GenericFilterBean {

    private static final int EXPIRATION_TIME = 5000;
    private GerencAutenticacao gerencAutenticacao;

    public JwtAuthenticationFilter(GerencAutenticacao gerencAutenticacao){
        this.gerencAutenticacao = gerencAutenticacao;

        setFilterProcessesUrl("/api/usuario/controller/UsuarioController");

    }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
                throws IOException, ServletException {

            GerencAutenticacao authentication = TokenAuthenticationService
                    .getAuthentication((HttpServletRequest) request);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }



    @Override
    public GerencAutenticacao autenticacao(HttpServletRequest req,
                                           HttpServletResponse res) throws AuthenticationException {
        try{
            Usuario creds = new ObjectMapper().readValue(req.getInputStream(), Usuario.class);

            return  gerencAutenticacao.authenticate(
                    new UsuarioSenhaAutenticacaoToken(
                            creds.getLogin(),
                            creds.getSenha(),
                            new ArrayList<>())
                    );

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected  void autenticacaoConcedida(HttpServletRequest req,
                                          HttpServletResponse res,
                                          FilterChain chain,
                                          Autenticacao auth) throws IOException{
        String token = OAuth2ResourceServerProperties.Jwt.create().withSubject(((Usuario) auth.getPrincipal()).getLogin())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));

        String body = ((Usuario) auth.getPrincipal()).getUsuario() + " " + token;

        res.getWriter().write(body);
        res.getWriter().flush();
    }
}
