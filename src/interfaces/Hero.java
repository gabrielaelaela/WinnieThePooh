package interfaces;

import enums.Position;
import heroes.Piglet;

public interface Hero extends Walkable {
    public String getName();
    public String getDescription();
    public void setPosition(Position p);
    public Position getPosition();
    public boolean equals(Hero h);
    public int numberOfFriends();
    public Walkable getFriendByName(String name) throws Exception;
}
