package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

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
    
    private void setVerticesAdjacentes() {
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                matriz[l][c].setAdj(getAdjByPos(new Point(l, c)));
            }
        }
    }
    
    private List<Vertice> getAdjByPos(Point p) {
        List<Vertice> adj = new ArrayList<>();
        
        // Vértice de cima
        if(p.x >= 1) 
            adj.add(matriz[p.x - 1][p.y]);
       
        // Vértice de baixo
        if(p.x < matriz.length - 1) 
            adj.add(matriz[p.x + 1][p.y]);
        
        // Vértice da esquerda
        if(p.y >= 1) 
            adj.add(matriz[p.x][p.y - 1]);
        
        // Vérice da Direita
        if(p.y < matriz.length - 1)
            adj.add(matriz[p.x][p.y + 1]);
        
        return adj;
    }   
            
    public void criarCaminho() {
        grafo.dfs();
    }
    
    public Point getCoordenada(Vertice u) {
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                if(matriz.equals(u))
                    return new Point(l, c);
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        String labirinto = "";
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                int aux = matriz[l][c].getValor();
                          
                if(aux == 0)                   
                    labirinto = labirinto + "  |";
                else if(aux < 10)
                    labirinto = labirinto + aux + " |";
                else 
                    labirinto = labirinto + aux + "|";
            }            
            labirinto = labirinto + "\n";            
        }        
        
        return labirinto;
    }
    
}
