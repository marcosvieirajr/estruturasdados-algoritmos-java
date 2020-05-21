package com.mvj.estruturadados.base;

import java.util.Objects;

public class EstruturaEstatica<T> {

    protected T[] elementos;
    protected int tamanho;

    public EstruturaEstatica(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(T elemento) {
        aumentaCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
        return true;
    }

    protected void aumentaCapacidade() {
        if (tamanho == elementos.length) {
            var tmp = (T[]) new Object[elementos.length * 2];
            for (int i = 0; i < tamanho; i++) {
                tmp[i] = elementos[i];
            }
            elementos = tmp;
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void limpar() {
        elementos = (T[]) new Objects[this.elementos.length];
        tamanho = 0;
    }

    public String toString() {

        StringBuilder retorno = new StringBuilder("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            retorno.append(this.elementos[i].toString());
            retorno.append(", ");
        }

        if (tamanho > 0) {
            retorno.append(this.elementos[tamanho - 1]);
        }

        retorno.append("]");

        return retorno.toString();
    }
}
