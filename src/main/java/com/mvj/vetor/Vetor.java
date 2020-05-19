package com.mvj.vetor;

public class Vetor<T> {

    private T[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(T elemento) {
        aumentaCapacidade();

        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
        return true;
    }

    public boolean adiciona(int posicao, T elemento) {
        aumentaCapacidade();
        if (posicao < 0 || posicao >= tamanho)
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

    public int busca(T elemento) {
        if (elemento == null) return -1;
        for (int i = 0; i < elementos.length; i++) {
            if (elemento.equals(elementos[i])) return i;
        }
        return -1;
    }

    public boolean contem(T elemento) {
        return busca(elemento) > -1;
    }

    public int ultimoIndiceDe(T elemento) {
        var indice = -1;
        if (elemento == null) return indice;
        for (int i = tamanho -1; i>=0; i--){
            if (elemento.equals(elementos[i])) return i;
        }
        return indice;
    }

    public int tamanho() {
        return this.tamanho;
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

    private void aumentaCapacidade() {
        if (tamanho == elementos.length) {
            var tmp = (T[]) new Object[elementos.length * 2];
            for (int i = 0; i < tamanho; i++) {
                tmp[i] = elementos[i];
            }
            elementos = tmp;
        }
    }
}
