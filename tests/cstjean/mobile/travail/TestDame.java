package cstjean.mobile.travail;

/**
 * Tests unitaires pour {@link Dame}.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class TestDame extends TestPions {
    /**
     * Vérifie la création et la couleur d’une dame.
     */
    public void testCreer() {
        Dame dameBlanche = (Dame) creerPion(Pion.Couleur.Blanc);
        assertEquals("d", dameBlanche.getRepresentation());
        assertEquals(Pion.Couleur.Blanc, dameBlanche.getCouleur());

        Dame dameNoire = (Dame) creerPion(Pion.Couleur.Noir);
        assertEquals("D", dameNoire.getRepresentation());
        assertEquals(Pion.Couleur.Noir, dameNoire.getCouleur());
    }

    /**
     * Crée une nouvelle instance de Dame avec la couleur spécifiée.
     * Cette méthode redéfinit celle de la classe Pion pour retourner une Dame au lieu d’un Pion.
     *
     * @param couleur La couleur du pion à créer (doit être une valeur de l'énumération Pion.Couleur).
     * @return Une nouvelle instance de Dame avec la couleur donnée.
     */
    @Override
    protected Pion creerPion(Pion.Couleur couleur) {
        return new Dame(couleur);
    }
}
