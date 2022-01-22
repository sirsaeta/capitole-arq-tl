package com.capitole.harryarbol.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArbolTest {
    private Arbol arbol = null;
    
    @BeforeEach
    public void setup(){
        arbol = new Arbol(1,"r","b");
    }

    @Test
    void whenIGetArbol(){
        assertEquals(1, arbol.getIndex());
        assertEquals("r", arbol.getBordeIzquierdo());
        assertEquals("b", arbol.getBordeDerecho());
        assertTrue(arbol.aIsColorValid("r"));
        assertTrue(arbol.bIsColorValid("b"));
        assertEquals("" + arbol.getBordeIzquierdo() + " <- " + arbol.getIndex() + " -> " + arbol.getBordeDerecho(), arbol.toString());
    }

    @Test
    void whenIGetArbolWithNoArgs(){
    	var arbol = new Arbol();
    	arbol.setIndex(1);
        assertEquals(1, arbol.getIndex());
        assertEquals("null", arbol.getBordeIzquierdo());
        assertEquals("null", arbol.getBordeDerecho());
        assertFalse(arbol.aIsColorValid("r"));
        assertFalse(arbol.bIsColorValid("r"));
        assertEquals("" + arbol.getBordeIzquierdo() + " <- " + arbol.getIndex() + " -> " + arbol.getBordeDerecho(), arbol.toString());
    }
}
