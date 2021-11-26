package UI;
import java.util.*;
import heroes.*;
import interfaces.*;
import enums.*;
import abstractClasses.*;

public class KangaUI extends HeroUI {
    Kanga kanga;
    ArrayList<String> actions;

    public KangaUI(Kanga h) {
        kanga = h;
    }

    public void start() {
        System.out.println("Hi, I am Kanga, and I have an adorable son Roo!");
        System.out.println("Here is the list what I can do:");
        System.out.println("1. Describe myself");
        System.out.println("2. Help Piglet");
        int index = 0;
        index = new Scanner(System.in).nextInt();
        doAction(index);
    }

    private void doAction(int i) {
        switch(i) {
            case 1:
                String s = null;
                try {
                    s = kanga.getDescription();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                System.out.println(s);
                break;
            case 2:
                try {
                    kanga.help("Piglet");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    new Scanner(System.in).nextLine();
                }
                break;
        }
    }
}
