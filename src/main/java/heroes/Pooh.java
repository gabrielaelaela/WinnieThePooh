package main.java.heroes;

import main.java.enums.*;
import main.java.interfaces.*;

public class Pooh implements Hero, Talkable {
    private String name;
    private Location location;
    private Position position;
    private Wood wood;

    public Pooh(Wood wood) {
        this.name = "Winnie-the-Pooh";
        this.location = Location.OUTSIDE;
        this.position = Position.STAND;
        this.wood = wood;
    }

    @Override
    public String speak(String s) {
        return s;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return "Edward Winnie-the-Pooh \"Pooh\" Bear is a yellow anthropomorphic bear who has a soft English-accented voice, wears an iconic red " +
                "shirt and is the protagonist of the series. He lives under the name Sanders in a house located in the Hundred Acre Wood. " +
                "Pooh's not (as he himself freely admits) very intelligent, but does have good ideas sometimes. Unfortunately, he has a great " +
                "difficulty communicating these to others. And he's also known as well-behaved, imaginative, nice, nurturing, idealistic, " +
                "even-tempered, thoughtful, happy, eager, protective, optimistic, outgoing, heroic, patient, oblivious, outspoken, helpful, " +
                "benevolent, empathetic, affectionate, respectful, encouraging, dependable, warm-hearted, assertive, relaxed, daring, whimsical, " +
                "impulsive, naive, no-nonsense, ignorant, educated, docile, trustworthy, hedonistic, exuberant, dreamy, positive, observant, " +
                "open-minded, honest, brave, endearing, artistic, righteous, persistent, organized, obsequious, and honorable.";
    }

    @Override
    public void setPosition(Position p) {
        if (p == null) {
            throw new NullPointerException("Incorrect position");
        }
        this.position = p;
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
        return setLocation(Location.POOHHOME);
    }
    @Override
    public String goHomeWith(Walkable h) {
        setLocation(Location.POOHHOME);
        return h.setLocation(Location.POOHHOME);
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
    public boolean equals(Hero h) {
        return h.getName().equals(this.name);
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
