package main.java.interfaces;

import main.java.enums.*;

public interface Walkable {
    public String goTo(Location l);
    public String goToWith(Walkable withWho, Location l);
    public String goHome();
    public String goHomeWith(Walkable h);
    public String setLocation(Location l);
    public Location getLocation();
}
