package cstjean.mobile.travail;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires de la classe Vue.
 * Objectif : 100% de couverture du code.
 */
public class TestVue {

    private Damier damier;
    private Vue vue;

    @BeforeEach
    public void setUp() {
        damier = new Damier();
        vue = new Vue();
    }

    @Test
    public void testGenererAffichageDamierInitialise() {
        damier.initialiser();

        String attendu =
                "-P-P-P-P-P\n" +
                        "P-P-P-P-P-\n" +
                        "-P-P-P-P-P\n" +
                        "P-P-P-P-P-\n" +
                        "----------\n" +
                        "----------\n" +
                        "-p-p-p-p-p\n" +
                        "p-p-p-p-p-\n" +
                        "-p-p-p-p-p\n" +
                        "p-p-p-p-p-\n";

        String resultat = vue.genererAffichage(damier);

        // Vérifie que l’affichage généré correspond exactement à la version attendue
        assertEquals(attendu, resultat);
    }

    @Test
    public void testGenererAffichageDamierVide() {
        // Damier sans pions (toutes les cases null)
        String resultat = vue.genererAffichage(damier);

        // Vérifie que 10 lignes sont présentes
        long lignes = resultat.lines().count();
        assertEquals(10, lignes);

        // Vérifie que seules des tirets sont utilisés
        assertTrue(resultat.chars().allMatch(c -> c == '-' || c == '\n'));
    }

    @Test
    public void testAfficherConsole() {
        damier.initialiser();

        // Vérifie que la méthode ne plante pas et affiche correctement
        assertDoesNotThrow(() -> vue.afficherConsole(damier));
    }

    @Test
    public void testGenererAffichageAvecQuelquesPionsSupprimes() {
        damier.initialiser();
        damier.retirerPion(1);
        damier.retirerPion(50);

        String resultat = vue.genererAffichage(damier);

        // Vérifie que les pions retirés sont bien remplacés par '-'
        assertTrue(resultat.contains("--P-P-P-P"));
        assertTrue(resultat.endsWith("p-p-p-p--\n"));
    }
}
