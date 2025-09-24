package cstjean.mobile.travail;

import junit.framework.TestCase;

/**
 * Tests unitaires pour la classe Dame.
 */
public class TestDame extends TestCase {

    private Damier damier;

    @Override
    public void setUp() {
        damier = new Damier();
        damier.initialiser(); // initialise le damier avec pions
    }

    /** Vérifie la création et la couleur d’une dame */
    public void testCreerDame() {
        Dame dameBlanche = new Dame(Piece.Couleur.Blanc);
        Dame dameNoire = new Dame(Piece.Couleur.Noir);

        assertEquals(Piece.Couleur.Blanc, dameBlanche.getCouleur());
        assertEquals(Piece.Couleur.Noir, dameNoire.getCouleur());

        assertEquals("d", dameBlanche.getRepresentation());
        assertEquals("D", dameNoire.getRepresentation());
    }

    /** Vérifie que les dames peuvent être placées et récupérées sur le damier */
    public void testAjouterDame() {
        Dame dame = new Dame(Piece.Couleur.Noir);
        damier.ajouterPiece(25, dame);

        assertEquals(dame, damier.getPiece(25));
        assertEquals(41, damier.getNbPieces()); // 40 pions + 1 dame
    }

    /** Vérifie l’affichage complet du damier avec une dame */
    public void testAffichageDamierAvecDame() {
        // Place une dame noire sur la case 10
        Dame dame = new Dame(Piece.Couleur.Noir);
        damier.ajouterPiece(10, dame);

        String affichage = damier.toString();

        // Vérifie que la case 10 contient "D" au lieu du pion noir
        assertTrue(affichage.contains("D"));
    }
}
