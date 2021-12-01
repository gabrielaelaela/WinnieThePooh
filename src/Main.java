import UI.HundredAcreWood;

public class Main {
    public static void main(String[] args) throws Throwable {
        woods.HundredAcreWood wood = new woods.HundredAcreWood();
        HundredAcreWood hundredAcreWood = new HundredAcreWood(wood);
        try {hundredAcreWood.start();}
        catch (Throwable ignored) {}
        while(!hundredAcreWood.programIsCompleted()) {
            try {hundredAcreWood.actions();}
            catch (Throwable ignored) {}
        }

    }
}
