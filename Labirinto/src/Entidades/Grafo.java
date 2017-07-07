package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Grafo {
    
    private List<Aresta> arestas;
    private List<Vertice> vertices;

    Grafo() {
        this.arestas = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }
    
    public List<Aresta> getArestas() {
        return this.arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public List<Vertice> getVertices() {
        return this.vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    Vertice addVertice(int valor) {
        Vertice v = new Vertice(valor);
        this.vertices.add(v);
        return v;
    }
    
    Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta a = new Aresta(origem, destino);
        this.arestas.add(a);
        return a;
    }

}
