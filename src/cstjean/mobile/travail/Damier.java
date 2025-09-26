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

        // Cases vides : 21 à 30
        for (int i = 21; i <= 30; i++) {
            cases.put(i, null);
        }

        // Pions blancs : cases 31 à 50
        for (int i = 31; i <= 50; i++) {
            cases.put(i, new Pion(Pion.Couleur.Blanc));
        }
    }

    /**
     * Génère une représentation textuelle du damier.
     *
     * <p>
     *  Les cases jouables sont numérotées de 1 à 50 et peuvent êtres vides ou contenir un pion.
     *  Les cases non jouables sont représentées par '-'.
     * </p>
     *
     * @return Une chaîne de caractères représentant le damier.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int caseNum = 1; // de 1 à 50

        for (int ligne = 0; ligne < 10; ligne++) {
            for (int col = 0; col < 10; col++) {
                if ((ligne + col) % 2 == 1) { // case jouable
                    Pion pion = cases.get(caseNum++);
                    sb.append(pion == null ? "-" : pion.getRepresentation());
                } else {
                    sb.append("-");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
