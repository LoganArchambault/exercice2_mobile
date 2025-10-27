package cstjean.mobile.travail;
import junit.framework.TestCase;

/**
 * Classe de test unitaire pour {@link Damier} utilisant HashMap et Piece.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class TestDamier extends TestCase {

    /**
     * initialize un damier.
     */
    private Damier damier;

    /**
     * Initialise le damier avant le début de la partie.
     * Cette méthode est appelée automatiquement par le framework de test ou de configuration.
     */
    @Override
    public void setUp() {
        damier = new Damier();
        damier.initialiser(); // initialise 40 pions + 10 cases vides
    }

    /**
     * Vérifie la création et la couleur des pions et dames.
     */
    public void testCreer() {
        // Creation des pions
        Pion pionBlanc = new Pion(Pion.Couleur.Blanc);
        Pion pionNoir = new Pion(Pion.Couleur.Noir);

        assertEquals(Pion.Couleur.Blanc, pionBlanc.getCouleur());
        assertEquals(Pion.Couleur.Noir, pionNoir.getCouleur());

        // Vérifie les pions ajoutées sur le damier
        damier.ajouterPion(new int[]{1, 2},pionNoir);
        assertEquals(pionNoir, damier.getPion(new int[]{1, 2}));

        damier.ajouterPion(new int[]{9,8}, pionBlanc);
        assertEquals(pionBlanc, damier.getPion(new int[]{9, 8}));

        // Case vide
        damier.retirerPion(new int[]{1,2});
        assertNull(damier.getPion(new int[]{1,2}));
    }

    /**
     * Vérifie le nombre total de pièces.
     */
    public void testAjouterPion() {
        // Initialisation place 40 pions
        assertEquals(40, damier.getNbPions());

        // Ajout d’une pièce supplémentaire
        Pion pion = new Pion(Pion.Couleur.Noir);
        damier.ajouterPion(new int[] {1,2}, pion);
        assertEquals(41, damier.getNbPions());
    }

    /**
     * Vérifie que les dames peuvent être placées et récupérées sur le damier.
     */
    public void testAjouterDame() {
        // Initialisation place 40 pions
        assertEquals(40, damier.getNbPions());

        Pion.Couleur blanc = Pion.Couleur.Blanc;

        Dame dameBlanc = new Dame(blanc);

        damier.ajouterPion(new int[]{1,2}, dameBlanc);
        assertEquals(dameBlanc, damier.getPion(new int[]{1,2}));
        assertEquals(41, damier.getNbPions()); // 41 pions + 1 dame
    }

    /**
     * Vérifie la représentation complète du damier.
     */
    public void testAffichageDamierInitial() {
        String attendu = """
                        -P-P-P-P-P
                        P-P-P-P-P-
                        -P-P-P-P-P
                        P-P-P-P-P-
                        ----------
                        ----------
                        -p-p-p-p-p
                        p-p-p-p-p-
                        -p-p-p-p-p
                        p-p-p-p-p-
                        """;

        assertEquals(attendu, damier.toString());
    }

    /**
     * Vérifie l’affichage complet du damier avec une dame.
     */
    public void testAffichageDamierAvecDame() {
        // Place une dame noire sur la case 10 et une dame blanche sur la case 40.
        Dame dameBlanc = new Dame(Pion.Couleur.Blanc);
        Dame dameNoir = new Dame(Pion.Couleur.Noir);

        damier.ajouterPion(new int[] {1,2}, dameBlanc);
        damier.ajouterPion(new int[] {1,6}, dameNoir);

        String affichage = damier.toString();

        // Vérifie que la case 26 contient "D" (dameNoir) et que la case 27 (dameBlanc) contient "d".
        assertTrue(affichage.contains("d"));
        assertTrue(affichage.contains("D"));
    }
}
