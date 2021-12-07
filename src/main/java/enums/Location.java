package main.java.enums;

public enum Location {
    OUTSIDE("outside"),
    POOHHOME("to the Pooh's house"),
    PIGLETHOME("to the Piglet's house"),
    KANGAHOME("to the Kanga's house"),
    TIGGERHOME("to the Tigger's house");

    private final String string;

    Location(String string) {
        this.string = string;
    }

    public String toString() {
        return string;
    }

    public static String possibleLocations() {
        return "1. " + OUTSIDE.toString() + "\n2. " + POOHHOME.toString() + "\n3. " + PIGLETHOME.toString() + "\n4. " + KANGAHOME.toString() + "\n5. " + TIGGERHOME.toString();
    }
}
