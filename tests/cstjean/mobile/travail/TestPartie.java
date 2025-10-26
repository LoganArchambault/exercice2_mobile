package cstjean.mobile.travail;

import junit.framework.TestCase;
import java.util.List;

/**
 * Tests unitaires pour la classe Partie en style JUnit 3.
 */
public class TestPartie extends TestCase {

    private Partie partie;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        partie = new Partie();
    }

    public void testInitialisationPartie() {
        assertNotNull(partie.getJoueur1());
        assertNotNull(partie.getJoueur2());
        assertEquals(partie.getJoueur1(), partie.getJoueurActuel());

        List<Carte> cartes = partie.getCartes();
        assertEquals(16, cartes.size()); // 8 paires x 2
    }

    public void testChangerJoueur() {
        Joueur initial = partie.getJoueurActuel();
        partie.changerJoueur();
        assertNotSame(initial, partie.getJoueurActuel());

        partie.changerJoueur();
        assertSame(initial, partie.getJoueurActuel());
    }

    public void testRetournerCartePaire() {
        List<Carte> cartes = partie.getCartes();
        Carte premiere = cartes.get(0);
        Carte paire = null;

        for (Carte c : cartes) {
            if (c != premiere && c.estPaire(premiere)) {
                paire = c;
                break;
            }
        }
        assertNotNull(paire);

        // Première carte
        assertTrue(partie.retournerCarte(cartes.indexOf(premiere)));
        assertTrue(premiere.isEstVisible());

        // Deuxième carte = même paire
        assertTrue(partie.retournerCarte(cartes.indexOf(paire)));
        assertTrue(premiere.isEstTrouvee());
        assertTrue(paire.isEstTrouvee());

        // Joueur actuel a reçu 1 point
        assertEquals(1, partie.getJoueurActuel().getScore());
    }

    public void testRetournerCarteNonPaire() {
        List<Carte> cartes = partie.getCartes();
        Carte c1 = cartes.get(0);
        Carte c2 = null;

        for (Carte c : cartes) {
            if (!c.estPaire(c1)) {
                c2 = c;
                break;
            }
        }
        assertNotNull(c2);

        assertTrue(partie.retournerCarte(cartes.indexOf(c1)));
        assertFalse(partie.retournerCarte(cartes.indexOf(c2)));
    }

    public void testEstTerminee() {
        assertFalse(partie.estTerminee());

        for (Carte c : partie.getCartes()) {
            c.marquerTrouvee();
        }
        assertTrue(partie.estTerminee());
    }

    public void testGetGagnant() {
        Joueur j1 = partie.getJoueur1();
        Joueur j2 = partie.getJoueur2();

        j1.ajouterPoints(5);
        j2.ajouterPoints(5);
        assertNull(partie.getGagnant());

        j1.ajouterPoints(1);
        assertEquals(j1, partie.getGagnant());

        j2.ajouterPoints(2);
        assertEquals(j2, partie.getGagnant());
    }

    public void testResetPartie() {
        Joueur j1 = partie.getJoueur1();
        Joueur j2 = partie.getJoueur2();

        j1.ajouterPoints(3);
        j2.ajouterPoints(2);

        Carte c = partie.getCartes().get(0);
        c.marquerTrouvee();

        partie.reset();

        assertEquals(0, j1.getScore());
        assertEquals(0, j2.getScore());
        assertEquals(j1, partie.getJoueurActuel());

        for (Carte carte : partie.getCartes()) {
            assertFalse(carte.isEstVisible());
            assertFalse(carte.isEstTrouvee());
        }
    }
}
