package Entidades;

import java.util.Random;

public class Labirinto {
    
    public final int length = 50;
    private final Vertice[][] matriz;
    private Vertice inicio;
    
    Labirinto() {
        matriz = new Vertice[length][length];   
        criarVertices();
        setVerticeInicial();
    }
    
    private void criarVertices() {
        for(int i = 0; i < length; i++)
            for(int j = 0; j < length; j++)
                matriz[i][j] = new Vertice(0);
    }
    
    public Vertice getVerticeInicial() {
        return inicio;
    }
    
    private void setVerticeInicial() {
        Random r = new Random();
        
        final int i = r.nextInt(length),
                  j = r.nextInt(length);
        
        matriz[i][j].setValor(1);
        matriz[i][j].setCor(Cor.Cinza);
        
        inicio = matriz[i][j];
    }

    public Vertice[][] getMatriz() {
        return matriz;
    }
    
}
