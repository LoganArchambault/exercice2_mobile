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
     * Vérifie que la couleur d'un pion est correctement attribuée et retournée.
     *
     * <p>
     * Crée deux pions avec les couleurs "Blanc" et "Noir", puis vérifie
     * que la méthode {@code getCouleur()} retourne la couleur attendue.
     * </p>
     */
    public void testCouleur() {
        Pion pion = new Pion(Pion.Couleur.Blanc);
        assertEquals(Pion.Couleur.Blanc, pion.getCouleur());

        Pion pion2 = new Pion(Pion.Couleur.Noir);
        assertEquals(Pion.Couleur.Noir, pion2.getCouleur());
    }

    /**
     * Vérifie la création d'un pion à partir d'une variable de couleur.
     *
     * <p>
     * Crée deux pions en utilisant des variables {@code couleur1} et {@code couleur2},
     * puis vérifie que la couleur retournée correspond à celle passée au constructeur.
     * </p>
     */
    public void testCreer() {
        Pion pion1 = new Pion(Pion.Couleur.Blanc);
        assertEquals(Pion.Couleur.Blanc, pion1.getCouleur());

        Pion pion2 = new Pion(Pion.Couleur.Noir);
        assertEquals(Pion.Couleur.Noir, pion2.getCouleur());
    }
}
