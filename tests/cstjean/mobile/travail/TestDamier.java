package cstjean.mobile.travail;

import junit.framework.TestCase;

/**
 * Test unitaire de la classe 'Damier'.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class TestDamier extends TestCase {


    public void setUp() {
        Damier damier = new Damier();
    }

    public void testCreer() {

<<<<<<< HEAD

    }
    public void testAjouterDamier() {
        Pion pion = new Pion("noire");
    }

    public void testDamier()
    {
        damier.initializeDamier();
        for(int i  = 0; i <= 50; i++)
        {
            assertNull(damier.checkDamier(i));
        }

=======
>>>>>>> 72b1f7024a1b38b41af1e096e2d993f1e1b1e7be
    }
}
