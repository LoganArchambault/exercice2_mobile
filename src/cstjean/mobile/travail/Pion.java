package cstjean.mobile.travail;

/**
 * Représente un pion avec une couleur.
 * La couleur est définie à la création du pion ou par défaut à "Blanc".
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
     * Initialise la couleur à "Blanc".
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
