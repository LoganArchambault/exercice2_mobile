package cstjean.mobile.travail;

/**
 * Classe représentant une partie de jeu de dames.
 * Gère les deux joueurs, le damier, et le tour en cours.
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

    /**
     * Retourne le joueur noir.
     *
     * @return le joueur noir
     */
    public Joueur getJoueurNoir() {
        return joueurNoir;
    }

    /**
     * Retourne le joueur blanc.
     *
     * @return le joueur blanc
     */
    public Joueur getJoueurBlanc() {
        return joueurBlanc;
    }

    /**
     * Change le joueur actif (passe au tour de l’autre joueur).
     */
    public void changerJoueur() {
        joueurActuel = (joueurActuel == joueurNoir) ? joueurBlanc : joueurNoir;
    }

    /**
     * Decide si un pion peut bouger en fonctions de si : il y as une piece sur la case destination, une piece sur la case actuelle.
     * @param p pions a deplacer.
     * @param destination potientiel destination du pion.
     * @param positionActuelle postion du pion.
     * @return si oui ou non il peut etre deplacer.
     */
    public boolean DroitDeplacement(Pion p, Coordonner destination, Coordonner positionActuelle) {
        if (damier.getPion(destination) == null && damier.getPion(positionActuelle) != null) {
            if (p.getCouleur() == Pion.Couleur.Noir) {

                if (!(damier.getPion(positionActuelle) instanceof Dame)) {
                    if(positionActuelle.getX() + 1 == destination.getX() && positionActuelle.getY() - 1 == destination.getY() || positionActuelle.getX() + 1 == destination.getX() && positionActuelle.getY() + 1 == destination.getY()){
                        return true;
                    }
                } else {
                    int xDeDiagonal = destination.getX() - positionActuelle.getX();
                    int yDeDiagonal = destination.getY() - positionActuelle.getY();
                    int dirX = Integer.signum(xDeDiagonal);
                    int dirY = Integer.signum(yDeDiagonal);
                    if (xDeDiagonal == yDeDiagonal) {
                        for (int i = positionActuelle.getX(); i < destination.getX(); i += dirX) {
                            for (int j = positionActuelle.getY(); j < destination.getY(); j += dirY) {
                                Coordonner coordonner = new Coordonner(i, j);
                                if (getDamier().getPion(coordonner).getCouleur() == p.getCouleur()) {
                                    return false;
                                }
                                if (getDamier().getPion(coordonner) != null) {
                                    return false;
                                }
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
     *Change la position du pion lors d'un deplacement.
     *
     * @param p pion a deplacer.
     * @param destination destination du pion.
     * @param   positionActuelle la postition actuelle du pion a deplacer.
     * @return retourne un Boolean pour facilite la gestion d'erreur de la vue avec android studio.
     */
    public boolean actionDeplacement(Pion p, Coordonner destination, Coordonner positionActuelle) {
        if (DroitDeplacement(p, destination, positionActuelle)) {
            damier.retirerPion(positionActuelle);

            if (!checkPromotion(p, destination, positionActuelle)) {
                damier.ajouterPion(destination, p);
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
     * Decide si oui ou non la capture peut arriver.
     * @param p le pions qui attaque.
     * @param destination la destinations final de l'attaqueur.
     * @param positionActuelle la position du pion qui attaque.
     * @return si oui ou non la capture peut arriver.
     */
    public void DroitDeCapture(Pion p, Coordonner destination, Coordonner positionActuelle) {

        Coordonner pionACapturer = new Coordonner(destination.getX() - positionActuelle.getY(), destination.getY() - positionActuelle.getX());

        if (damier.getPion(destination) == null && damier.getPion(positionActuelle) != null) {
            if (damier.getPion(pionACapturer) != null && !(damier.getPion(pionACapturer) instanceof Dame)) {
                if (p.getCouleur() != damier.getPion(pionACapturer).getCouleur()) {
                    ActionDeCapture (p,  positionActuelle, destination, pionACapturer);
                }
            } else {
                int xDeDiagonal = destination.getX() - positionActuelle.getX();
                int yDeDiagonal = destination.getY() - positionActuelle.getY();
                int dirX = Integer.signum(xDeDiagonal);
                int dirY = Integer.signum(yDeDiagonal);
                if (xDeDiagonal == yDeDiagonal) {
                    int conteur = 0;
                    boolean pionAvant = false;
                    for (int i = positionActuelle.getX(); i < destination.getX(); i += dirX) {
                        for (int j = positionActuelle.getY(); j < destination.getY(); j += dirY) {
                            Coordonner coordonner = new Coordonner(i, j);
                            if (getDamier().getPion(coordonner).getCouleur() == p.getCouleur()) {
                                break;
                            }
                            if (getDamier().getPion(coordonner) == null && pionAvant) {
                                pionAvant = false;
                            } else if (getDamier().getPion(coordonner) != null) {
                                if (pionAvant) {
                                    break;
                                }
                                pionACapturer.setCoordonner(new Coordonner(i, j));
                                pionAvant = true;
                                conteur++;
                            }
                        }
                    }
                    ActionDeCapture (p,  positionActuelle,  destination,  pionACapturer);
                }
            }
        }
    }

    public boolean ActionDeCapture (Pion p, Coordonner positionActuelle, Coordonner destination, Coordonner pionACapturer){
        damier.ajouterPion(destination, p);
        damier.retirerPion(pionACapturer);
        damier.retirerPion(positionActuelle);
        return false;
    }

    public boolean checkPromotion(Pion pion, Coordonner destination, Coordonner positionActuelle) {
        if (pion.getCouleur() == Pion.Couleur.Blanc && destination.getX() == 0) {
            damier.ajouterPion(destination, new Dame(Pion.Couleur.Blanc));
            return true;
        } else if (pion.getCouleur() == Pion.Couleur.Noir && destination.getX() == 9) {
            damier.ajouterPion(destination, new Dame(Pion.Couleur.Noir));
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkFinPartie() {
        int pionsNoir = damier.getNbPionsNoir();
        int pionsBlanc = damier.getNbPionsBlanc();

        int immobilesNoir = damier.getNbImmobilesNoir();
        int immobilesBlanc = damier.getNbImmobilesBlanc();

        if (pionsNoir == 0 || pionsNoir == immobilesNoir) {
            System.console().printf("Victoire Joueur Blanc");
            return true;
        } else if (pionsBlanc == 0 || pionsBlanc == immobilesBlanc) {
            
            return true;
        } else {

            return false;
        }
    }

}

