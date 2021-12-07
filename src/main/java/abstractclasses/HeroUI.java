package main.java.abstractclasses;

import java.util.*;

public abstract class HeroUI {
    Scanner scan;
    ArrayList<String> action;

    public boolean checkYesNoInput(String input) {
        while(!(input.equals("yes") || input.equals("no"))) {
            System.out.print("I don't understand you :(, please, write yes\no: ");
            input = scan.nextLine().toLowerCase();
        }
        return true;
    }
}
