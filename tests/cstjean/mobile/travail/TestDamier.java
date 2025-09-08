package cstjean.mobile.travail;

import junit.framework.TestCase;

import java.util.List;
import java.util.LinkedList;

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
        damier = new Damier(new LinkedList<Pion>());
    }

    public void testCreer() {
        damier.initializeDamier();
        damier.peuplerDamier();
        damier.getNbPions();
    }

    public void testAjouterDamier() {
        Pion pion = new Pion("noire");
    }
}