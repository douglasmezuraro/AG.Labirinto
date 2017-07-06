package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Grafo {
    
    public List<Aresta> a;
    public List<Vertice> v;
    
    Grafo() {
        this.a = new ArrayList<>();
        this.v = new ArrayList<>();
    }
    
    Vertice addVertica(String nome) {
        Vertice v = new Vertice(nome);
        this.v.add(v);
        return v;
    }
    
    Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta a = new Aresta(origem, destino);
        this.a.add(a);
        return a;
    }
}
