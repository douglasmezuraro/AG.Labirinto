package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Point;

public class Labirinto {
    
    private enum Direcao {
        cima,
        baixo,
        direita,
        esquerda;
    }
    
    private final Vertice[][] matriz;
    private final Grafo grafo;
    
    public Labirinto(int tamanho) {
        matriz = new Vertice[tamanho][tamanho];
        grafo = new Grafo();
      
        grafo.setVertices(criarVertices());
        
        addAdjacentes();
    }
    
    public void criarCaminho() {
        grafo.dfs();
    }
    
    private List<Vertice> criarVertices() {
        List<Vertice> lista = new ArrayList<>();        
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                matriz[l][c] = new Vertice(0);
                lista.add(matriz[l][c]);
            }
        }
        return lista;
    }
    
    private void addAdjacentes() {
        for(int l = 0; l < matriz.length; l++) 
            for(int c = 0; c < matriz.length; c++) 
                matriz[l][c].setAdj(getAdjacentes(matriz[l][c]));
    }
    
    private List<Vertice> getAdjacentes(Vertice u) {
        List<Vertice> adj = new ArrayList<>();
        
        for(Direcao direcao: Direcao.values()) {
            Vertice v = getVerticeByDirecao(u, direcao);
            
            if(v != null)
               adj.add(v);        
        }
        
        Collections.shuffle(adj);
        return adj;        
    }
                
    private Point getPosicaoVertice(Vertice u) {
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                if(matriz[l][c].equals(u))
                    return new Point(l, c);
            }
        }
        return null;
    }
    
    private Vertice getVerticeByPosicao(Point p){
        if(posicaoExiste(p))
            return matriz[p.x][p.y];
        else
            return null;
    }
    
    private boolean posicaoExiste(Point p) {
        return (p.x >= 0) 
            && (p.y >= 0)
            && (p.x < matriz.length)
            && (p.y < matriz.length);
    }
      
    private Vertice getVerticeByDirecao(Vertice u, Direcao direcao) {
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
            return getVerticeByPosicao(destino);
        }
        else return null;
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
