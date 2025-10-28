package cstjean.mobile.travail;

/**
 * Classe représentant une partie de jeu de dames internationales.
 * Gère les joueurs, le damier et la logique de tour.
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Partie {

    /** Premier joueur (pions noirs). */
    private Joueur joueurNoir;

    /** Deuxième joueur (pions blancs). */
    private Joueur joueurBlanc;

    /** Joueur dont c’est le tour. */
    private Joueur joueurActuel;

    /** Damier du jeu. */
    private Damier damier;

    /**
     * Constructeur par défaut.
     * Initialise les joueurs et le damier.
     */
    public Partie() {
        joueurBlanc = new Joueur("Joueur 1", Pion.Couleur.Blanc);
        joueurNoir = new Joueur("Joueur 2", Pion.Couleur.Noir);
        damier = new Damier();
        initPartie();
    }

    /** Initialise la partie avec le joueur blanc et un damier vierge. */
    public void initPartie() {
        joueurActuel = joueurBlanc;
        damier.initialiser();
    }

    /**
     * Retourne le damier du jeu.
     *
     * @return le damier actuel
     */
    public Damier getDamier() {
        return damier;
    }

    /**
     * Retourne le joueur actuellement actif.
     *
     * @return le joueur dont c’est le tour
     */
    public Joueur getJoueurActuel() {
        return joueurActuel;
    }

    /** Change le joueur actif (passe au tour de l’autre joueur). */
    public void changerJoueur() {
        joueurActuel = (joueurActuel == joueurNoir) ? joueurBlanc : joueurNoir;
    }

    /**
     * Vérifie si un déplacement simple est autorisé.
     *
     * @param pion le pion à déplacer
     * @param destination la case de destination
     * @param positionActuelle la position actuelle du pion
     * @return true si le déplacement est permis, false sinon
     */
    public boolean droitDeplacement(Pion pion, Coordonner destination, Coordonner positionActuelle) {
        if (damier.getPion(destination) == null && damier.getPion(positionActuelle) != null) {
            if (pion.getCouleur() == Pion.Couleur.Noir) {

                if (!(damier.getPion(positionActuelle) instanceof Dame)) {
                    boolean diagGauche = positionActuelle.getX() + 1 == destination.getX() && positionActuelle.getY() - 1 == destination.getY();
                    boolean diagDroite = positionActuelle.getX() + 1 == destination.getX() && positionActuelle.getY() + 1 == destination.getY();
                    return diagGauche || diagDroite;
                } else {
                    int xd = destination.getX() - positionActuelle.getX();
                    int yd = destination.getY() - positionActuelle.getY();
                    int dirX = Integer.signum(xd);
                    int dirY = Integer.signum(yd);

                    if (Math.abs(xd) == Math.abs(yd)) {
                        for (int i = positionActuelle.getX() + dirX, j = positionActuelle.getY() + dirY;
                             i != destination.getX() && j != destination.getY();
                             i += dirX, j += dirY) {
                            Coordonner c = new Coordonner(i, j);
                            Pion p = getDamier().getPion(c);
                            if (p != null) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Change la position du pion lors d'un déplacement.
     *
     * @param pion le pion à déplacer
     * @param destination la destination du pion
     * @param positionActuelle la position actuelle du pion
     * @return true si le déplacement est réussi, false sinon
     */
    public boolean actionDeplacement(Pion pion, Coordonner destination, Coordonner positionActuelle) {
        if (droitDeplacement(pion, destination, positionActuelle)) {
            damier.retirerPion(positionActuelle);

            if (!checkPromotion(pion, destination, positionActuelle)) {
                damier.ajouterPion(destination, pion);
            }

            if (checkFinPartie()) {
                initPartie();
            }

            changerJoueur();
            return true;
        }
        return false;
    }

    /**
     * Détermine si une capture est possible pour un pion donné.
     *
     * @param pion le pion qui attaque
     * @param destination la destination finale du pion
     * @param positionActuelle la position actuelle du pion
     */
    public void droitDeCapture(Pion pion, Coordonner destination, Coordonner positionActuelle) {

        Coordonner pionCapturer = new Coordonner(
                destination.getX() - positionActuelle.getY(),
                destination.getY() - positionActuelle.getX());

        if (damier.getPion(destination) == null && damier.getPion(positionActuelle) != null) {
            if (damier.getPion(pionCapturer) != null && !(damier.getPion(pionCapturer) instanceof Dame)) {
                if (pion.getCouleur() != damier.getPion(pionCapturer).getCouleur()) {
                    actionDeCapture(pion, positionActuelle, destination, pionCapturer);
                }
            } else {
                int xd = destination.getX() - positionActuelle.getX();
                int yd = destination.getY() - positionActuelle.getY();
                int dirX = Integer.signum(xd);
                int dirY = Integer.signum(yd);
                if (Math.abs(xd) == Math.abs(yd)) {
                    int compteur = 0;
                    boolean pionAvant = false;
                    for (int i = positionActuelle.getX(); i < destination.getX(); i += dirX) {
                        for (int j = positionActuelle.getY(); j < destination.getY(); j += dirY) {
                            Coordonner c = new Coordonner(i, j);
                            Pion p = getDamier().getPion(c);
                            if (p != null && p.getCouleur() == pion.getCouleur()) {
                                break;
                            }
                            if (p == null && pionAvant) {
                                pionAvant = false;
                            } else if (p != null) {
                                if (pionAvant || compteur == 1) {
                                    break;
                                }
                                pionCapturer.setCoordonner(new Coordonner(i, j));
                                pionAvant = true;
                                compteur++;
                            }
                        }
                    }
                    actionDeCapture(pion, positionActuelle, destination, pionCapturer);
                }
            }
        }
    }

    /**
     * Exécute la capture d'un pion adverse.
     *
     * @param pion le pion attaquant
     * @param positionActuelle la position actuelle du pion
     * @param destination la destination finale du pion
     * @param pionCapturer la position du pion capturé
     */
    public void actionDeCapture(
            Pion pion, Coordonner positionActuelle, Coordonner destination, Coordonner pionCapturer) {
        damier.ajouterPion(destination, pion);
        damier.retirerPion(pionCapturer);
        damier.retirerPion(positionActuelle);
    }

    /**
     * Vérifie si un pion doit être promu en dame.
     *
     * @param pion le pion à vérifier
     * @param destination la destination du pion
     * @param positionActuelle la position actuelle du pion
     * @return true si promotion effectuée, sinon false
     */
    public boolean checkPromotion(Pion pion, Coordonner destination, Coordonner positionActuelle) {
        if (pion.getCouleur() == Pion.Couleur.Blanc && destination.getX() == 0) {
            damier.ajouterPion(destination, new Dame(Pion.Couleur.Blanc));
            return true;
        } else if (pion.getCouleur() == Pion.Couleur.Noir && destination.getX() == 9) {
            damier.ajouterPion(destination, new Dame(Pion.Couleur.Noir));
            return true;
        }
        return false;
    }

    /**
     * Vérifie si la partie est terminée (plus de pions ou tous bloqués).
     *
     * @return true si la partie est finie, false sinon
     */
    public boolean checkFinPartie() {
        int pionsNoir = damier.getNbPionsNoir();
        int pionsBlanc = damier.getNbPionsBlanc();

        int immobilesNoir = damier.getNbImmobilesNoir();
        int immobilesBlanc = damier.getNbImmobilesBlanc();

        return (pionsNoir == 0 || pionsNoir == immobilesNoir)
                || (pionsBlanc == 0 || pionsBlanc == immobilesBlanc);
    }
}

