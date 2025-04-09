package com.example.nba.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{time.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{time.cidade.obrigatorio}")
    private String cidade;

    // Construtores, getters e setters

    public Time() { }

    public Time(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
