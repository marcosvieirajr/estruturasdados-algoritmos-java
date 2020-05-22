package com.mvj.estruturadados;

import com.mvj.estruturadados.base.EstruturaEstatica;

import java.util.Objects;

public class Vetor<T> extends EstruturaEstatica<T> {

    public Vetor() {
        super(10);
    }

    public Vetor(int capacidade) {
        super(capacidade);
    }

    public boolean adiciona(int posicao, T elemento) {
        aumentaCapacidade();
        if (posicao < 0 || posicao > elementos.length)
            throw new IllegalArgumentException("Posição inválida");

        for (int i = tamanho() - 1; i >= posicao; i--) {
            elementos[i + 1] = elementos[i];
        }
        elementos[posicao] = elemento;
        tamanho++;
        return true;
    }

    public boolean remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho)
            throw new IllegalArgumentException("Posição inválida");

        for (int i = posicao; i < tamanho -1; i++) {
            elementos[i] = elementos[i +1];
        }
        tamanho--;
        return true;
    }

    public boolean remove(T elemento) {
        if (elemento == null) return false;
        return remove(busca(elemento));
    }

    public boolean contem(T elemento) {
        return busca(elemento) > -1;
    }

    public int busca(T elemento) {
        if (elemento == null) return -1;
        for (int i = 0; i < elementos.length; i++) {
            if (elemento.equals(elementos[i])) return i;
        }
        return -1;
    }

    public int ultimoIndiceDe(T elemento) {
        var indice = -1;
        if (elemento == null) return indice;
        for (int i = tamanho -1; i>=0; i--){
            if (elemento.equals(elementos[i])) return i;
        }
        return indice;
    }

}
