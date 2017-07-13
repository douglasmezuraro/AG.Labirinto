package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {    
    
    public final int infinito = -1;
    private List<Aresta> arestas;
    private List<Vertice> vertices;    
    int d;

    Grafo() {
        arestas = new ArrayList<>();
        vertices = new ArrayList<>();
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
        
        d = 0;
        
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
                    d++;
                    v.setValor(d);
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
    
    public void bfs() {
        Collections.shuffle(vertices);
        bfs(vertices.get(0));
    }
    
    private void bfs(Vertice s) {
        for(Vertice v: vertices) {
            if(!v.equals(v)) {
                v.setD(infinito);
                v.setAntecessor(null);
                v.setCor(Cor.Branco);                
            }            
        }
        
        s.setD(0);
        s.setAntecessor(null);
        s.setCor(Cor.Cinza);
        
        Queue<Vertice> q = new LinkedList<>();        
        q.add(s);
        
        while(!q.isEmpty()) {
            Vertice u = q.remove();
            
            for(Vertice v: u.getAdj()) {
                if(v.getCor() == Cor.Branco) {
                    v.setD(u.getD() + 1);
                    v.setAntecessor(u);
                    v.setCor(Cor.Cinza);
                    q.add(v);
                }
            }
            
            u.setCor(Cor.Preto);
        }                
    }

}
