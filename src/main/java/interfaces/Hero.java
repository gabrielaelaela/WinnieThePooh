package main.java.interfaces;

import main.java.enums.Position;
import main.java.heroes.Piglet;

public interface Hero extends Walkable {
    String getName();
    String getDescription();
    void setPosition(Position p);
    boolean equals(Hero h);
    int numberOfFriends();
    Walkable getFriendByName(String name) throws NullPointerException;
}
