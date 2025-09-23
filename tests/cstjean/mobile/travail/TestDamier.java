package cstjean.mobile.travail;

import java.util.LinkedList;
import junit.framework.TestCase;

/**
 * Classe de test unitaire pour {@link Damier}.
 *
 * <p>
 * Cette classe vérifie les fonctionnalités principales de la classe {@code Damier},
 * notamment l'initialisation, le peuplement et l'ajout de pions.
 * </p>
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class TestDamier extends TestCase {

    /** Instance de damier utilisée pour les tests. */
    private Damier damier;

    /**
     * Initialise le damier avant chaque test.
     *
     * <p>
     *     Cette méthode est appelée automatiquement avant l'exécution de chaque méthode de test.
     *     Elle crée une nouvelle instance de {@code Damier} et appelle {@code initializeDamier()}.
     * </p>
     */
    @Override
    public void setUp() {
        damier = new Damier();
        damier.initializeDamier();
    }

    /**
     * Vérifie que le damier peut être initialisé et peuplé correctement.
     *
     * <p>
     * Cette méthode appelle {@code peuplerDamier()} puis récupère le nombre de pions
     * présents via {@code getNbPions()}.
     * </p>
     */
    public void testCreer() {
        Pion pion = new Pion();
        assertEquals(Pion.Couleur.Blanc, pion.getCouleur());

        Pion pionNull = null;
        damier.ajouterPion(25, pionNull);
        assertEquals(pionNull, damier.getPion(25));

        Pion pionBlanc = new Pion(Pion.Couleur.Blanc);
        damier.ajouterPion(1, pionBlanc);
        assertEquals(pionBlanc, damier.getPion(1));

        Pion pionNoir = new Pion(Pion.Couleur.Noir);
        damier.ajouterPion(50, pionNoir);
        assertEquals(pionNoir, damier.getPion(50));
    }

    /**
     * Vérifie l'ajout d'un pion dans le damier à une position donnée.
     *
     * <p>
     * Cette méthode ajoute un pion noir à la position 38, puis vérifie que :
     * </p>
     * <ul>
     *   <li>Le pion est bien présent à la position 38.</li>
     *   <li>Le nombre total de pions est égal à 1.</li>
     * </ul>
     */
    public void testAjouterDamier() {
        Pion pion = new Pion(Pion.Couleur.Noir);
        damier.ajouterPion(38, pion);
        assertEquals(pion, damier.getPion(38));
        assertEquals(1, damier.getNbPions());
    }

    public void testAffichageDamierInitial() {
        Damier damier = new Damier();
        damier.initializeDamier();

        // Simule le placement des pions comme dans la version commentée de peuplerDamier()
        for (int i = 0; i < 50; i++) {
            if (i <= 19) {
                damier.ajouterPion(i + 1, new Pion(Pion.Couleur.Noir));
            } else if (i >= 30) {
                damier.ajouterPion(i + 1, new Pion(Pion.Couleur.Blanc));
            }
        }

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

        assertEquals(attendu, damier.toString());
    }
}

