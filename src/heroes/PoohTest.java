package heroes;

import enums.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import woods.HundredAcreWood;

import static org.junit.Assert.*;

public class PoohTest {
    private HundredAcreWood wood;
    private Pooh pooh;

    @Before
    public void setUp() throws Exception {
        wood = new HundredAcreWood();
        wood.addPooh();
        pooh = (Pooh)wood.getHeroByName("Pooh");
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
        try {
            wood.addPiglet();
        } catch (Exception e) {
            Assert.fail();
        }
        try {
            Assert.assertEquals(pooh.getFriendByName("Piglet"), new Piglet(wood));
        } catch (Exception e) {
            Assert.fail();
        }
    }
}