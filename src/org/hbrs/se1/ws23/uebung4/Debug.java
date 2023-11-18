package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.solutions.uebung2.ContainerException;

public class Debug {
    public static void main(String[] args) throws ContainerException, Exception {
        try {
            InputDialog dialogIn = new InputDialog();
            dialogIn.eingabe();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong while typing something in");
        }
    }
}
