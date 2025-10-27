package cstjean.mobile.travail;

/**
 * Classe Vue — responsable uniquement de l'affichage du damier et des pions.
 * Principe de responsabilité unique (SRP).
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
                    Pion pion = damier.getPion(new int[] {ligne, col});
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
}
