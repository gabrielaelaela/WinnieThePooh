package main.java.woods;

import main.java.heroes.*;
import main.java.interfaces.*;
import java.util.*;

public class HundredAcreWood implements Wood {
    private ArrayList<Hero> heroes;

    public HundredAcreWood() {
        heroes = new ArrayList<>(4);
    }

    public Pooh addPooh() throws IllegalStateException {
        Pooh pooh = new Pooh(this);
        if (containsHero(pooh.getName())) {
            throw new IllegalStateException("Hero is already in the wood");
        }
        heroes.add(pooh);
        return pooh;
    }

    public Piglet addPiglet() throws IllegalStateException {
        Piglet piglet = new Piglet(this);
        if (containsHero(piglet.getName())) {
            throw new IllegalStateException("Hero is already in the wood");
        }
        heroes.add(piglet);
        return piglet;
    }

    public Kanga addKanga() throws IllegalStateException {
        Kanga kanga = new Kanga(this);
        if (containsHero(kanga.getName())) {
            throw new IllegalStateException("Hero is already in the wood");
        }
        heroes.add(kanga);
        return kanga;
    }

    public Tigger addTigger() throws IllegalStateException {
        Tigger tigger = new Tigger(this);
        if (containsHero(tigger.getName())) {
            throw new IllegalStateException("Hero is already in the wood");
        }
        heroes.add(tigger);
        return tigger;
    }

    public String getMoreInformation() {
        return "The Hundred Acre Wood is the name of the forest in which most, if not all of the Winnie-the-Pooh stories "
                + "take place. It‘s location is still uncertain, as is its size, though one could assume that the Wood is "
                + "so-named because it is about 100 acres in size, which would be equivalent to 0.4 square kilometers or 0.16 "
                + "square miles.\nYou can get more information on the website https://pooh.fandom.com/wiki/Hundred_Acre_Wood";

    }

    @Override
    public boolean hasHeroes() {
        return !(heroes.isEmpty());
    }

    @Override
    public boolean removeHero(String name) throws NullPointerException {
        if (containsHero(name)) {
            heroes.remove(getHeroByName(name));
            return true;
        }
        throw new NullPointerException("Hero is not in the wood");
    }

    @Override
    public boolean containsHero(String name) {
        for (Hero addedHero: heroes) {
            if (addedHero.getName().equals(name)) return true;
        }
        return false;
    }

    public Hero getHeroByName(String name) throws NullPointerException {
        for (Hero h: heroes) {
            if (h.getName().equals(name)) return h;
        }
        throw new NullPointerException(name + " is not in the wood");
    }

    @Override
    public void removeAllHeroes() throws NullPointerException {
        for (Hero h: heroes) {
            removeHero(h.getName());
        }
    }

    public String listHeroes() {
        StringBuilder output = new StringBuilder();
        for (Hero h: heroes) {
            output.append(h.getName()).append("\n");
        }
        return output.toString();
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public int friendsQuantity(Hero h) {
        int i = 0;
        for (Hero addedHero: heroes) {
            if (!addedHero.equals(h)) ++i;
        }
        return i;
    }
}
