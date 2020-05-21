package com.mvj.estruturadados;

import com.mvj.estruturadados.base.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T> {

    public Pilha() {
        super(10);
    }

    public Pilha(int capacidade) {
        super(capacidade);
    }

    public void empilha(T elemento) {
        adiciona(elemento);
    }

    public T topo() {
        if (estaVazia()) return null;
        return elementos[tamanho -1];
    }

    public T desempilha () {
        if (estaVazia()) return null;
        return elementos[--tamanho];
    }
}
