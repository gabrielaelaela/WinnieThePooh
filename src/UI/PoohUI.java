package UI;
import java.util.*;
import heroes.*;
import interfaces.*;
import enums.*;
import abstractClasses.*;

public class PoohUI extends HeroUI {
    Pooh pooh;
    Scanner scan;
    ArrayList<String> actions;

    public PoohUI(Pooh h) {
        pooh = h;
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Hi, I am Edward Winnie-the-Pooh, and I love honey more than anything else! Nice to meet you!");
        System.out.println("Here is the list what I can do:");
        System.out.println("1. Describe myself");
        System.out.println("2. Go somewhere");
        System.out.println("3. Go home");
        int index = 0;
        index = scan.nextInt();
        doAction(index);
    }

    private void doAction(int i) {
        switch(i) {
            case 1:
                String s = "";
                try {
                    s = pooh.getDescription();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scan.nextLine();
                }
                System.out.println(s);
                break;
            case 2:
                go();
                break;
            case 3:
                try {
                    System.out.println(pooh.goHome());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scan.nextLine();
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scan.nextLine();
        }
        if (numberOfFriends != 0) {
            System.out.print("Do you want to invite a friend? Enter yes/no: ");
            String input = scan.nextLine().toLowerCase();
            checkYesNoInput(input);
            if (input.equals("yes")) {
                if (numberOfFriends > 0) {
                    try {
                        friend = pooh.getFriendByName(chooseAFriend());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        scan.nextLine();
                    }
                }
            }
        }
        System.out.println("Where do you want to go?");
        System.out.println(Location.possibleLocations());

        int input = scan.nextInt();

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scan.nextLine();
        }
        if (l.equals(poohLocation)) {
            System.out.print("Pooh is already here. Do you want to go somewhere else? Enter yes/no: ");
            String inputLine = scan.nextLine();
            checkYesNoInput(inputLine);
            if (inputLine.equals("yes")) {
                go();
            }
        } else {
            if (friend != null) {
                try {
                    pooh.goToWith(friend, l);
                    System.out.println(pooh.speak("Let's go " + l.toString()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scan.nextLine();
                }
            } else {
                try {
                    pooh.goTo(l);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scan.nextLine();
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

        int input = scan.nextInt();

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
