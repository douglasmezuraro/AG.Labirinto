package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {    
    
    public final int infinito = -1;
    public List<Aresta> arestas;
    public List<Vertice> vertices;    
    private int d;

    Grafo() {
        arestas = new ArrayList<>();
        vertices = new ArrayList<>();
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
            u.cor = Cor.Branco;
            u.antecessor = null;
        }
        
        d = 0;
        
        for(Vertice v: vertices) {
            if(v.cor == Cor.Branco)
                dfsVisit(v);
        }
    }
    
    private void dfsVisit(Vertice u) {
        u.cor = Cor.Cinza;
        
        for(Vertice v: u.adj) {
            if(v.cor == Cor.Branco) {
                v.antecessor = u; 

                if(validarJogada(v)) {
                    d++;
                    v.valor = d;
                    dfsVisit(v);
                }
            }               
        }
    }
    
    private Boolean validarJogada(Vertice u) {
        for(Vertice v: u.adj) 
            if(!v.equals(u.antecessor)) 
                if (v.valor > 0) 
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
                v.d = infinito;
                v.antecessor = null;
                v.cor = Cor.Branco;                
            }            
        }
        
        s.d = 0;
        s.antecessor = null;
        s.cor = Cor.Cinza;
        
        Queue<Vertice> q = new LinkedList<>();        
        q.add(s);
        
        while(!q.isEmpty()) {
            Vertice u = q.remove();
            
            for(Vertice v: u.adj) {
                if(v.cor == Cor.Branco) {
                    v.d = u.d + 1;
                    v.antecessor = u;
                    v.cor = Cor.Cinza;
                    q.add(v);
                }
            }
            
            u.cor = Cor.Preto;
        }                
    }

}
