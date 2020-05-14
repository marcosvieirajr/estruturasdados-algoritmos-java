package br.com.mvj.vetor;

public class Vetor {

    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(String elemento) {

        if (this.tamanho < elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }

        return false;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String toString() {

        StringBuilder retorno = new StringBuilder("[");
        
        for (int i = 0; i < this.tamanho - 1; i++) {
            retorno.append(this.elementos[i]);
            retorno.append(", ");
        }
        
        if (tamanho > 0) {
            retorno.append(this.elementos[tamanho - 1]);
        }
        
        retorno.append("]");
        
        return retorno.toString();
    }

    public String busca(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho()) throw new IllegalArgumentException("Posição inválida");
        return elementos[posicao];
    }
}
