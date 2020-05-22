package com.mvj.estruturadados;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VetorTest {

    //https://assertj.github.io/doc/#assertj-overview

    @Test
    void deveAdicionarElementoNoVetor() {

        var vetor = new Vetor(5);
        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");
        var foiAdicionado = vetor.adiciona("5");

        assertThat(foiAdicionado).isTrue();
    }

    @Test
    void deveRetornarQuantidadeDeElementosDoVetor() {

        var vetor = new Vetor(5);

        assertThat(vetor.tamanho()).isEqualTo(0);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");

        assertThat(vetor.tamanho()).isEqualTo(3);

        vetor.adiciona("4");
        vetor.adiciona("5");
        vetor.adiciona("6");
        vetor.adiciona("7");

        assertThat(vetor.tamanho()).isEqualTo(7);
    }

    @Test
    public void deveRetornarToStringDoVetor() {

        var vetor = new Vetor(5);

        assertThat(vetor.toString()).isEqualTo("[]");

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");

        assertThat(vetor.toString()).isEqualTo("[1, 2, 3]");

        vetor.adiciona("4");
        vetor.adiciona("5");
        vetor.adiciona("6");
        vetor.adiciona("7");

        assertThat(vetor.toString()).isEqualTo("[1, 2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void deveRetornarPosicaoDeUmElementoNoVetor() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");
        vetor.adiciona("5");

        assertThat(vetor.busca("3")).isEqualTo(2);
        assertThat(vetor.busca("0")).isEqualTo(-1);

    }

    @Test
    public void deveAdicionarElementoEmUmaPosicaoDoVetor() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

        vetor.adiciona(0, "0");

        assertThat(vetor.busca("0")).isEqualTo(0);
        assertThat(vetor.busca("4")).isEqualTo(4);

        vetor.adiciona(2, "9");

        assertThat(vetor.busca("0")).isEqualTo(0);
        assertThat(vetor.busca("9")).isEqualTo(2);
        assertThat(vetor.busca("3")).isEqualTo(4);
        assertThat(vetor.tamanho()).isEqualTo(6);
    }

    @Test
    public void deveRetornarExceptionSeAdicionarEmIndiceMenorQueZero() {

        var vetor = new Vetor(5);
        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

//        assertThatThrownBy(() -> {
//            vetor.adiciona(-1, "0");
//        }).isInstanceOf(IllegalArgumentException.class)
//            .hasMessage("Posição inválida");

//        assertThatExceptionOfType(IllegalArgumentException.class)
//            .isThrownBy(() -> {
//                vetor.adiciona(-1, "0");
//            }).withMessage("Posição inválida");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            vetor.adiciona(-1, "0");
        }).withMessage("Posição inválida");
    }

    @Test
    public void deveRetornarExceptionSeAdicionarEmIndiceMaiorQueTamanho() {

        var vetor = new Vetor(5);
        vetor.adiciona(0, "0");
        vetor.adiciona(1, "1");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            vetor.adiciona(10, "2");
        }).withMessage("Posição inválida");
    }

    @Test
    public void deveRemoverElementoEmUmaPosicaoDoVetor() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

        vetor.remove(0);

        assertThat(vetor.busca("1")).isEqualTo(-1);
        assertThat(vetor.busca("2")).isEqualTo(0);
        assertThat(vetor.tamanho()).isEqualTo(3);
    }

    @Test
    public void deveRetornarExceptionSeRemoverEmIndiceMenorQueZero() {

        var vetor = new Vetor(5);
        vetor.adiciona("1");
        vetor.adiciona("2");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            vetor.remove(-1);
        }).withMessage("Posição inválida");
    }

    @Test
    public void deveRemoverElemento() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

        vetor.remove("1");

        assertThat(vetor.busca("1")).isEqualTo(-1);
        assertThat(vetor.busca("2")).isEqualTo(0);
        assertThat(vetor.tamanho()).isEqualTo(3);
    }

    @Test
    public void deveRetornarTrueCasaContenhaElemanto() {

        var vetor = new Vetor<String>(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

        assertThat(vetor.contem("1")).isTrue();
        assertThat(vetor.contem("0")).isFalse();
    }

    @Test
    public void deveRetornarIndiceDoUltimoElemanto() {

        var vetor = new Vetor<String>(5);

        vetor.adiciona("0");
        vetor.adiciona("2");
        vetor.adiciona("0");
        vetor.adiciona("4");

        assertThat(vetor.ultimoIndiceDe("0")).isEqualTo(2);
        assertThat(vetor.ultimoIndiceDe("2")).isEqualTo(1);
        assertThat(vetor.ultimoIndiceDe("5")).isEqualTo(-1);
        assertThat(vetor.ultimoIndiceDe(null)).isEqualTo(-1);
    }

    @Test
    public void deveLimparVetor() {
        var vetor = new Vetor<String>();

        vetor.adiciona("0");
        vetor.adiciona("2");
        vetor.adiciona("0");
        vetor.adiciona("4");

        vetor.limpar();

        assertThat(vetor.contem("4")).isFalse();
        assertThat(vetor.tamanho()).isEqualTo(0);
    }

}
