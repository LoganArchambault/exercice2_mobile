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

<<<<<<< HEAD
    /**
     * Retourne la couleur du pion.
     *
     * @return la couleur du pion
     */
=======
>>>>>>> 983dbca53cd982249f88a99e5d1d899d6552dc15
    public String getCouleur() {
        return couleur;
    }
}
