package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Point;

public class Labirinto {
   
    private final Vertice[][] matriz;
    private final Grafo grafo;
    
    public Labirinto(int tamanho) {
        matriz = new Vertice[tamanho][tamanho];
        grafo = new Grafo();
        grafo.vertices = criarVertices();
        
        addAdjacentes();
    }
    
    public void dfs() {
        grafo.dfs();
    }
    
    public void bfs(int valor) {
        bfs(getVertice(valor));
    }
    
    private void bfs(Vertice u) {
        grafo.bfs(u);
    }
    
    private List<Vertice> criarVertices() {
        List<Vertice> lista = new ArrayList<>();        
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                matriz[l][c] = new Vertice();
                lista.add(matriz[l][c]);
            }
        }
        return lista;
    }
    
    private void addAdjacentes() {
        for(int l = 0; l < matriz.length; l++) 
            for(int c = 0; c < matriz.length; c++) 
                matriz[l][c].adj = getAdjacentes(matriz[l][c]);
    }
    
    private List<Vertice> getAdjacentes(Vertice u) {
        List<Vertice> adj = new ArrayList<>();
        
        for(Direcao direcao: Direcao.values()) {
            Vertice v = getVertice(u, direcao);
            
            if(v != null)
               adj.add(v);        
        }
        
        Collections.shuffle(adj);
        return adj;        
    }
                
    private Point getPosicaoVertice(Vertice u) {
        for(int l = 0; l < matriz.length; l++) 
            for(int c = 0; c < matriz.length; c++) 
                if(matriz[l][c].equals(u))
                    return new Point(l, c);          
        return null;
    }
    
    private boolean posicaoExiste(Point p) {
        return (p.x >= 0) 
            && (p.y >= 0)
            && (p.x < matriz.length)
            && (p.y < matriz.length);
    }
    
    private Vertice getVertice(Point p){
        if(posicaoExiste(p))
            return matriz[p.x][p.y];
        else
            return null;
    }
        
    private Vertice getVertice(Vertice u, Direcao direcao) {
        Point origem = getPosicaoVertice(u),
              destino = null;
        
        if(origem != null) {
            switch(direcao) {
                case cima: 
                    destino = new Point(origem.x - 1, origem.y);
                    break;
                case baixo:
                    destino = new Point(origem.x + 1, origem.y);
                    break;
                case direita:
                    destino = new Point(origem.x, origem.y + 1);
                    break;
                case esquerda:
                    destino = new Point(origem.x, origem.y - 1);
                    break;
            }
            return getVertice(destino);
        }
        else return null;
    }
    
    private Vertice getVertice(int valor) {
        for(Vertice u: grafo.vertices) 
            if(u.valor == valor) 
                return u;
             
        return null;
    }
    
    @Override
    public String toString() {
        String labirinto = "";
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                int aux = matriz[l][c].valor;
                          
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
    
    public String getCaminho(int origem, int destino) {
        return getCaminho(getVertice(origem), getVertice(destino));
    }
    
    private String getCaminho(Vertice origem, Vertice destino) {
        return grafo.getCaminho(origem, destino);
    }
}


