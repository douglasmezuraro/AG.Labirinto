package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Grafo {
    
    private List<Aresta> arestas;
    private List<Vertice> vertices;
    private int valor;

    Grafo() {
        arestas = new ArrayList<>();
        vertices = new ArrayList<>();
        valor = 0;
    }
    
    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    Vertice addVertice(int valor) {
        Vertice v = new Vertice(valor);
        vertices.add(v);
        return v;
    }
    
    Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta a = new Aresta(origem, destino);
        arestas.add(a);
        return a;
    }
    
    // Algoritmos
    
    public void dfs() {
        for(Vertice u: vertices) {
            u.setCor(Cor.Branco);
            u.setAntecessor(null);
        }
        
        valor = 0;
        
        for(Vertice v: vertices) {
            if(v.getCor() == Cor.Branco)
                dfsVisit(v);
        }
    }
    
    private void dfsVisit(Vertice u) {
        u.setCor(Cor.Cinza);
        
        for(Vertice v: u.getAdj()) {
            if(v.getCor() == Cor.Branco) {
                v.setAntecessor(u); 

                if(validarJogada(v)) {
                    valor++;
                    v.setValor(valor);
                    dfsVisit(v);
                }
            }               
        }
    }
    
    private Boolean validarJogada(Vertice u) {
        for(Vertice v: u.getAdj()) 
            if(!v.equals(u.getAntecessor())) 
                if (v.getValor() > 0) 
                    return false;        
        return true;
    }

}
