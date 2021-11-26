package enums;
import interfaces.*;

public enum Emotion {
    SCARED,
    PLEASED,
    UPSET,
    OFFENSE;

    public void getResult(Emotionable hero) {
        if (this.equals(PLEASED)) {
            System.out.println(hero.jump());
        } else if (this.equals(UPSET)) {
            System.out.println(hero.cry());
        }
    }
}
