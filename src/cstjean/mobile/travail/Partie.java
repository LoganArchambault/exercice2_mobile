package cstjean.mobile.travail;

/**
 * Classe représentant une partie de jeu de dames.
 * Gère les deux joueurs, le damier, et le tour en cours.
 */
public class Partie {

    /** Premier joueur (pions noirs). */
    private Joueur joueurNoir;

    /** Deuxième joueur (pions blancs). */
    private Joueur joueurBlanc;

    /** Joueur dont c’est le tour. */
    private Joueur joueurActuel;

    /** Damier du jeu. */
    private Damier damier;

    /**
     * Constructeur par défaut.
     * Initialise les joueurs et le damier.
     */
    public Partie() {
        joueurNoir = new Joueur("Joueur 1", Pion.Couleur.Noir);
        joueurBlanc = new Joueur("Joueur 2", Pion.Couleur.Blanc);
        joueurActuel = joueurNoir;

        damier = new Damier();
        damier.initialiser();
    }

    /**
     * Retourne le damier du jeu.
     *
     * @return le damier actuel
     */
    public Damier getDamier() {
        return damier;
    }

    /**
     * Retourne le joueur actuellement actif.
     *
     * @return le joueur dont c’est le tour
     */
    public Joueur getJoueurActuel() {
        return joueurActuel;
    }

    /**
     * Change le joueur actif (passe au tour de l’autre joueur).
     */
    public void changerJoueur() {
        joueurActuel = (joueurActuel == joueurNoir) ? joueurBlanc : joueurNoir;
    }

    /**
     * Retourne le joueur noir.
     *
     * @return le joueur noir
     */
    public Joueur getJoueurNoir() {
        return joueurNoir;
    }

    /**
     * Retourne le joueur blanc.
     *
     * @return le joueur blanc
     */
    public Joueur getJoueurBlanc() {
        return joueurBlanc;
    }

    /**
     * Réinitialise la partie.
     * Réinitialise le damier et recommence avec le joueur noir.
     */
    public void reset() {
        damier.initialiser();
        joueurActuel = joueurNoir;
    }

    /**
     * Affiche le damier et indique quel joueur doit jouer.
     *
     * @return une chaîne représentant l’état actuel de la partie.
     */
    @Override
    public String toString() {
        return "Tour de : " + joueurActuel.getNom() + " (" + joueurActuel.getCouleur() + ")\n"
                + damier.toString();
    }
}
.
