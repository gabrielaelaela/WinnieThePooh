package interfaces;
import java.util.*;

public interface Wood {
    public boolean removeHero(String name) throws Exception;
    public void removeAllHeroes() throws Exception;
    public boolean containsHero(String name);
    public String listHeroes();
    public boolean hasHeroes();
    public Hero getHeroByName(String name) throws Exception;
    public String getMoreInformation();
    public int friendsQuantity(Hero h);
}
