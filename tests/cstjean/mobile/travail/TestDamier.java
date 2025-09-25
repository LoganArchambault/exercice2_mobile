package cstjean.mobile.travail;

import junit.framework.TestCase;

/**
 * Classe de test unitaire pour {@link Damier} utilisant HashMap et Piece.
 */
public class TestDamier extends TestCase {


    private Damier damier;

    @Override
    public void setUp() {
        damier = new Damier();
        damier.initialiser(); // initialise 40 pions + 10 cases vides
    }

    /** Vérifie la création et la couleur des pions */
    public void testCreer() {
        Pion pionBlanc = new Pion(Piece.Couleur.Blanc);
        Pion pionNoir = new Pion(Piece.Couleur.Noir);

        assertEquals(Piece.Couleur.Blanc, pionBlanc.getCouleur());
        assertEquals(Piece.Couleur.Noir, pionNoir.getCouleur());

        // Vérifie les pièces ajoutées sur le damier
        damier.ajouterPiece(1, pionNoir);
        assertEquals(pionNoir, damier.getPiece(1));

        damier.ajouterPiece(50, pionBlanc);
        assertEquals(pionBlanc, damier.getPiece(50));

        // Case vide
        damier.retirerPiece(25);
        assertNull(damier.getPiece(25));
    }

    /** Vérifie le nombre total de pièces */
    public void testNbPieces() {
        // Initialisation place 40 pions
        assertEquals(40, damier.getNbPieces());

        // Ajout d’une pièce supplémentaire
        Pion pion = new Pion(Piece.Couleur.Noir);
        damier.ajouterPiece(25, pion);
        assertEquals(41, damier.getNbPieces());
    }

    /** Vérifie la représentation complète du damier */
    public void testAffichageDamierInitial() {
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
