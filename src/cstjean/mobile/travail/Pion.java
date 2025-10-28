package cstjean.mobile.travail;

/**
 * Classe représentant un pion classique dans le jeu de dames.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Pion {

    /**
     * Enumération pour les couleurs possibles.
     */
    public enum Couleur {
        Blanc, Noir
    }

    private final Couleur couleur;

    private Boolean deplacable;


    /**
     * Constructeur d'un pion.
     *
     * @param couleur Couleur du pion
     */
    public Pion(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Retourne la couleur du pion.
     *
     * @return Couleur du pion
     */
    public Couleur getCouleur() {
        return couleur;
    }

    public Boolean getDeplacable() {
        return deplacable;
    }

    public void setDeplacable(Boolean deplacable) {
        this.deplacable = deplacable;
    }

    /**
     * Retourne la représentation graphique du pion.
     *
     * @return "p" pour blanc, "P" pour noir
     */
    public String getRepresentation() {
        return (couleur == Couleur.Noir) ? "P" : "p";
    }
}

