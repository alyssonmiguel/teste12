package com.example.turismo.Modelos;

public class Lugares {

    private String nome;
    private String distancia;
    private String descricao;
    private Integer image;

    public Lugares(String nome, String distancia, String descricao, int image) {
        this.nome = nome;
        this.distancia = distancia;
        this.descricao = descricao;
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getImage(){return image;}

    public void setImagem(Integer image) {this.image=image;}
}
