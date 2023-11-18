package org.hbrs.se1.ws23.uebung4;

import java.util.List;
import java.util.Scanner;

import org.hbrs.se1.ws23.solutions.uebung2.ContainerException;

/**
 * InputDialog
 */
public class InputDialog {
    // Container Objekt
    Container container = Container.getInstance();

    public void eingabe() throws ContainerException, Exception {
        // start der Eingabe
        Scanner scanner = new Scanner(System.in);
        System.out.println("UserStory-Tool");
        // break condition
        Boolean shouldBreak = false;
        // Switch cases zur Verarbeitung der eingabe von befehlen
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            switch (input) {
                case "enter":
                    System.out.println("project:");
                    String projekt = scanner.nextLine();

                    System.out.println("title");
                    String titel = scanner.nextLine();

                    System.out.println("ID:");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("effort:");
                    Integer aufwand = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("value:");
                    Integer mehrwert = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("penalty:");
                    Integer strafe = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("risk:");
                    Integer risiko = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("epic:");
                    String epic = scanner.nextLine();
                    System.out.println("userStory:");
                    String userStory = scanner.nextLine();

                    UserStory userStoryObject = new UserStory(projekt, titel, userStory, id, aufwand, mehrwert, strafe,
                            risiko, epic);
                    container.addUserStory(userStoryObject);
                    System.out.println("UserStory object has been added successfully");
                    break;
                case "store":
                    container.store();
                    System.out.println("UserStory has been stored successfully");
                    break;
                case "load":
                    container.load();
                    System.out.println("UserStory has been loaded successfully");
                    break;
                case "dump":
                    System.out
                            .println(
                                    "output of the UserStory Objects sorted by priority:");
                    container.dump();
                    break;
                case "search":
                    System.out.println("type the project name to find the related UserStories to it");
                    String project = scanner.nextLine();
                    List<UserStory> userStoryList = container.getUserStories(project);
                    UserStoryView.dump(userStoryList);
                    break;
                case "exit":
                    shouldBreak = true;
                    break;
                case "help":
                    System.out.println("list of commands: enter, store, load, dump, search, exit");
                    break;
                default:
                    System.out.println("command incorrect if you need help type: help to see a list of commands");
                    break;
            }
            if (shouldBreak)
                break;

        }
        scanner.close();
    }
}