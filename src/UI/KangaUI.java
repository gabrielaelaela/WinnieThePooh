package UI;
import java.util.*;
import heroes.*;
import interfaces.*;
import enums.*;
import abstractClasses.*;

public class KangaUI extends HeroUI {
    Kanga kanga;
    Scanner scan;
    ArrayList<String> actions;

    public KangaUI(Kanga h) {
        kanga = h;
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Hi, I am Kanga, and I have an adorable son Roo!");
        System.out.println("Here is the list what I can do:");
        System.out.println("1. Describe myself");
        System.out.println("2. Help");
        int index = 0;
        index = scan.nextInt();
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
                    scan.nextLine();
                }
                System.out.println(s);
            case 2:
                try {
                    kanga.help("Piglet");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scan.nextLine();
                }
        }
    }
}
