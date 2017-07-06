package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Vertice {
    
    String nome;
    List<Vertice> adj;
    
    Vertice(String nome) {
        this.nome = nome;
        this.adj = new ArrayList<>();
    }
    
    public void add(Vertice v) {
        this.adj.add(v);
    }
        
}
