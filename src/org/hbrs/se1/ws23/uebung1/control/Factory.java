package org.hbrs.se1.ws23.uebung1.control;

public class Factory {
    /**
     * Anwendung des Factory Method Patter (Design Pattern)
     * GoF-> Gang of Four Design Patters
     * Problem: Inkonsistente Erzeugerung und Parameterisierung von Objekten
     * Lösung : Service-Klasse zur zentralen und konsistenten Erzeugung von Objekten
     */

    public static Translator createGermanTranslator() {
        GermanTranslator germanTranslateObject = new GermanTranslator();
        // alternativ
        // return new GermanTranslator
        return germanTranslateObject;
    }
}
