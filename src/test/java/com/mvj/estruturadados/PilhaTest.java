package com.mvj.estruturadados;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PilhaTest {

    @Test
    void deveEmpilharElemento() {
        var pihla = new Pilha<String>();
        pihla.empilha("0");
        pihla.empilha("1");
        pihla.empilha("2");

        assertThat( pihla.tamanho()).isEqualTo(3);
        assertThat( pihla.toString()).isEqualTo("[0, 1, 2]");
    }

    @Test
    void deveRetornarElementoTopo() {
        var pihla = new Pilha<String>();

        assertThat( pihla.topo()).isEqualTo(null);

        pihla.empilha("0");
        pihla.empilha("1");
        pihla.empilha("2");

        assertThat( pihla.topo()).isEqualTo("2");
    }

    @Test
    void deveDesempilharElementoTopo() {
        var pihla = new Pilha<String>(5);

        assertThat( pihla.desempilha()).isEqualTo(null);

        pihla.empilha("0");
        pihla.empilha("1");
        pihla.empilha("2");

        var desempilhado = pihla.desempilha();

        assertThat( desempilhado).isEqualTo("2");
        assertThat( pihla.tamanho()).isEqualTo(2);
    }
}
