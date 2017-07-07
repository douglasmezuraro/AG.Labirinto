package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Vertice {
    
    private int valor; 
    private Cor cor;
    private List<Aresta> adj;
    
    Vertice(int valor) {
        this.valor = valor;
        this.cor = Cor.Branco;
        this.adj = new ArrayList<>();
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
        
    public Cor getCor() {
        return this.cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
    public List<Aresta> getAdj() {
        return this.adj;
    }
    
    public void setAdj(List<Aresta> adj) {
        this.adj = adj;
    }
    
    public void add(Aresta a) {
        this.adj.add(a);
    }
        
}
