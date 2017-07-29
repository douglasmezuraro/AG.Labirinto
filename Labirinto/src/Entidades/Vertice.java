package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Vertice {
        
    public int valor; 
    public int d;
    public Cor cor;
    public List<Vertice> adj;
    public Vertice antecessor;
    
    Vertice(int valor) {
        this.valor = valor;
        cor = Cor.Branco;
        adj = new ArrayList<>();
    }
  
}
