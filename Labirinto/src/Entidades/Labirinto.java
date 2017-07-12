package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Labirinto {
    
    public final int length = 7;
    private final Vertice[][] matriz;
    private final Grafo grafo;
    
    
    public Labirinto() {
        matriz = new Vertice[length][length];
        grafo = new Grafo();
      
        grafo.setVertices(criarVertices());
        
        setVerticesAdjacentes();
    }
    
    private List<Vertice> criarVertices() {
        List<Vertice> lista = new ArrayList<>();        
        for(int l = 0; l < length; l++) {
            for(int c = 0; c < length; c++) {
                matriz[l][c] = new Vertice(0);
                lista.add(matriz[l][c]);
            }
        }
        return lista;
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
        
        // Vértice de cima
        if(linha >= 1)
            adj.add(matriz[linha - 1][coluna]);
       
        // Vértice de baixo
        if(linha < matriz.length - 1)
            adj.add(matriz[linha + 1][coluna]);
        
        // Vértice da esquerda
        if(coluna >= 1)
            adj.add(matriz[linha][coluna - 1]);
        
        // Vérice da Direita
        if(coluna < matriz.length - 1)
            adj.add(matriz[linha][coluna + 1]);
        
        return adj;
    }   
            
    public void criarCaminho() {
        grafo.dfs();
    }
    
    @Override
    public String toString() {
        String str = "";
        
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                int aux = matriz[l][c].getValor();
                
                if(aux == 0) 
                    str = str + "  |";
                else if(aux < 10)
                    str = str + aux + " |";
                else 
                    str = str + aux + "|";
            }            
            str = str + "\n";            
        }        
        
        return str;
    }
    
}
