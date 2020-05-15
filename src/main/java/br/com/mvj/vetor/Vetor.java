package br.com.mvj.vetor;

public class Vetor {

    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(String elemento) {
        aumentaCapacidade();

        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
        return true;
    }

    public boolean adiciona(int posicao, String elemento) {
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

    public int busca(String string) {
        for (int i = 0; i < elementos.length; i++) {
            if (string != null && string.equals(elementos[i]))
                return i;
        }
        return -1;
    }

    private void aumentaCapacidade() {
        if (tamanho == elementos.length) {
            var tmp = new String[elementos.length * 2];
            for (int i = 0; i < tamanho; i++) {
                tmp[i] = elementos[i];
            }
            elementos = tmp;
        }
    }
}
