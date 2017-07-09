package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Vertice {
    
    private int valor; 
    private Cor cor;
    private List<Vertice> adj;
    
    Vertice(int valor) {
        this.valor = valor;
        cor = Cor.Branco;
        adj = new ArrayList<>();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
        
    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
    public List<Vertice> getAdj() {
        return adj;
    }
    
    public void setAdj(List<Vertice> adj) {
        this.adj = adj;
    }
    
    public void add(Vertice v) {
        adj.add(v);
    }
        
}
