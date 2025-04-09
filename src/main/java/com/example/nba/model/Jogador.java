package com.example.nba.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{jogador.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{jogador.posicao.obrigatorio}")
    private String posicao;

    @Min(value = 18, message = "{jogador.idade.minima}")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    // Construtores, getters e setters

    public Jogador() { }

    public Jogador(String nome, String posicao, int idade, Time time) {
        this.nome = nome;
        this.posicao = posicao;
        this.idade = idade;
        this.time = time;
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
    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }
}
