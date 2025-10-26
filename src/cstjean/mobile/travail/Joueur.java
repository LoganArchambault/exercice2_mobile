package cstjean.mobile.travail;

/**
 * Classe représentant un joueur dans le jeu de mémoire.
 * Un joueur possède un nom et un score qui peut être augmenté ou réinitialisé.
 */
public class Joueur {

    /** Nom du joueur. */
    private final String nom;

    /** Couleur du joueur (Noir ou Blanc). */
    private final Pion.Couleur couleur;

    /**
     * Constructeur du joueur.
     *
     * @param nom le nom du joueur
     * @param couleur la couleur du joueur (Noir ou Blanc)
     */
    public Joueur(String nom, Pion.Couleur couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public Pion.Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return nom + " (" + couleur + ")";
    }
}


