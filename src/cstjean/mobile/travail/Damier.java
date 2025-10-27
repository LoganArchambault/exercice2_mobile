package cstjean.mobile.travail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe représentant le damier de 50 cases jouables.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Damier {

    private final Map<Coordonner, Pion> cases = new HashMap<>();

    /**
     * Initialise le damier avec 20 pions noirs et 20 pions blancs.
     */
    public void initialiser() {
        cases.clear();
        for (int ligne = 0; ligne < 10; ligne++) {
            for (int col = 0; col < 10; col++) {
                if ((ligne + col) % 2 == 1) {
                    Coordonner pos = new Coordonner(ligne, col);
                    if (ligne < 4) {
                        cases.put(pos, new Pion(Pion.Couleur.Blanc));
                    } else if (ligne > 5) {
                        cases.put(pos, new Pion(Pion.Couleur.Noir));
                    } else {
                        cases.put(pos, null);
                    }
                }
            }
        }
    }
    /**
     * Retourne le pion à une position donnée.
     *
     * @param coordonner Position (1 à 50)
     * @return Pion à cette position ou null
     */
    public Pion getPion(Coordonner coordonner) {
        return cases.get(coordonner);
    }

    /**
     * Ajoute un pion à une position.
     *
     * @param position Position
     * @param pion     Pion à ajouter
     */
    public void ajouterPion(Coordonner coordonner, Pion pion) {
        cases.put(coordonner, pion);
    }

    /**
     * Retire le pion d'une position.
     *
     * @param position Position à vider
     */
    public void retirerPion(Coordonner coordonner) {
        cases.put(coordonner, null);
    }

    /**
     * Retourne le nombre total de pions sur le damier.
     *
     * @return Nombre de pions
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
     * Retourne le nombre de pions d'une couleur.
     *
     * @param couleur Couleur
     * @return Nombre de pions
     */
    public int getNbPions(Pion.Couleur couleur) {
        int count = 0;
        for (Pion pion : cases.values()) {
            if (pion != null && pion.getCouleur() == couleur) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retourne toutes les positions occupées par des pions d'une couleur.
     *
     * @param couleur Couleur
     * @return Liste des positions
     */
    public List<Coordonner> getPositionsAvecCouleur(Pion.Couleur couleur) {
        List<Coordonner> positions = new ArrayList<>();
        for (Map.Entry<Coordonner, Pion> entry : cases.entrySet()) {
            Pion pion = entry.getValue();
            if (pion != null && pion.getCouleur() == couleur) {
                positions.add(entry.getKey());
            }
        }
        return positions;
    }

    /**
     * Retourne la Map interne (utile pour la Vue).
     *
     * @return Map des cases
     */
    public Map<Coordonner, Pion> getCases() {

        return cases;
    }
}

