package cstjean.mobile.travail;

/**
 * Classe {@code Vue} — responsable uniquement de l'affichage du damier et des pions.
 * 
 * <p>
 *     Respecte le principe de responsabilité unique (SRP).
 * </p>
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Vue {

    /**
     * Génère la représentation textuelle du damier sous forme de chaîne.
     *
     * @param damier le damier à représenter
     * @return la chaîne représentant le damier
     */
    public String genererAffichage(Damier damier) {
        StringBuilder sb = new StringBuilder();
        int caseNum = 1; // cases jouables 1 à 50

        for (int ligne = 0; ligne < 10; ligne++) {
            for (int col = 0; col < 10; col++) {
                if ((ligne + col) % 2 == 1) { // case jouable
                    Pion pion = damier.getPion(new Coordonner(ligne, col));
                    sb.append(pion == null ? "-" : pion.getRepresentation());
                } else {
                    sb.append("-");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Affiche directement le damier dans la console.
     *
     * @param damier le damier à afficher
     */
    public void afficherConsole(Damier damier) {
        System.out.print(genererAffichage(damier));
    }

    /**
     * Affiche le joueur gagnant d'apres leur couleur.
     *
     * @param couleur du joueur gagnant
     */
    public void afficherGagnant(Pion.Couleur couleur) {
        if (couleur == Pion.Couleur.Noir) {
            System.console().printf("Victoire Joueur Noir");
        }

        if (couleur == Pion.Couleur.Blanc) {
            System.console().printf("Victoire Joueur Blanc");
        }
    }
}
