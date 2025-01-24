package com.netflix.projeto.Filme.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILME")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String faixa_etaria;
    private String categoria;
    private String ano_lancamento;
    private String duracao_minutos;
    private String diretor;
    private String elenco;
    private String descricao;
    private int numero_episodios;
    private String temporadas;


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

    public String getFaixa_etaria() {
        return faixa_etaria;
    }

    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(String ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public String getDuracao_minutos() {
        return duracao_minutos;
    }

    public void setDuracao_minutos(String duracao_minutos) {
        this.duracao_minutos = duracao_minutos;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumero_episodios() {
        return numero_episodios;
    }

    public void setNumero_episodios(int numero_episodios) {
        this.numero_episodios = numero_episodios;
    }

    public String getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(String temporadas) {
        this.temporadas = temporadas;
    }

}
