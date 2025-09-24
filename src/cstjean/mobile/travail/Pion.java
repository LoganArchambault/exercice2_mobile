package cstjean.mobile.travail;

/**
 * Représente un pion classique dans le jeu de dames.
 */
public class Pion extends Piece {

    /**
     * Constructeur avec paramètre.
     *
     * @param couleur la couleur du pion
     */
    public Pion(Couleur couleur) {
        super(couleur);
    }

    /**
     * Constructeur par défaut.
     * Initialise le pion en blanc.
     */
    public Pion() {
        super(Couleur.Blanc);
    }

    /**
     * Retourne la représentation textuelle du pion.
     *
     * @return "p" pour un pion blanc, "P" pour un pion noir, "-" par défaut
     */
    @Override
    public String getRepresentation() {
        if (getCouleur() == Couleur.Blanc) {
            return "p";
        } else if (getCouleur() == Couleur.Noir) {
            return "P";
        }
        return "-";
    }
}
