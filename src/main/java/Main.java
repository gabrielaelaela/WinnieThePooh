package main.java;

import main.java.ui.HundredAcreWood;

public class Main {
    public static void main(String[] args) throws Throwable {
        main.java.woods.HundredAcreWood wood = new main.java.woods.HundredAcreWood();
        HundredAcreWood hundredAcreWood = new HundredAcreWood(wood);
        try {hundredAcreWood.start();}
        catch (Throwable ignored) {}
        while(!hundredAcreWood.programIsCompleted()) {
            try {hundredAcreWood.actions();}
            catch (Throwable ignored) {}
        }

    }
}
