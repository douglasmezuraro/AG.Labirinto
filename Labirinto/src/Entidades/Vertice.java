package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Vertice {
        
    public int valor; 
    public int d;
    public Cor cor;
    public List<Vertice> adj;
    public Vertice antecessor;
    
    Vertice() {
        this(0);
    }
    
    Vertice(int valor) {
        this.valor = valor;
        d = 0;
        cor = Cor.Branco;
        adj = new ArrayList<>();
        antecessor = null;
    }
    
    public Celula getCelula() {
        if(valor > 0)
            return Celula.caminho;
        else 
            return Celula.parede;
    }
  
}
