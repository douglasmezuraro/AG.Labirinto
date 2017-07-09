package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Labirinto {
    
    public final int length = 5;
    private final Vertice[][] matriz;
    private Vertice inicio;
    
    public Labirinto() {
        matriz = new Vertice[length][length];   
        criarVertices();
        setVerticesAdjacentes();
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
    
    private void setVerticesAdjacentes() {
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                matriz[l][c].setAdj(getAdjByPos(l, c));
            }
        }
    }
    
    private List<Vertice> getAdjByPos(int linha, int coluna) {
        
        List<Vertice> adj = new ArrayList<>();
        
        // cima
        if(linha >= 1)
            adj.add(matriz[linha - 1][coluna]);
       
        // baixo
        if(linha < matriz.length - 1)
            adj.add(matriz[linha + 1][coluna]);
        
        // esq
        if(coluna >= 1)
            adj.add(matriz[linha][coluna - 1]);
        
        // dir
        if(coluna < matriz.length - 1)
            adj.add(matriz[linha][coluna + 1]);
        
        return adj;
    }
    
    @Override
    public String toString() {
        String str = "";
        
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) 
                str = str + matriz[l][c].getValor() + "|";
            
            str = str + "\n";
        }
        
        return str;
    }
    
}
