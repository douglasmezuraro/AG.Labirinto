package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Vertice {
    
    private String nome;
    private Cor cor;
    private List<Aresta> adj;
    
    Vertice(String nome) {
        this.nome = nome;
        this.cor = Cor.Branco;
        this.adj = new ArrayList<>();
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
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
