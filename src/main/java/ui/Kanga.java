package main.java.ui;
import java.util.*;

import main.java.abstractclasses.*;

public class Kanga extends HeroUI {
    main.java.heroes.Kanga kanga;

    public Kanga(main.java.heroes.Kanga h) {
        kanga = h;
    }

    public void start() {
        System.out.println("Hi, I am Kanga, and I have an adorable son Roo!");
        System.out.println("Here is the list what I can do:");
        System.out.println("1. Describe myself");
        System.out.println("2. Help Piglet");
        int index;
        index = new Scanner(System.in).nextInt();
        doAction(index);
    }

    private void doAction(int i) {
        switch(i) {
            case 1:
                String s = null;
                try {
                    s = kanga.getDescription();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                System.out.println(s);
                break;
            case 2:
                try {
                    kanga.help("Piglet");
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
        }
    }
}
