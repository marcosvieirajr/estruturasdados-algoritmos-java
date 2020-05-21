package com.mvj.estruturadados;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PilhaTest {

    @Test
    void deveEmpilharElemento() {
        var pihla = new Pilha<String>();
        pihla.empilha("0");
        pihla.empilha("1");
        pihla.empilha("2");

        assertEquals(3, pihla.tamanho());
        assertEquals("[0, 1, 2]", pihla.toString());
    }

    @Test
    void deveRetornarElementoTopo() {
        var pihla = new Pilha<String>();

        assertEquals(null, pihla.topo());

        pihla.empilha("0");
        pihla.empilha("1");
        pihla.empilha("2");

        assertEquals("2", pihla.topo());
    }

    @Test
    void deveDesempilharElementoTopo() {
        var pihla = new Pilha<String>(5);

        assertEquals(null, pihla.desempilha());

        pihla.empilha("0");
        pihla.empilha("1");
        pihla.empilha("2");

        var desempilhado = pihla.desempilha();

        assertEquals("2", desempilhado);
        assertEquals(2, pihla.tamanho());
    }
}
