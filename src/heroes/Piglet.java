package heroes;
import abstractClasses.*;
import bodyParts.*;
import enums.*;
import interfaces.*;

public class Piglet implements Hero, Talkable, Emotionable, Positionable, Wipeable {
    private Emotion emotion;
    private Position position;
    private String name;
    private Location location;
    private Paws paws;
    private Belly belly;
    private Ears ears;
    private Eyes eyes;
    private Wood wood;

    public Piglet(Wood wood) {
        this.setEmotion(Emotion.PLEASED);
        this.position = Position.STAND;
        this.name = "Piglet";
        this.location = Location.OUTSIDE;
        this.belly = new Belly();
        this.paws = new Paws();
        this.ears = new Ears();
        this.eyes = new Eyes();
        this.wood = wood;
    }

    @Override
    public String speak(String s) {
        return s;
    }

    @Override
    public Happiness jump() {
        int random = (int) Math.floor(Math.random()*4);
        return Happiness.getByIndex(random);
    }

    @Override
    public Offensiveness cry() {
        this.eyes.setPurity(Purity.WET);
        int random = (int) Math.round(Math.random()*4);
        return Offensiveness.getByIndex(random);
    }

    @Override
    public void setPosition(Position p) {
        if (p == null) {
            throw new NullPointerException("Incorrect position");
        }
        this.position = p;
    }
    @Override
    public Position getPosition() {
        return this.position;
    }
    @Override
    public boolean stands() {
        return this.position.equals(Position.STAND);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return "Piglet is Winnie the Pooh’s closest friend. He is a small pig who loves acorns (sometimes called \"haycorns\") "
                + "and helping his friends. He’s timid and has many fears, but he can be brave sometimes. And he is also known "
                + "as passive, independent, good-tempered, loving, encouraging, thoughtful, polite, insecure, generous, protective,"
                + " imaginative, gentle, loyal, efficient, trustworthy, organized, level-headed, diligent, patient, affectionate "
                + "and loyal.";
    }

    public Emotion getEmotion() {
        return emotion;
    }
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
    public void getEmotionalResult() {
        this.emotion.getResult(this);
    }

    @Override
    public String goTo(Location l) {
        return setLocation(l);
    }
    @Override
    public String goToWith(Walkable withWho, Location l) {
        setLocation(l);
        return withWho.setLocation(l);
    }
    @Override
    public String goHome() {
        return setLocation(Location.PIGLETHOME);
    }
    @Override
    public String goHomeWith(Walkable h) {
        setLocation(Location.PIGLETHOME);
        return h.setLocation(Location.PIGLETHOME);
    }
    @Override
    public String setLocation(Location l) {
        if (l == null) {
            throw new NullPointerException("Incorrect location");
        }
        location = l;
        return "I like this place!";
    }
    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String wipe(BodyPart wipeable, BodyPart subject) {
        return "Paws: '" + this.paws.getClean() + "'\nBelly: '" + this.belly.getDirty() + "'";
    }

    public Paws getPaws() {
        return this.paws;
    }
    public Belly getBelly() {
        return this.belly;
    }
    public Ears getEars() {return this.ears;}

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Hero h) {
        return h.getName().equals(this.name);
    }

    @Override
    public int numberOfFriends() {
        return wood.friendsQuantity(this);
    }

    @Override
    public Walkable getFriendByName(String name) throws Exception {
        return wood.getHeroByName(name);
    }
}
