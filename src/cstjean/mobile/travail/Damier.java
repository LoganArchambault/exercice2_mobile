package cstjean.mobile.travail;

import java.util.HashMap;
import java.util.Map;

/**
 * Représente un damier contenant des pièces (pions et dames).
 */
public class Damier {

    /** Les cases jouables du damier, numérotées de 1 à 50. */
    private final Map<Integer, Piece> cases = new HashMap<>();

    /** Constructeur par défaut. */
    public Damier() {}

    /** Retourne la pièce à une case donnée.
     *

     * @param position positon de la piece.
     *
     * @return retourne la piece a la position donner.
     * */

    public Piece getPiece(int position) {
        return cases.get(position);
    }

    /** Ajoute une pièce à une case donnée.

     *  @param position position de la piece a ajouter.

     *  @param piece piece a ajouter.

     * */
    public void ajouterPiece(int position, Piece piece) {
        cases.put(position, piece);
    }

    /** Supprime la pièce d’une case donnée.
     *
     * @param position position de la piece a supprimer.
     * */
    public void retirerPiece(int position) {
        cases.put(position, null);
    }

    /** Retourne le nombre total de pièces présentes sur le damier. */
    public int getNbPieces() {
        int count = 0;
        for (Piece piece : cases.values()) {
            if (piece != null) count++;
        }
        return count;
    }

    /** Initialise le damier avec 4 rangées de pions noirs et 4 rangées de pions blancs */
    public void initialiser() {
        cases.clear();

        // Pions noirs : cases 1 à 20
        for (int i = 1; i <= 20; i++) {
            cases.put(i, new Pion(Piece.Couleur.Noir));
        }

        // Cases vides : 21 à 30
        for (int i = 21; i <= 30; i++) {
            cases.put(i, null);
        }

        // Pions blancs : cases 31 à 50
        for (int i = 31; i <= 50; i++) {
            cases.put(i, new Pion(Piece.Couleur.Blanc));
        }
    }

    /** Génère une représentation texte du damier (10x10). */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int caseNum = 1; // de 1 à 50

        for (int ligne = 0; ligne < 10; ligne++) {
            for (int col = 0; col < 10; col++) {
                if ((ligne + col) % 2 == 1) { // case jouable
                    Piece piece = cases.get(caseNum++);
                    sb.append(piece == null ? "-" : piece.getRepresentation());
                } else {
                    sb.append("-");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
