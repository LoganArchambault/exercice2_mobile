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

<<<<<<< HEAD
    private List<Pion> damier;
    public Damier() {
        this.damier = new LinkedList<Pion>();
    }

    public void ajouterPion(int index,Pion pion) {
        damier.add(index,pion);
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
=======
    /** Liste des pions placés sur le damier. */
    private final List<Pion> pions;

    /**
     * Constructeur par défaut.
     * Initialise une liste vide de pions.
     */
    public Damier() {
        this.pions = new ArrayList<>();
    }

    /**
     * Ajoute un pion à une position spécifique du damier.
     *
     * @param index l'index où insérer le pion
     * @param pion le pion à ajouter
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public void ajouterPion(int index, Pion pion) {
        pions.add(index, pion);
    }

    /**
     * Retourne le pion à une position donnée.
     *
     * @param index l'index du pion à récupérer
     * @return le pion à l'index spécifié
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public Pion getPion(int index) {
        return pions.get(index);
    }

    /**
     * Supprime le pion à une position donnée.
     *
     * @param index l'index du pion à retirer
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public void retirerPion(int index) {
        pions.remove(index);
    }

    /**
     * Retourne le nombre de pions sur le damier.
     *
     * @return le nombre de pions
     */
    public int getNombrePions() {
        return pions.size();
>>>>>>> 72b1f7024a1b38b41af1e096e2d993f1e1b1e7be
    }
}
