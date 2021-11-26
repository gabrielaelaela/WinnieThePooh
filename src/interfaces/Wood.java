package interfaces;
import java.util.*;

public interface Wood {
    public boolean removeHero(String name);
    public void removeAllHeroes();
    public boolean containsHero(String name);
    public String listHeroes();
    public boolean hasHeroes();
    public Hero getHeroByName(String name);
    public String getMoreInformation();
    public int friendsQuantity(Hero h);
}
