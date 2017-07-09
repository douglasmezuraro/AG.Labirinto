package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Grafo {
    
    private List<Aresta> arestas;
    private List<Vertice> vertices;

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

}
