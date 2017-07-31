package Entidades;

import java.util.List;
import java.util.ArrayList;

/**
 * Nesta implementação o conceito aresta é a relalão entre um vértice e seus adjacentes
 * Exemplo: vértice "A", com adjacentes: ["B", "C", "D"]
 * Então existe as seguintes arestas: ["A-B", "A-C", "A-D"]
 */
public class Vertice {
        
    public int valor; 
    public int d;
    public Cor cor;
    public List<Vertice> adjacentes;
    public Vertice antecessor;
    
    /**
     * Construtor sobreescrito de um vértice que chama o outro construtor passando
     * como parâmetro valor = 0
     */
    Vertice() {
        this(0);
    }
    
    /**
     * Construtor sobrescrito de um vértice qualquer que ja inicia o vértice
     * com o valor passado como parâmetro além de inicializar suas outras propriedades
     * @param valor 
     */
    Vertice(int valor) {
        this.valor = valor;
        d = 0;
        cor = Cor.Branco;
        adjacentes = new ArrayList<>();
        antecessor = null;
    }
    
    /**
     * @return tipo da célula que o vértice é baseado em seu valor 
     */
    public Celula getCelula() {
        if(valor > 0)
            return Celula.caminho;
        else 
            return Celula.parede;
    }
  
}
