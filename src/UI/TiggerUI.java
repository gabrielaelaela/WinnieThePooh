package UI;
import java.util.*;
import heroes.*;
import interfaces.*;
import enums.*;
import abstractClasses.*;

public class TiggerUI extends HeroUI {
    Tigger tigger;
    ArrayList<String> actions;

    public TiggerUI(Tigger h) {
        tigger = h;
    }

    public void start() {
        System.out.println("Hello to everyone! I am Tigger!!! You can recognize me as an energetic character. "
                + "Hope you will have a lot of time to play with me!");
        System.out.println("Here is the list what I can do:");
        System.out.println("1. Describe myself");
        System.out.println("2. Jump");
        int index = 0;
        index = new Scanner(System.in).nextInt();
        doAction(index);
    }

    private void setActions() {
        actions = new ArrayList<String>();
        actions.add("Describe himself");
        actions.add("Jump");
    }

    private void doAction(int i) {
        switch(i) {
            case 1:
                String s = null;
                try {
                    s = tigger.getDescription();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                System.out.println(s);
                break;
            case 2:
                try {
                    System.out.println(tigger.jump());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
        }
    }
}
