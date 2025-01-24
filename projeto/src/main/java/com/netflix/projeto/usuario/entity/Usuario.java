package com.netflix.projeto.usuario.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USUARIO")
@DiscriminatorValue("USUARIO")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "NOME", nullable = false, unique = true)
    private String nome;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "SENHA", nullable = false, unique = true)
    private String senha;


    @Email
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
