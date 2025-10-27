package cstjean.mobile.travail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe représentant une partie de jeu de dames.
 * Gère les deux joueurs, le damier, et le tour en cours.
 */
public class Partie {

    /**Les cases ou la prise de pion est impossible*/
    private int[] CaseImprennable = {1,2,3,4,5,6,15,25,35,45,16,26,36,46,47,48,49,50};
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
        joueurBlanc = new Joueur("Joueur 1", Pion.Couleur.Blanc);
        joueurNoir = new Joueur("Joueur 2", Pion.Couleur.Noir);
        joueurActuel = joueurBlanc;

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
     * Decide si un pion peut bouger en fonctions de si : il y as une piece sur la case destination, une piece sur la case actuelle.
     * @param p pions a deplacer.
     * @param destination potientiel destination du pion.
     * @param positionActuelle postion du pion.
     * @return si oui ou non il peut etre deplacer.
     */
    public Boolean DroitDeplacement(Pion p,int[] destination, int[] positionActuelle) {
        if(damier.getPion(destination) != null &&  damier.getPion(positionActuelle) != null) {
            if (p.getCouleur() != damier.getCases().get(destination).getCouleur()) {
                if (p.getCouleur() == Pion.Couleur.Noir) {
                    if (positionActuelle[0] + 1 == destination[0] && positionActuelle[1] - 1 == destination[1] || positionActuelle[0] + 1 == destination[0] && positionActuelle[1] + 1 == destination[1]) {
                        return true;
                    }
                } else if (p.getCouleur() == Pion.Couleur.Blanc) {
                    if (positionActuelle[0] - 1 == destination[0] && positionActuelle[1] - 1 == destination[1] || positionActuelle[0] + 1 == destination[0] && positionActuelle[1] - 1 == destination[1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
    Change la position du pion lors d'un deplacement.
     @return retourne un Boolean pour facilite la gestion d'erreur de la vue avec android studio.
     */
    public Boolean ActionDeplacement(Pion p,int[] destination, int[] positionActuelle) {
        if(DroitDeplacement(p,destination, positionActuelle)) {
                damier.getCases().put(destination,damier.getPion(positionActuelle));
                damier.getCases().remove(positionActuelle);
                return true;
        }
        return false;
    }

    /**
     * Decide si oui ou non la capture peut arriver.
     * @param p le pions qui attaque.
     * @param destination la destinations final de l'attaqueur.
     * @return si oui ou non la capture peut arriver.
     */
    public Boolean DroitDeCapture(Pion p, int[] destination, int[] positionActuelle) {
        if(damier.getPion(destination) != null &&  damier.getPion(positionActuelle) != null) {//*pas FINI
            if(p.getCouleur() != damier.getPion(destination).getCouleur()) {

                return true;
            }
        }

        return false;
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
        joueurActuel = joueurBlanc;
    }
}

