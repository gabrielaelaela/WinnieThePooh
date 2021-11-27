package heroes;
import enums.*;
import interfaces.*;
public class Kanga implements Hero, Talkable, Helpable {
    private String name;
    private Location location;
    private Position position;
    private Wood wood;

    public Kanga(Wood wood) {
        this.name = "Kanga";
        this.position = Position.STAND;
        this.wood = wood;
    }

    @Override
    public boolean help(String name) throws Exception {
        Hero hero = wood.getHeroByName(name);
        hero.setPosition(Position.STAND);
        return true;
    }

    @Override
    public String speak(String s) {
        return "Kanga says: '" + s + "'";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return "Kanga is a fictional character in A.A. Milne's books about Winnie-the-Pooh. She is a very beautiful brown female "
                + "kangaroo, just like her son Roo. She is also a good friend to Winnie-the-Pooh and all the other residents of "
                + "the Hundred Acre Wood. She lives with Roo in a house near the Sandy Pit in the northwestern part of the Forest. "
                + "Tigger later comes to live with them, though only in the original storybooks.";
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
        return setLocation(Location.KANGAHOME);
    }
    @Override
    public String goHomeWith(Walkable h) {
        setLocation(Location.KANGAHOME);
        return h.setLocation(Location.KANGAHOME);
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
        if (h.getName().equals(this.name)) return true;
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
