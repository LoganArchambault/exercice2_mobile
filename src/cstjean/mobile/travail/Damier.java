package cstjean.mobile.travail;

import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * Représente un damier contenant une liste de pions.
 */
public class Damier {

    /** Liste des pions placés sur le damier. */
    private final List<Pion> damier;

    /**
     * Constructeur par défaut.
     * Initialise une liste vide de pions.
     */
    public Damier() {
        this.damier = new ArrayList<>();
    }
=======
 *
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Damier {

    private final List<Pion> pions = new ArrayList<>();
    public Damier() {}
>>>>>>> 983dbca53cd982249f88a99e5d1d899d6552dc15

    /**
     * Ajoute un pion à une position spécifique du damier.
     *
     * @param index l'index où insérer le pion
     * @param pion le pion à ajouter
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public void ajouterPion(int index, Pion pion) {
<<<<<<< HEAD
        damier.add(index, pion);
=======
        pions.add(index, pion);
>>>>>>> 983dbca53cd982249f88a99e5d1d899d6552dc15
    }
}
