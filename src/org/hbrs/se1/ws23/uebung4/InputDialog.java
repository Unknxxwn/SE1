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
        // Switch cases zur Verarbeitung der eingabe von befehlen

        switch (strings[0]) {
            case "enter":

                break;
            case "store":
                break;
            case "load":
                break;
            case "dump":
                break;
            case "search":
                break;
            case "exit":
                break;
            case "help":
                System.out.println();
                break;
            default:
                System.out.println("command incorrect if you need help type: help to see a list of commands");
                break;
        }
        scanner.close();
    }
}