package cstjean.mobile.travail;

/**
 * Classe représentant une coordonnée sur le damier.
 * Contient la position X et Y d'une case.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Coordonner {

    /** Position horizontale (ligne). */
    private int horizontal;

    /** Position verticale (colonne). */
    private int vertical;

    /**
     * Constructeur d'une coordonnée.
     *
     * @param x la position horizontale
     * @param y la position verticale
     */
    public Coordonner(int x, int y) {
        this.horizontal = x;
        this.vertical = y;
    }

    /** Position combiner x et y. */
    private Coordonner coordonner;

    /**
     * Met à jour la position de la coordonnée.
     *
     * @param coordonner la nouvelle coordonnee
     */
    public void setCoordonner(Coordonner coordonner) {
        this.coordonner = coordonner;
    }

    /**
     * Retourne la position horizontale.
     *
     * @return la position horizontal
     */
    public int getX() {
        return horizontal;
    }

    /**
     * Retourne la position vertical.
     *
     * @return la position vertical
     */
    public int getY() {
        return vertical;
    }
}
