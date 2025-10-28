package cstjean.mobile.travail;

/**
 * Classe représentant une dame (pion promu).
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Dame extends Pion {

    /**
     * Constructeur d'une dame.
     *
     * @param couleur Couleur de la dame
     */
    public Dame(Couleur couleur) {
        super(couleur);
    }

    /**
     * Retourne la représentation textuelle de la dame.
     * Utilise une majuscule pour les dames noires et une minuscule pour les dames blanches.
     *
     * @return "D" si la dame est noire, "d" si elle est blanche
     */
    @Override
    public String getRepresentation() {
        return (getCouleur() == Couleur.Noir) ? "D" : "d";
    }
}
