package woods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HundredAcreWoodTest {

    private HundredAcreWood wood;

    @Before
    public void setUp() {
        wood = new HundredAcreWood();
    }

    @Test
    public void addPooh() {
        try {
            wood.addPooh();
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertTrue(wood.containsHero("Winnie-the-Pooh"));
    }

    @Test
    public void addPiglet() {
        try {
            wood.addPiglet();
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertTrue(wood.containsHero("Piglet"));
    }

    @Test
    public void addKanga() {
        try {
            wood.addKanga();
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertTrue(wood.containsHero("Kanga"));
    }

    @Test
    public void addTigger() {
        try {
            wood.addTigger();
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertTrue(wood.containsHero("Tigger"));
    }

    @Test
    public void removeHero() {
        try {
            wood.addPooh();
        } catch (Exception e) {
            Assert.fail();
        }
        Assert.assertThrows(Exception.class, () -> wood.removeHero("Piglet"));
    }
}