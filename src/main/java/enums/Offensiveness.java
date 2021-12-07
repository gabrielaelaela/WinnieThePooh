package main.java.enums;

public enum Offensiveness {
    SHAME, DISAPPOINTMENT, NUISANCE, PITY;

    public String toString() {
        if(this.equals(SHAME)) {
            return "Oh no, what a shame!";
        } else if(this.equals(DISAPPOINTMENT)) {
            return "Oh no, what a letdown!";
        } else if(this.equals(NUISANCE)) {
            return "Oh, that's a nuisance!";
        } else if(this.equals(PITY)) {
            return "That's a pity!";
        } else {
            return null;
        }
    }

    public static Offensiveness getByIndex(int i) {
        switch(i) {
            case 0:
                return SHAME;
            case 1:
                return DISAPPOINTMENT;
            case 2:
                return NUISANCE;
            case 3:
                return PITY;
            default:
                return null;
        }
    }
}
