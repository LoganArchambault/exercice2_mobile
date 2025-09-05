package cstjean.mobile.travail;

import java.util.ArrayList;
import java.util.List;

/**
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
}
