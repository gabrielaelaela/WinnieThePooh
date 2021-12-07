package main.java.heroes;

import org.junit.*;
import main.java.woods.HundredAcreWood;

public class PigletTest {
    HundredAcreWood wood;
    Piglet piglet;

    @Before
    public void setUp() throws Exception {
        wood = new HundredAcreWood();
        piglet = wood.addPiglet();
    }

    @Test
    public void wipe() {
        Assert.assertEquals(piglet.wipe(piglet.getPaws(), piglet.getBelly()), "Paws: 'Yay, I am clean now!'\nBelly: 'Oops... I get dirty again :('");
    }
}