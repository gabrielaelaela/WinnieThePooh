package main.java.heroes;

import main.java.heroes.Kanga;
import org.junit.*;
import main.java.woods.HundredAcreWood;

public class KangaTest {
    HundredAcreWood wood;
    Kanga kanga;

    @Before
    public void setUp() {
        wood = new HundredAcreWood();
        kanga = wood.addKanga();
    }

    @Test
    public void help() {
        try {
            wood.addPiglet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(kanga.help("Piglet"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}