package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    // mittlerer wert der gültigen zahlen wird verwenden [1-10] also 5
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(5);
        assertEquals(value, "fünf");
    }

    @Test
    // Positive ugültige zahle verwendet 10+1 also 11
    void aNegativeTestwithPositiveInteger() {
        // arrange
        GermanTranslator translator = new GermanTranslator();
        // act
        String value = translator.translateNumber(11);
        // assert
        assertEquals(value, "Übersetzung der Zahl 11 nicht möglich 1.0");
    }

    @Test
    // erste negative zahl aus den ungültigen zahlen [-1 - infinity] also -1
    void aNegativeTestwithNegativeInteger() {
        // arrange
        GermanTranslator translator = new GermanTranslator();
        // act
        String value = translator.translateNumber(-1);
        // assert
        assertEquals(value, "Übersetzung der Zahl -1 nicht möglich 1.0");
    }

    @Test
    // Integer 0 ist eine eigene Äquivalenzklasse
    void aNegativeTestWithInteger0() {
        // arrange
        GermanTranslator translator = new GermanTranslator();
        // act
        String value = translator.translateNumber(0);
        // assert
        assertEquals(value, "Übersetzung der Zahl 0 nicht möglich 1.0");

    }
}