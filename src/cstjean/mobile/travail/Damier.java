package cstjean.mobile.travail;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Vincent Szwec-Chevrier
 * @author Logan Archambault Vallee
 * @author William Lizotte
 */
public class Damier {

    private final List<Pion> pions = new ArrayList<>();
    public Damier() {}

    public void ajouterPion(int index, Pion pion) {
        pions.add(index, pion);
    }
}
