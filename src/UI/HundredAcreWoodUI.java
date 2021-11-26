package UI;
import java.util.*;
import interfaces.*;
import heroes.*;
import woods.*;

public class HundredAcreWoodUI {
    boolean programCompleted;
    HundredAcreWood hundredAcreWood;

    public HundredAcreWoodUI(HundredAcreWood hundredAcreWood) {
        this.hundredAcreWood = hundredAcreWood;
        programCompleted = false;
    }

    public void start() {
        System.out.println("Welcome to the Hundred Ace Wood!");
        actions();
    }

    public void actions() {
        System.out.println("Here is the list what I can do:");
        int varInt = 2;
        while (true){
            System.out.println("1. Get more info");
            System.out.println("2. Add hero");
            System.out.println("3. Remove hero");
            System.out.println("4. Show heroes");
            System.out.println("5. Exit");
            System.out.print("Enter a number: ");
//            new Scanner(System.in).reset();
            int input = new Scanner(System.in).nextInt();
            if (!doAction(input)) {
                break;
            }
        }
    }

    public boolean doAction(int input) {
        switch(input) {
            case 1:
                String info = null;
                try {
                    info = hundredAcreWood.getMoreInformation();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                System.out.println(info);
                System.out.println();
                return true;
            case 2:
                addHero();
                System.out.println();
                return true;
            case 3:
                deleteHeroes();
                System.out.println();
                return true;
            case 4:
                showHeroes();
                return true;
            case 5:
                programCompleted = true;
                return false;
            default:
                System.out.println("Wrong input");
                return true;
        }
    }

    private void showHeroes() {
        if (hundredAcreWood.getHeroes().size() == 0) {
            System.out.println("There are no heroes in the wood");
            return;
        }
        for (int i = 1; i <= hundredAcreWood.getHeroes().size(); i++){
            System.out.println(i + " " + hundredAcreWood.getHeroes().get(i - 1).toString());
        }
        int choose = 0;
        choose = new Scanner(System.in).nextInt();
        if (choose > hundredAcreWood.getHeroes().size() || choose < 0){
            System.out.println("Incorrect index");
            return;
        }
        if (choose == 0){
            return;
        }
        CreateHeroUI(hundredAcreWood.getHeroes().get(choose - 1));
    }

    private void CreateHeroUI(Hero hero) {
        switch (hero.getName()){
            case "Winnie-the-Pooh":
                PoohUI poohUI = new PoohUI((Pooh)hero);
                poohUI.start();
                break;
            case "Piglet":
                PigletUI pigletUI = new PigletUI((Piglet)hero, hundredAcreWood);
                pigletUI.start();
                break;
            case "Kanga":
                KangaUI kangaUI = new KangaUI((Kanga)hero);
                kangaUI.start();
                break;
            case "Tigger":
                TiggerUI tiggerUI = new TiggerUI((Tigger)hero);
                tiggerUI.start();
                break;
        }
    }

    public boolean checkYesNoInput(String input) {
        while(!(input.equals("yes") || input.equals("no"))) {
            System.out.print("Wrong input, please, write yes\no: ");
            input = new Scanner(System.in).nextLine().toLowerCase();
        }
        return true;
    }

    public void addHero() {
        System.out.println("What heroes do you want to add?");
        System.out.println("1. Pooh");
        System.out.println("2. Piglet");
        System.out.println("3. Kanga");
        System.out.println("4. Tigger");
        System.out.print("Enter the number: ");
        int input = new Scanner(System.in).nextInt();
        switch (input) {
            case 1:
                try {
                    hundredAcreWood.addPooh();
                    System.out.println("Hero added");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
            case 2:
                try {
                    hundredAcreWood.addPiglet();
                    System.out.println("Hero added");
                } catch (Throwable e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
            case 3:
                try {
                    hundredAcreWood.addKanga();
                    System.out.println("Hero added");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
            case 4:
                try {
                    hundredAcreWood.addTigger();
                    System.out.println("Hero added");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
        }
    }

    public void deleteHeroes() {
        System.out.println("What hero do you want to delete?");
        System.out.println("1. Pooh");
        System.out.println("2. Piglet");
        System.out.println("3. Kanga");
        System.out.println("4. Tigger");
        System.out.print("Enter the number: ");
        int input = new Scanner(System.in).nextInt();
        boolean contains = false;
        boolean succeed = false;
        switch(input) {
            case 1:
                try {
                    hundredAcreWood.removeHero("Winnie-the-Pooh");
                    System.out.println("Hero was deleted");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
            case 2:
                try {
                    hundredAcreWood.removeHero("Piglet");
                    System.out.println("Hero was deleted");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
            case 3:
                try {
                    hundredAcreWood.removeHero("Kanga");
                    System.out.println("Hero was deleted");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
            case 4:
                try {
                    hundredAcreWood.removeHero("Tigger");
                    System.out.println("Hero was deleted");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
        }
    }

    public boolean programIsCompleted() {
        return programCompleted;
    }
}
