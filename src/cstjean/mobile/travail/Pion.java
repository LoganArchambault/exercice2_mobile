package cstjean.mobile.travail;

public class Pion {
    private final String couleur;

    public Pion(String couleur)
    {
        this.couleur = couleur;
    }

    public Pion()
    {
        couleur = "Blanc";
    }

    public String GetCouleur() {
        return couleur;
    }
}
