package cstjean.mobile.travail;

/**
 * Classe représentant une dame (pièce évoluée).
 */
public class Dame extends Piece {

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
