package cstjean.mobile.travail;

import java.util.ArrayList;
import java.util.List;

public class Damier {

    private final List<Pion> damier;
    public Damier() {
        this.damier = new ArrayList<>();
    }

    public void ajouterPion(int index, Pion pion) {
        pion.add(index);
    }
}
