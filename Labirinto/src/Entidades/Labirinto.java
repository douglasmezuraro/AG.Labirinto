package Entidades;

import java.util.Random;

public class Labirinto {
    
    public final int length = 50;
    private int ultimoValor;
    private Vertice[][] matriz;
    private Vertice inicio;

    Labirinto() {
        matriz = new Vertice[length][length];        
        inicio = addVerticeInicial();
        ultimoValor = inicio.getValor();
    }
    
    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }                
    
    Vertice addVerticeInicial() {
        Vertice v = new Vertice(1);
        Random r = new Random();
        
        int i = r.nextInt(length),
            j = r.nextInt(length);
        
        matriz[i][j] = v;
        
        return v;
    }

    public Vertice[][] getMatriz() {
        return matriz;
    }

    public int getUltimoValor() {
        return ultimoValor;
    }

    public void setUltimoValor(int ultimoValor) {
        this.ultimoValor = ultimoValor;
    }
    
}
