package cstjean.mobile.travail;

public abstract class Piece {

    /** Les deux couleurs possibles pour une pièce. */
    public enum Couleur { Blanc, Noir }

    /** Couleur de la pièce. */
    private final Couleur couleur;

    /**
     * Constructeur.
     *
     * @param couleur la couleur de la pièce
     */
    public Piece(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Retourne la couleur de la pièce.
     *
     * @return la couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Retourne la représentation textuelle de la pièce.
     *
     * @return la représentation (P, p, D ou d)
     */
    public abstract String getRepresentation();
}