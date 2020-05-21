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
}
