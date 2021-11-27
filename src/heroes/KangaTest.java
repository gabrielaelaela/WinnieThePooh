package heroes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import woods.HundredAcreWood;

import static org.junit.Assert.*;

public class KangaTest {
    HundredAcreWood wood;
    Kanga kanga;

    @Before
    public void setUp() throws Exception {
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