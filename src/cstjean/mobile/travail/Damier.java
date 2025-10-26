package cstjean.mobile.travail;

import java.util.HashMap;
import java.util.Map;

/**
 * Représente un damier contenant les pions et dames.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Damier {

    /** Les cases jouables du damier, numérotées de 1 à 50. */
    private final Map<Integer, Pion> cases = new HashMap<>();

    /** Constructeur par défaut. */
    public Damier() {}

    /**
     * Retourne le pion à une case donnée.
     *
     * @param position positon de la piece.
     * @return le {@link Pion} a la position donner.
     */
    public Pion getPion(int position) {
        return cases.get(position);
    }

    /**
     * Ajoute un pion à une case donnée.
     *
     *  @param position position de la piece a ajouter.
     *  @param pion a ajouter.
     */
    public void ajouterPion(int position, Pion pion) {
        cases.put(position, pion);
    }

    /**
     * Supprime le {@link Pion} d’une case donnée.
     *
     * @param position du pion a supprimer.
     */
    public void retirerPion(int position) {
        cases.put(position, null);
    }

    /**
     * Retourne le nombre total de pions présentes sur le damier.
     *
     * @return valeur integer representant le nombre de pions sur le damier.
     */
    public int getNbPions() {
        int count = 0;
        for (Pion pion : cases.values()) {
            if (pion != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Initialise le damier avec 4 rangées de 5 pions noirs et 4 rangées de 5 pions blancs.
     */
    public void initialiser() {
        cases.clear();

        // Pions noirs : cases 1 à 20
        for (int i = 1; i <= 20; i++) {
            cases.put(i, new Pion(Pion.Couleur.Noir));
        }

        // Pions blancs : cases 31 à 50
        for (int i = 31; i <= 50; i++) {
            cases.put(i, new Pion(Pion.Couleur.Blanc));
        }
    }

    /**
     * Retourne la Map interne (utile pour la Vue).
     *
     * @return la Map des cases
     */
    public Map<Integer, Pion> getCases() {
        return cases;
    }
}

