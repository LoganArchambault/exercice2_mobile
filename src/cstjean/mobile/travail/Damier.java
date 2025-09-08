package cstjean.mobile.travail;

import java.util.ArrayList;
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
    private List<Pion> damier = new LinkedList<Pion>();

    /**
     * Constructeur par défaut.
     * Initialise une liste vide de pions.
     */
    public Damier(List<Pion> damier) {

        this.damier = damier;
    }

    public void initializeDamier()
    {
        for(int i = 0; i <= 50;i++)
        {
            damier.set(i,null);
        }
    }

        public List<Pion> getDamier() {

        return damier;
    }
        public Pion checkDamier(int index) {

            return getDamier().get(index);
        }

        /**
         * Ajoute un pion à une position spécifique du damier.
         *
         * @param index l'index où insérer le pion
         * @param pion le pion à ajouter
         * @throws IndexOutOfBoundsException si l'index est invalide
         */
        public void ajouterPion(int index, Pion pion) {
            damier.add(index, pion);
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
        public int getNombrePions() {
            return damier.size();

        }
}
