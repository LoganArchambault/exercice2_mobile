package cstjean.mobile.travail;

/**
 * Représente un pion classique dans le jeu de dames.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Pion {

    /**
     * Les deux couleurs possibles pour un pion.
     */
    public enum Couleur { Blanc, Noir }

    /**
     * Couleur du pion.
     */
    private final Couleur couleur;

    /**
     * Constructeur avec paramètre.
     *
     * @param couleur la couleur du pion
     */
    public Pion(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Retourne la couleur du pion.
     *
     * @return la couleur du pion
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Retourne la représentation textuelle du pion.
     *
     * @return "p" pour un pion blanc, "P" pour un pion noir, "-" par défaut
     */
    public String getRepresentation() {
        return (couleur == Couleur.Noir) ? "P" : "p";
    }
}
.