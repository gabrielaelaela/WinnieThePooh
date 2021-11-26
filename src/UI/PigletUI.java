package UI;
import java.util.*;
import heroes.*;
import interfaces.*;
import enums.*;
import abstractClasses.*;

public class PigletUI extends HeroUI {
    Piglet piglet;
    Scanner scan;
    ArrayList<String> actions;

    public PigletUI(Piglet hero, Wood wood) {
        piglet = hero;
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Hey, I am Piglet! I love acorns and helping my friends! Do you want to be my friend? Enter yes/no: ");
        String input = scan.nextLine().toLowerCase();
        checkYesNoInput(input);

        if (input.equals("yes")) {
            piglet.setEmotion(Emotion.PLEASED);
        } else if (input.equals("no")) {
            piglet.setEmotion(Emotion.UPSET);
        }

        piglet.getEmotionalResult();
        System.out.println("Here is the list what I can do:");
        System.out.println("1. Describe myself");
        System.out.println("2. Jump");
        System.out.println("3. Cry");
        System.out.println("4. Wipe paws");
        System.out.println("5. Go somewhere");
        System.out.println("6. Go home");
        int index = 0;
        index = scan.nextInt();
        doAction(index);
    }

    private void doAction(int i) {
        switch(i) {
            case 1:
                piglet.getDescription();
                break;
            case 2:
                System.out.println(piglet.jump());
                break;
            case 3:
                System.out.println(piglet.cry());
                break;
            case 4:
                System.out.println(piglet.wipe(piglet.getPaws(), piglet.getBelly()));
                break;
            case 5:
                go();
                break;
            case 6:
                piglet.goHome();
                break;
        }
    }

    private void go() {
        Walkable friend = null;
        Location l = null;
        if (piglet.numberOfFriends() != 0) {
            System.out.print("Do you want to invite a friend? Enter yes/no: ");
            String input = scan.nextLine().toLowerCase();
            checkYesNoInput(input);
            if (input.equals("yes")) {
                if (piglet.numberOfFriends() > 0) {
                    try {
                        friend = piglet.getFriendByName(chooseAFriend());
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
            poohLocation = piglet.getLocation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scan.nextLine();
        }
        if (l.equals(poohLocation)) {
            System.out.print("Piglet is already here. Do you want to go somewhere else? Enter yes/no: ");
            String inputLine = new Scanner(System.in).nextLine();
            checkYesNoInput(inputLine);
            if (inputLine.equals("yes")) {
                go();
            }
        } else {
            if (friend != null) {
                try {
                    piglet.goToWith(friend, l);
                    System.out.println(piglet.speak("Let's go " + l.toString()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scan.nextLine();
                }
            } else {
                try {
                    piglet.goTo(l);
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
            default:
                return null;
        }
    }
}
