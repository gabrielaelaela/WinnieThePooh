package main.java.ui;
import java.util.*;

import main.java.interfaces.*;
import main.java.enums.*;
import main.java.abstractclasses.*;

public class Pooh extends HeroUI {
    main.java.heroes.Pooh pooh;

    public Pooh(main.java.heroes.Pooh h) {
        pooh = h;
    }

    public void start() {
        System.out.println("Hi, I am Edward Winnie-the-Pooh, and I love honey more than anything else! Nice to meet you!");
        System.out.println("Here is the list what I can do:");
        System.out.println("1. Describe myself");
        System.out.println("2. Go somewhere");
        System.out.println("3. Go home");
        int index;
        index = new Scanner(System.in).nextInt();
        doAction(index);
    }

    private void doAction(int i) {
        switch(i) {
            case 1:
                String s = "";
                try {
                    s = pooh.getDescription();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                System.out.println(s);
                break;
            case 2:
                go();
                break;
            case 3:
                try {
                    System.out.println(pooh.goHome());
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
        }
    }

    private void go() {
        Walkable friend = null;
        Location l = null;
        int numberOfFriends = 0;
        try {
            numberOfFriends = pooh.numberOfFriends();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            new Scanner(System.in).nextLine();
        }
        if (numberOfFriends != 0) {
            System.out.print("Do you want to invite a friend? Enter yes/no: ");
            String input = new Scanner(System.in).nextLine().toLowerCase();
            checkYesNoInput(input);
            if (input.equals("yes")) {
                if (numberOfFriends > 0) {
                    try {
                        friend = pooh.getFriendByName(chooseAFriend());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        new Scanner(System.in).nextLine();
                    }
                }
            }
        }
        System.out.println("Where do you want to go?");
        System.out.println(Location.possibleLocations());

        int input = new Scanner(System.in).nextInt();

        switch(input) {
            case 1 :
                l = Location.OUTSIDE;
                break;

            case 2 :
                l = Location.POOHHOME;
                break;

            case 3 :
                l = Location.PIGLETHOME;
                break;

            case 4 :
                l = Location.KANGAHOME;
                break;

            case 5 :
                l = Location.TIGGERHOME;
                break;
        }

        Location poohLocation = null;
        try {
            poohLocation = pooh.getLocation();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            new Scanner(System.in).nextLine();
        }
        if (l.equals(poohLocation)) {
            System.out.print("Pooh is already here. Do you want to go somewhere else? Enter yes/no: ");
            String inputLine = new Scanner(System.in).nextLine();
            checkYesNoInput(inputLine);
            if (inputLine.equals("yes")) {
                go();
            }
        } else {
            if (friend != null) {
                try {
                    pooh.goToWith(friend, l);
                    System.out.println(pooh.speak("Let's go " + l));
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
            } else {
                try {
                    pooh.goTo(l);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
            }
        }
    }

    private String chooseAFriend() {
        System.out.println("Who do you want to invite with you?");
        int i = 0;
        System.out.println(++i + ". " + "Piglet");
        System.out.println(++i + ". " + "Kanga");
        System.out.println(++i + ". " + "Tigger");

        int input = new Scanner(System.in).nextInt();

        switch(input) {
            case 1:
                return "Piglet";

            case 2:
                return "Kanga";

            case 3:
                return "Tigger";
        }
        return null;
    }
}
