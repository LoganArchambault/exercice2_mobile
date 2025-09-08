package cstjean.mobile.travail;

import java.util.LinkedList;
import java.util.List;

/**
 * Représente un damier contenant une liste de pions.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Damier {
    /** Liste des pions placés sur le damier. */
    private List<Pion> damier = new LinkedList<>();

    /**
     * Constructeur par défaut.
     *
     *
     * @param damier Initialise un damier vide.
     */

    public Damier(LinkedList<Pion> damier) {
        this.damier = damier;
    }

    /**
     * initialise le damier avec 50 cases null.
     */
    public void initializeDamier() {
        int nbPositions = 50;

        for (int i = 0; i < nbPositions; i++) {
            damier.add(null);
        }
    }
    /**
     * Remplit le damier avec des pions blancs et noirs selon des règles prédéfinies.*
     * Cette méthode parcourt la liste `damier` et place des objets `Pion` aux positions spécifiques :
     * - Les pions blancs ("Blanc") sont placés dans les cases d'index 0 à 19, si la case est vide (`null`).
     * - Les pions noirs ("Noir") sont placés dans les cases d'index 30 à 49, si la case est vide (`null`).
     * - Les autres cases ne sont pas modifiées.
     * Préconditions :
     * - La liste `damier` doit être initialisée et contenir au moins 50 éléments.
     * - Chaque élément de la liste peut être `null` ou un objet de type `Pion`.
     * Postconditions :
     * - Les cases 0 à 19 contiendront des pions blancs si elles étaient vides.
     * - Les cases 30 à 49 contiendront des pions noirs si elles étaient vides.
     * - Les autres cases resteront inchangées.
     *
     */

    public void peuplerDamier() {
        for (int i = 0; i < damier.size(); i++) {

            if (damier.get(i) == null && i <= 19) {
                Pion pion = new Pion("Blanc");
                damier.set(i, pion);
            } else if (damier.get(i) == null && i >= 30 && i <= 49) {
                Pion pion = new Pion("Noir");
                damier.set(i, pion);
            } else {
                damier.set(i, null);
            }
        }
    }

    /**
     * Ajoute un pion à une position spécifique du damier.
     *
     * @param index l'index où insérer le pion
     * @param pion le pion à ajouter
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public void ajouterPion(int index, Pion pion) {
        damier.set(index, pion);
    }

    /**
     * Supprime le pion à une position donnée.
     *
     * @param index l'index du pion à retirer
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public void retirerPion(int index) {
        damier.remove(index);
    }

    /**
     * Retourne le pion à une position donnée.
     *
     * @param index l'index du pion à récupérer
     * @return le pion à l'index spécifié
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public Pion getPion(int index) {
        return damier.get(index);
    }

    /**
     * Retourne le nombre de pions sur le damier.
     *
     * @return le nombre de pions
     */
    public int getNbPions() {
        int i = 0;
        for (Pion pion : damier) {
            if (pion != null) {
                i++;
            }
        }
        return i;
    }
}
