package cstjean.mobile.travail;
import junit.framework.TestCase;

public class TestPions extends TestCase{

    public void testCouleur() {
        Pion pion = new Pion("Blanc");
        assertEquals("Blanc", pion.GetCouleur());

        Pion pion2 = new Pion("Noir");
        assertEquals("Noir", pion2.GetCouleur());
    }
    public void testCreer() {
        String couleur = "Blanc";
        Pion pion1 = new Pion(couleur);
        assertEquals(couleur, pion1.GetCouleur());


        Pion pion2 = new Pion();
        assertEquals(couleur, pion2.GetCouleur());
    }

}
