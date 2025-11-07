package com.gdm.startdb;

import java.util.Objects;

public class Membros {

    private String nome;
    private String funcao;

    public Membros(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membros)) return false;
        Membros m = (Membros) o;
        return Objects.equals(nome, m.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    
}
