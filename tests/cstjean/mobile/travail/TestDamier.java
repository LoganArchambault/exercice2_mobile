package cstjean.mobile.travail;

import junit.framework.TestCase;

import java.util.List;

/**
 * Test unitaire de la classe 'Damier'.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class TestDamier extends TestCase {
    Damier damier;

    public void setUp() {

    }

    public void testCreer() {

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
    }
}