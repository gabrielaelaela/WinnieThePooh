package heroes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import woods.HundredAcreWood;

import static org.junit.Assert.*;

public class PigletTest {
    HundredAcreWood wood;
    Piglet piglet;

    @Before
    public void setUp() throws Exception {
        wood = new HundredAcreWood();
        wood.addPiglet();
        piglet = (Piglet) wood.getHeroByName("Pooh");
    }

    @Test
    public void wipe() {
        Assert.assertEquals(piglet.wipe(piglet.getPaws(), piglet.getBelly()), "Paws: 'Yay, I am clean now!'\nBelly: 'Oops... I get dirty again :('");
    }
}