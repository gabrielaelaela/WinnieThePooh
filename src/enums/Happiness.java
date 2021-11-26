package enums;

public enum Happiness {
    WHEE, YAY, YOO_HOO, ZOWIE;

    public String toSting() {
        if (this.equals(WHEE) || this.equals(YAY) || this.equals(ZOWIE)) {
            return this + "!";
        } else {
            return "YOO-HOO!";
        }
    }

    public static Happiness getByIndex(int i) {
        switch(i) {
            case 0:
                return WHEE;
            case 1:
                return YAY;
            case 2:
                return YOO_HOO;
            case 3:
                return ZOWIE;
            default:
                return null;
        }
    }
}
