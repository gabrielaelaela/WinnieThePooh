import woods.*;
import UI.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        HundredAcreWood wood = new HundredAcreWood();
        HundredAcreWoodUI hundredAcreWoodUI = new HundredAcreWoodUI(wood);
        try {hundredAcreWoodUI.start();}
        catch (Throwable ignored) {}
        while(!hundredAcreWoodUI.programIsCompleted()) {
            try {hundredAcreWoodUI.actions();}
            catch (Throwable ignored) {}
        }

    }
}
