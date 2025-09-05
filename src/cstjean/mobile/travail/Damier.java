package cstjean.mobile.travail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Damier {

    private List<Pion> damier;
    public Damier() {
        this.damier = new LinkedList<Pion>();
    }

    public void ajouterPion(int index,Pion pion) {
        damier.add(index,pion);
    }

    public void initializeDamier()
    {
        for(int i = 0; i <= 50;i++)
        {
            damier.set(i,null);
        }
    }

    public List<Pion> getDamier() {
        return damier;
    }
    public Pion checkDamier(int index) {
        return getDamier().get(index);
    }
}
