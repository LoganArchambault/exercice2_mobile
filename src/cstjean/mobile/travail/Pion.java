package cstjean.mobile.travail;

/**
 * Représente un pion avec une couleur.
 * La couleur est définie à la création du pion ou par défaut à "Blanc".
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Pion {

    /**
     * les differentes couleurs de pion possible.
     */
    public enum Couleur { Blanc, Noir}

    /** La couleur du pion. */
    private final Couleur couleurDuPion;

    /**
     * Constructeur avec paramètre.
     *
     * @param couleurDuPion la couleur du pion
     */
    public Pion(Couleur couleurDuPion) {
        this.couleurDuPion = couleurDuPion;
    }

    /**
     * Constructeur par défaut.
     *
     * <p>
     *    Initialise la couleur à "Blanc".
     * </p>
     */
    public Pion() {
        this.couleurDuPion = Couleur.Blanc;
    }

    /**
     * Retourne la couleur du pion.
     *
     * @return la couleur du pion
     */
    public Couleur getCouleur() {
        return couleurDuPion;
    }

    public String getRepresentation() {
        if (couleurDuPion == Couleur.Blanc) {
            return "p";
        } else if (couleurDuPion == Couleur.Noir) {
            return "P";
        }
        return "-";
    }
}
