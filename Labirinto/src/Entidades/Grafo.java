package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
                if(v.celula() == Celula.caminho) 
                    return false;        
        return true;
    }
    
    public void bfs(Vertice s) {
        for(Vertice v: vertices) {
            if(!v.equals(s)) {
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
                    if(v.celula() == Celula.caminho) {
                        v.d = u.d + 1;
                        v.antecessor = u;
                        v.cor = Cor.Cinza;
                        q.add(v);
                    }
                }
            }            
            u.cor = Cor.Preto;
        }                
    }
    
    public String getCaminho(Vertice origem, Vertice destino) {
        final String begin = "{",
                       end = "}",
                 separator = ", ";
        
        Stack<Integer> pilha = new Stack();
        acharCaminho(pilha, origem, destino);
        Collections.reverse(pilha);
      
        String aux = begin;
        
        while(!pilha.isEmpty()) {
            if(aux.equals(begin))
                aux = aux + pilha.pop();
            else
               aux = aux + separator + pilha.pop();
        }
        
        aux = aux + end;
        
        return aux;
    }
    
    private void acharCaminho(Stack pilha, Vertice origem, Vertice destino) {
        if(origem == destino) 
            pilha.add(destino.valor);
        else if(destino.antecessor == null)
            pilha.add(-1);
        else {
            acharCaminho(pilha, origem, destino.antecessor);
            pilha.add(destino.valor);
        }  
    }
}
