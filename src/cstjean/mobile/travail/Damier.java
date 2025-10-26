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

    private final Map<String, Pion> cases = new HashMap<>();

    /**
     * Initialise le damier avec 20 pions noirs et 20 pions blancs.
     */
    public void initialiser() {
        cases.clear();
        for (int i = 0; i <= 50; i++) {
            if(i <= 5) {
                cases.put("A" + Integer.toString(i), new Pion(Pion.Couleur.Noir));
            }
            else if(i <= 10) {
                cases.put("B" + Integer.toString(i), new Pion(Pion.Couleur.Noir));
            }
            else if(i <= 15 && i > 10) {
                cases.put("C" + Integer.toString(i), new Pion(Pion.Couleur.Noir));
            }
            else if(i <= 20 && i > 15) {
                cases.put("D" + Integer.toString(i), new Pion(Pion.Couleur.Noir));
            }
            else if(i <= 35 && i > 20) {
                cases.put("E" + Integer.toString(i), new Pion(Pion.Couleur.Blanc));
            }
            else if(i <= 40 && i > 35) {
                cases.put("F" + Integer.toString(i), new Pion(Pion.Couleur.Blanc));
            }
            else if(i <= 45  && i > 40) {
                cases.put("G" + Integer.toString(i), new Pion(Pion.Couleur.Blanc));
            }
            else if(i <= 50  && i > 45) {
                cases.put("H" + Integer.toString(i), new Pion(Pion.Couleur.Blanc));
            }

        }
        for (int i = 31; i <= 50; i++) {
            cases.put(i, new Pion(Pion.Couleur.Blanc));
        }
    }


    /**
     * Retourne le pion à une position donnée.
     *
     * @param position Position (1 à 50)
     * @return Pion à cette position ou null
     */
    public Pion getPion(String position) {
        return cases.get(position);
    }

    /**
     * Ajoute un pion à une position.
     *
     * @param position Position
     * @param pion     Pion à ajouter
     */
    public void ajouterPion(String position, Pion pion) {
        cases.put(position, pion);
    }

    /**
     * Retire le pion d'une position.
     *
     * @param position Position à vider
     */
    public void retirerPion(String position) {
        cases.put(position, null);
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
    public List<String> getPositionsAvecCouleur(Pion.Couleur couleur) {
        List<String> positions = new ArrayList<>();
        for (Map.Entry<String, Pion> entry : cases.entrySet()) {
            Pion pion = entry.getValue();
            if (pion != null && pion.getCouleur() == couleur) {
                positions.add();
            }
        }
        return positions;
    }

    /**
     * Retourne la Map interne (utile pour la Vue).
     *
     * @return Map des cases
     */
    public Map<String, Pion> getCases() {

        return cases;
    }
}

