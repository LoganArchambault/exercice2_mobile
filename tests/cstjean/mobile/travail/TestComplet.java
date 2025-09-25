package cstjean.mobile.travail;

import junit.framework.TestSuite;

/**
 * Classe utilitaire pour regrouper tous les tests unitaires dans une suite de tests.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class TestComplet {

    /**
     * Crée et retourne une suite de tests contenant tous les cas de test.
     *
     * @return une instance de {@link TestSuite} contenant tous les tests
     */
    public static TestSuite suite() {
        TestSuite suite = new TestSuite("TestComplet");
        suite.addTestSuite(TestPions.class);
        suite.addTestSuite(TestDamier.class);
        suite.addTestSuite(TestDame.class);
        return suite;
    }
}
