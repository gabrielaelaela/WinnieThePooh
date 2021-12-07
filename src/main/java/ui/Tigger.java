package main.java.ui;
import java.util.*;

import main.java.abstractclasses.*;

public class Tigger extends HeroUI {
    main.java.heroes.Tigger tigger;

    public Tigger(main.java.heroes.Tigger h) {
        tigger = h;
    }

    public void start() {
        System.out.println("Hello to everyone! I am Tigger!!! You can recognize me as an energetic character. "
                + "Hope you will have a lot of time to play with me!");
        System.out.println("Here is the list what I can do:");
        System.out.println("1. Describe myself");
        System.out.println("2. Jump");
        int index;
        index = new Scanner(System.in).nextInt();
        doAction(index);
    }

    private void doAction(int i) {
        switch(i) {
            case 1:
                String s = null;
                try {
                    s = tigger.getDescription();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                System.out.println(s);
                break;
            case 2:
                try {
                    System.out.println(tigger.jump());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
        }
    }
}
