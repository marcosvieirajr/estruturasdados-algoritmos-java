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
        return elementos[tamanho-1];
    }

    public T desempilha () {
        var retorno = topo();
        remove(tamanho -1);
        return retorno;
    }
}
