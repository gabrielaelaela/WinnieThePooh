package main.java.heroes;

import main.java.enums.Location;
import org.junit.*;
import main.java.woods.HundredAcreWood;

import static org.junit.Assert.*;

public class PoohTest {
    private HundredAcreWood wood;
    private Pooh pooh;

    @Before
    public void setUp() throws Exception {
        wood = new HundredAcreWood();
        pooh = wood.addPooh();
    }

    @Test
    public void goToWith() {
        try {
            wood.addPiglet();
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertEquals(pooh.goToWith(new Piglet(wood), Location.KANGAHOME), "I like this place!");
    }

    @Test
    public void goHomeWith() {
        try {
            wood.addPiglet();
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertEquals(pooh.goToWith(new Piglet(wood), Location.KANGAHOME), "I like this place!");
    }

    @Test
    public void getFriendByName() {
        Piglet piglet = null;
        try {
            piglet = wood.addPiglet();
        } catch (Exception e) {
            Assert.fail();
        }
        try {
            Assert.assertEquals(pooh.getFriendByName("Piglet"), piglet);
        } catch (Exception e) {
            Assert.fail();
        }
    }
}