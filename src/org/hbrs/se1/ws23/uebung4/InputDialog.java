package org.hbrs.se1.ws23.uebung4;

import java.util.Scanner;

import org.hbrs.se1.ws23.solutions.uebung2.ContainerException;

/**
 * InputDialog
 */
public class InputDialog {
    // Container Objekt
    Container container = Container.getInstance();
    String input = null;
    Scanner scanner = new Scanner(System.in);

    public void eingabe() throws ContainerException, Exception {
        input = scanner.nextLine();
        // Eingabe zu Array mit ignorierung von Leerzeichen
        String[] strings = input.split(" ");
        // Start des Programmes
        System.out.println("UserStory-Tool");
        System.out.print("> ");
        // eigentlicher loop für die Eingabe in der Konsole
        while (scanner.hasNext()) {

        }
    }
}