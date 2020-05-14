package br.com.mvj.vetor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    void naoDeveAdicionarElementoNoVetorChreio() {

        var vetor = new Vetor(5);
        vetor.adiciona("1");
        vetor.adiciona("2");
        vetor.adiciona("3");
        vetor.adiciona("4");
        vetor.adiciona("5");
        var foiAdicionado = vetor.adiciona("6");

        assertFalse(foiAdicionado);
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
        
        assertEquals(5, vetor.tamanho());
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

        assertEquals("[1, 2, 3, 4, 5]", vetor.toString());
    }
}
