package cstjean.mobile.travail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe représentant le damier du jeu de dames (10x10).
 * Contient la position de chaque pion sur le plateau.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Damier {

    /** Map contenant les cases du damier et leur pion associé. */
    private final Map<Coordonner, Pion> cases = new HashMap<>();

    /**
     * Initialise le damier avec 20 pions noirs et 20 pions blancs.
     *
     * <p>x = colonnes et y = lignes.</p>
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
     * Retourne la Map interne représentant les cases du damier.
     *
     * @return la Map des cases
     */
    public Map<Coordonner, Pion> getCases() {
        return cases;
    }

    /**
     * Retourne le pion à une position donnée.
     *
     * @param coordonner la coordonnée à vérifier
     * @return le pion à cette position ou null s'il n'y en a pas
     */
    public Pion getPion(Coordonner coordonner) {
        return cases.get(coordonner);
    }

    /**
     * Ajoute un pion à une position donnée.
     *
     * @param coordonner la coordonnée du pion
     * @param pion le pion à ajouter
     */
    public void ajouterPion(Coordonner coordonner, Pion pion) {
        cases.put(coordonner, pion);
    }

    /**
     * Retire le pion d'une position donnée.
     *
     * @param coordonner la coordonnée à vider
     */
    public void retirerPion(Coordonner coordonner) {
        cases.put(coordonner, null);
    }

    /**
     * Retourne le nombre total de pions sur le damier.
     *
     * @return le nombre de pions
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
     * Retourne le nombre de pions noirs sur le damier.
     *
     * @return le nombre de pions noirs
     */
    public int getNbPionsNoir() {
        int count = 0;
        for (Pion pion : cases.values()) {
            if (pion != null && pion.getCouleur() == Pion.Couleur.Noir) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retourne le nombre de pions blancs sur le damier.
     *
     * @return le nombre de pions blancs
     */
    public int getNbPionsBlanc() {
        int count = 0;
        for (Pion pion : cases.values()) {
            if (pion != null && pion.getCouleur() == Pion.Couleur.Blanc) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retourne le nombre de pions noirs immobiles sur le damier.
     *
     * @return le nombre de pions noirs immobiles
     */
    public int getNbImmobilesNoir() {
        int count = 0;
        for (Pion pion : cases.values()) {
            if (pion != null && pion.getCouleur() == Pion.Couleur.Noir && !pion.getDeplacable()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retourne le nombre de pions blancs immobiles sur le damier.
     *
     * @return le nombre de pions blancs immobiles
     */
    public int getNbImmobilesBlanc() {
        int count = 0;
        for (Pion pion : cases.values()) {
            if (pion != null && pion.getCouleur() == Pion.Couleur.Blanc && !pion.getDeplacable()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retourne toutes les positions occupées par des pions d'une couleur donnée.
     *
     * @param couleur la couleur des pions à rechercher
     * @return une liste des positions contenant des pions de cette couleur
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
}

