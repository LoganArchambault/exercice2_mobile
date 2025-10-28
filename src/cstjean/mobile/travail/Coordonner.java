package cstjean.mobile.travail;

public class Coordonner {
    private int x;
    private int y;

    public Coordonner(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Coordonner coordonner;

    public Coordonner getCoordonner() {
        return coordonner;
    }

    public void setCoordonner(Coordonner coordonner) {
        this.coordonner = coordonner;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
