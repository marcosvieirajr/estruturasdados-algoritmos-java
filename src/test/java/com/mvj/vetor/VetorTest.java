package com.mvj.vetor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VetorTest {

    @Test
    void deveAdicionarElementoNoVetor() {

        var vetor = new Vetor(5);
        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");
        var foiAdicionado = vetor.adiciona("5");

        assertTrue(foiAdicionado);
    }

    @Test
    void deveRetornarQuantidadeDeElementosDoVetor() {

        var vetor = new Vetor(5);

        assertEquals(0, vetor.tamanho());

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");

        assertEquals(3, vetor.tamanho());

        vetor.adiciona("4");
        vetor.adiciona("5");
        vetor.adiciona("6");
        vetor.adiciona("7");

        assertEquals(7, vetor.tamanho());
    }

    @Test
    public void deveRetornarToStringDoVetor() {

        var vetor = new Vetor(5);

        assertEquals("[]", vetor.toString());

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");

        assertEquals("[1, 2, 3]", vetor.toString());

        vetor.adiciona("4");
        vetor.adiciona("5");
        vetor.adiciona("6");
        vetor.adiciona("7");

        assertEquals("[1, 2, 3, 4, 5, 6, 7]", vetor.toString());
    }

    @Test
    public void deveRetornarPosicaoDeUmElementoNoVetor() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");
        vetor.adiciona("5");

        assertEquals(2, vetor.busca("3"));
        assertEquals(-1, vetor.busca("0"));

    }

    @Test
    public void deveAdicionarElementoEmUmaPosicaoDoVetor() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

        vetor.adiciona(0, "0");

        assertEquals(0, vetor.busca("0"));
        assertEquals(4, vetor.busca("4"));

        vetor.adiciona(2, "9");

        assertEquals(0, vetor.busca("0"));
        assertEquals(2, vetor.busca("9"));
        assertEquals(4, vetor.busca("3"));
        assertEquals(6, vetor.tamanho());
    }

    @Test
    public void deveRetornarExceptionSeAdicionarEmIndiceMenorQueZero() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {

            var vetor = new Vetor(5);
            vetor.adiciona("1");
            vetor.adiciona("2");
            vetor.adiciona("3");
            vetor.adiciona("4");
            assertFalse(vetor.adiciona(-1, "0"));
        });
        assertEquals("Posição inválida", ex.getMessage());
    }

    @Test
    public void deveRetornarExceptionSeAdicionarEmIndiceMaiorQueTamanho() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {

            var vetor = new Vetor(5);
            vetor.adiciona("1");
            vetor.adiciona("2");
            vetor.adiciona("3");
            vetor.adiciona("4");
            vetor.adiciona(10, "0");
        });
        assertEquals("Posição inválida", ex.getMessage());
    }

    @Test
    public void deveRemoverElementoEmUmaPosicaoDoVetor() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

        vetor.remove(0);

        assertEquals(-1, vetor.busca("1"));
        assertEquals(0, vetor.busca("2"));
        assertEquals(3, vetor.tamanho());
    }

    @Test
    public void deveRetornarExceptionSeRemoverEmIndiceMenorQueZero() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            vetor.remove(-1);
        });
        assertEquals("Posição inválida", ex.getMessage());
    }

    @Test
    public void deveRemoverElemento() {

        var vetor = new Vetor(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

        vetor.remove("1");

        assertEquals(-1, vetor.busca("1"));
        assertEquals(0, vetor.busca("2"));
        assertEquals(3, vetor.tamanho());
    }

    @Test
    public void deveRetornarTrueCasaContenhaElemanto() {

        var vetor = new Vetor<String>(5);

        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");

        assertTrue(vetor.contem("1"));
        assertFalse(vetor.contem("0"));
    }

    @Test
    public void deveRetornarIndiceDoUltimoElemanto() {

        var vetor = new Vetor<String>(5);

        vetor.adiciona("0");
        vetor.adiciona("2");
        vetor.adiciona("0");
        vetor.adiciona("4");

        assertEquals(2, vetor.ultimoIndiceDe("0"));
        assertEquals(1, vetor.ultimoIndiceDe("2"));
        assertEquals(-1, vetor.ultimoIndiceDe("5"));
        assertEquals(-1, vetor.ultimoIndiceDe(null));
    }

    @Test
    public void deveLimparVetor(){
        var vetor = new Vetor<String>(5);

        vetor.adiciona("0");
        vetor.adiciona("2");
        vetor.adiciona("0");
        vetor.adiciona("4");

        vetor.limpar();

        assertFalse(vetor.contem("4"));
        assertEquals(0, vetor.tamanho());
    }

}
