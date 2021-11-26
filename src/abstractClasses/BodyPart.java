package abstractClasses;
import enums.*;

public abstract class BodyPart {
    private Purity purity;

    public BodyPart() {
        purity = Purity.CLEAN;
    }

    public void setPurity (Purity p) {
        this.purity = p;
    }

    public Purity getPurity() {
        return this.purity;
    }

    public String getDirty() {
        this.purity = Purity.DIRTY;
        return "Oops... I get dirty again :(";
    }

    public String getClean() {
        this.purity = Purity.CLEAN;
        return "Yay, I am clean now!";
    }
}
