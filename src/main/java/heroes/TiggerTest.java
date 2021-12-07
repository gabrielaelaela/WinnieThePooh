package main.java.heroes;

import main.java.enums.Purity;
import org.junit.*;
import main.java.woods.HundredAcreWood;

import static org.junit.Assert.*;

public class TiggerTest {

    private Tigger tigger;
    private HundredAcreWood wood;

    @Before
    public void setUp() throws Exception {
        wood = new HundredAcreWood();
        tigger = wood.addTigger();
    }

    @Test
    public void greet() {
        Assert.assertEquals(tigger.greet(), Purity.FULLSAND);
    }
}