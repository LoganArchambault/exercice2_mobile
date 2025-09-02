package cstjean.mobile.travail;
import junit.framework.TestCase;

public class TestPions extends TestCase{

    public void testCouleur() {
        Pion pion = new Pion("Rouge");
        assertEquals("Rouge", pion.GetCouleur());

        Pion pion2 = new Pion("Noir");
        assertEquals("Noir", pion2.GetCouleur());
    }
    public void testCreer() {
        Pion pion1 = new Pion("Rouge");
        Damier damier = new Damier();
    }

}
