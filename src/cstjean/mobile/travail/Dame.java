package cstjean.mobile.travail;

/**
 * Classe représentant une dame ({@link Pion} évoluée) dans le {@link Damier}.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Dame extends Pion {

    /**
     * Constructeur.
     *
     * @param couleur la couleur de la dame
     */
    public Dame(Couleur couleur) {
        super(couleur);
    }

    /**
     * Retourne la représentation textuelle de la dame.
     *
     * @return "D" pour une dame noire, "d" pour une dame blanche
     */
    @Override
    public String getRepresentation() {
        if (getCouleur() == Couleur.Blanc) {
            return "d";
        } else if (getCouleur() == Couleur.Noir) {
            return "D";
        }
        return "-";
    }
}
