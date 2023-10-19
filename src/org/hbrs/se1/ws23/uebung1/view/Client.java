package org.hbrs.se1.ws23.uebung1.view;

import org.hbrs.se1.ws23.uebung1.control.Translator;
import org.hbrs.se1.ws23.uebung1.control.Factory;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 * (auch bezeichnet als CLI, Terminal)
	 *
	 */
	public void display(int aNumber) {
		// In dieser Methode soll die Methode translateNumber
		// mit dem übergegebenen Wert der Variable aNumber
		// aufgerufen werden.
		Translator gerTranslator = Factory.createGermanTranslator();
		String result = gerTranslator.translateNumber(aNumber);
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		System.out.println(result);

	}
}
