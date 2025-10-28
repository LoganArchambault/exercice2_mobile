package cstjean.mobile.travail;

/**
 * Classe représentant un pion sur le damier.
 * Un pion possède une couleur (noir ou blanc) et peut être ou non déplaçable.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Pion {

    /**
     * Enumération pour les couleurs possibles d'un pion.
     */
    public enum Couleur {
        /** Pion blanc. */
        Blanc,
        /** Pion noir. */
        Noir
    }

    /** Couleur du pion. */
    private final Couleur couleur;

    /** Indique si le pion peut être déplacé. */
    private Boolean deplacable;

    /**
     * Constructeur d'un pion.
     *
     * @param couleur la couleur du pion
     */
    public Pion(Couleur couleur) {
        this.couleur = couleur;
        this.deplacable = true;
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
     * Indique si le pion peut être déplacé.
     *
     * @return {@code true} si le pion est déplaçable, sinon {@code false}
     */
    public Boolean getDeplacable() {
        return deplacable;
    }

    /**
     * Retourne la représentation textuelle du pion.
     * Utilise une majuscule pour les pions noirs et une minuscule pour les pions blancs.
     *
     * @return "P" pour un pion noir, "p" pour un pion blanc
     */
    public String getRepresentation() {
        return (couleur == Couleur.Noir) ? "P" : "p";
    }
}

