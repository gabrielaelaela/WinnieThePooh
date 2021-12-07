package main.java.interfaces;
import java.util.*;

public interface Wood {
    public boolean removeHero(String name) throws NullPointerException;
    public void removeAllHeroes() throws NullPointerException;
    public boolean containsHero(String name);
    public String listHeroes();
    public boolean hasHeroes();
    public Hero getHeroByName(String name) throws NullPointerException;
    public String getMoreInformation();
    public int friendsQuantity(Hero h);
}
