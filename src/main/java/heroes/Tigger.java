package main.java.heroes;

import main.java.enums.*;
import main.java.interfaces.*;

public class Tigger implements Hero, Emotionable, Greetable {
    private String name;
    private Location location;
    private Position position;
    private Wood wood;

    public Tigger(Wood wood) {
        this.name = "Tigger";
        this.position = Position.STAND;
        this.wood = wood;
    }

    @Override
    public Purity greet() {
        jump();
        return Purity.FULLSAND;
    }

    @Override
    public Happiness jump() {
        int random = (int) Math.round(Math.random()*4);
        return Happiness.getByIndex(random);
    }

    @Override
    public Offensiveness cry() {
        int random = (int) Math.round(Math.random()*4);
        return Offensiveness.getByIndex(random);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return "Tigger is recognized as orange fur with black stripes, large eyes, a long chin, a springy tail, "
                + "and his bouncy personality (Both literally and Figgeratively). His striped tail is long and can make a "
                + "\"Boing!\" sound.";
    }

    @Override
    public void setPosition(Position p) {
        if (p == null) {
            throw new NullPointerException("Incorrect position");
        }
        this.position = p;
    }

    @Override
    public boolean equals(Hero h) {
        return h.getName().equals(this.name);
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
        return setLocation(Location.TIGGERHOME);
    }
    @Override
    public String goHomeWith(Walkable h) {
        setLocation(Location.TIGGERHOME);
        return h.setLocation(Location.TIGGERHOME);
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
    public String toString() {
        return this.name;
    }

    @Override
    public int numberOfFriends() {
        return wood.friendsQuantity(this);
    }

    @Override
    public Walkable getFriendByName(String name) throws NullPointerException {
        return wood.getHeroByName(name);
    }
}
