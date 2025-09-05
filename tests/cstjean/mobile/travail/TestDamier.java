package cstjean.mobile.travail;

import junit.framework.TestCase;

public class TestDamier extends TestCase {
    Damier damier;


    public void setUp() {
        Damier damier = new Damier();
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
