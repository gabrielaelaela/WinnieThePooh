package heroes;

import enums.Purity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import woods.HundredAcreWood;

import static org.junit.Assert.*;

public class TiggerTest {

    private Tigger tigger;
    private HundredAcreWood wood;

    @Before
    public void setUp() throws Exception {
        wood = new HundredAcreWood();
        wood.addKanga();
        tigger = (Tigger) wood.getHeroByName("Tigger");
    }

    @Test
    public void greet() {
        Assert.assertEquals(tigger.greet(), Purity.FULLSAND);
    }
}