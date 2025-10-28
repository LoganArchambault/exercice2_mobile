package cstjean.mobile.travail;

/**
 * Classe représentant un joueur dans le jeu de dames.
 * Un joueur possède un nom et une couleur (noir ou blanc).
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Joueur {

    /** Nom du joueur. */
    private final String nom;

    /** Couleur du joueur (noir ou blanc). */
    private final Pion.Couleur couleur;

    /**
     * Constructeur du joueur.
     *
     * @param nom le nom du joueur
     * @param couleur la couleur du joueur (noir ou blanc)
     */
    public Joueur(String nom, Pion.Couleur couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    /**
     * Retourne le nom du joueur.
     *
     * @return le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne la couleur du joueur.
     *
     * @return la couleur du joueur (noir ou blanc)
     */
    public Pion.Couleur getCouleur() {
        return couleur;
    }

    /**
     * Retourne la représentation textuelle du joueur.
     *
     * @return le nom suivi de la couleur du joueur
     */
    @Override
    public String toString() {
        return nom + " (" + couleur + ")";
    }
}


