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

    /** La couleur du pion. */
    private final String couleur;

    /**
     * Constructeur avec paramètre.
     *
     * @param couleur la couleur du pion
     */
    public Pion(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Constructeur par défaut.
     *
     * <p>
     *    Initialise la couleur à "Blanc".
     * </p>
     */
    public Pion() {
        this.couleur = "Blanc";
    }

    /**
     * Retourne la couleur du pion.
     *
     * @return la couleur du pion
     */
    public String getCouleur() {
        return couleur;
    }
}
