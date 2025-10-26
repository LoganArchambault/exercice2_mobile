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

    @Override
    public String getRepresentation() {
        return (getCouleur() == Couleur.Noir) ? "D" : "d";
    }
}
