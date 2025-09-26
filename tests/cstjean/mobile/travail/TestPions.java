package cstjean.mobile.travail;

import junit.framework.TestCase;

/**
 * Classe de test unitaire pour {@link Pion}.
 *
 * <p>
 * Cette classe vérifie que les objets {@code Pion} sont correctement créés
 * et que leur couleur est bien attribuée et accessible.
 * </p>
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class TestPions extends TestCase {

    /**
     * Vérifie la création d'un pion à partir d'une variable de couleur.
     *
     * <p>
     * Crée deux pions avec les couleurs "Blanc" et "Noir", puis vérifie
     * que les méthodes {@code getCouleur()} et {@code getRepresentation()} retourne les valeurs attendues.
     * </p>
     */
    public void testCreer() {
        Pion pionBlanc = creerPion(Pion.Couleur.Blanc);
        assertEquals(Pion.Couleur.Blanc, pionBlanc.getCouleur());
        assertEquals("p", pionBlanc.getRepresentation());

        Pion pionNoir = creerPion(Pion.Couleur.Noir);
        assertEquals(Pion.Couleur.Noir, pionNoir.getCouleur());
        assertEquals("P", pionNoir.getRepresentation());
    }

    /**
     * Crée un nouveau pion avec la couleur spécifiée.
     *
     * @param couleur La couleur du pion à créer (doit être une valeur de l'énumération Pion.Couleur).
     * @return Une nouvelle instance de Pion avec la couleur donnée en parametre.
     */
    protected Pion creerPion(Pion.Couleur couleur) {
        return new Pion(couleur);
    }
}
