package cstjean.mobile.travail;
import junit.framework.TestCase;

/**
 * Test unitaire de la classe 'Pion'.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class TestPions extends TestCase{

    public void testCouleur() {
        Pion pion = new Pion("Blanc");
        assertEquals("Blanc", pion.getCouleur());

        Pion pion2 = new Pion("Noir");
        assertEquals("Noir", pion2.getCouleur());
    }
    public void testCreer() {
        String couleur1 = "Blanc";
        Pion pion1 = new Pion(couleur1);
        assertEquals(couleur1, pion1.getCouleur());

        String couleur2 = "Noir";
        Pion pion2 = new Pion(couleur2);
        assertEquals(couleur2, pion2.getCouleur());
    }

}
