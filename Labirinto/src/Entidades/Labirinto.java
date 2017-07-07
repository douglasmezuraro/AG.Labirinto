package Entidades;

public class Labirinto {
    public Vertice[][] matriz;
    
    Labirinto(int length) {
        this.matriz = new Vertice[length][length];
    }
}
