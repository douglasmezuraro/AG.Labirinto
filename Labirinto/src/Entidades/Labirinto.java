package Entidades;

import java.util.List;
import java.util.ArrayList;

public class Labirinto {
    
    public final int length = 7;
    private final Vertice[][] matriz;
    private final Grafo grafo;
    private int ultimoValor;
    
    
    public Labirinto() {
        matriz = new Vertice[length][length];
        grafo = new Grafo();
      
        grafo.setVertices(criarVertices());
        
        setVerticesAdjacentes();
        
        ultimoValor = 0;
    }
    
    /**
     * Método que percorre a matriz inteira instânciado os vértices com valor 0
     */
    private List<Vertice> criarVertices() {
        List<Vertice> lista = new ArrayList<>();        
        for(int l = 0; l < length; l++) {
            for(int c = 0; c < length; c++) {
                matriz[l][c] = new Vertice(0);
                lista.add(matriz[l][c]);
            }
        }
        return lista;
    }

    /**
     * Este método é usado para ter acesso não direto à matriz.
     * @return Matriz de vértices 
     */
    public Vertice[][] getMatriz() {
        return matriz;
    }
    
    /**
     * Para cada vértice na matriz de vértice é setado sua lista de adjacentes.
     */
    private void setVerticesAdjacentes() {
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                matriz[l][c].setAdj(getAdjByPos(l, c));
            }
        }
    }
    
    /**
     * Método que retorna uma lista de vértices adjacentes ao vétice que está
     * na matriz na posicão matriz[linha][coluna], que de acordo com a regra
     * são os vértices de cima, baixo, direita e esquerda.
     * @param linha
     * @param coluna
     * @return Lista de vértices adjacentes 
     */
    private List<Vertice> getAdjByPos(int linha, int coluna) {
        List<Vertice> adj = new ArrayList<>();
        
        // Vértice de cima
        if(linha >= 1)
            adj.add(matriz[linha - 1][coluna]);
       
        // Vértice de baixo
        if(linha < matriz.length - 1)
            adj.add(matriz[linha + 1][coluna]);
        
        // Vértice da esquerda
        if(coluna >= 1)
            adj.add(matriz[linha][coluna - 1]);
        
        // Vérice da Direita
        if(coluna < matriz.length - 1)
            adj.add(matriz[linha][coluna + 1]);
        
        return adj;
    }   
    
    /**
     * Este método encontra os caminhos possíveis a partir de um vertice v de maneira
     * recursiva através de seus adjacentes
     * @param u 
     */
    private void encontrarCaminhos(Vertice u) {
        
        u.setCor(Cor.Cinza);
        
        for(Vertice v: u.getAdj()) {
            if(v.getCor() == Cor.Branco) {
                v.setAntecessor(u); 

                if(validarCaminho(v)) {
                    ultimoValor++;
                    v.setValor(ultimoValor);

                    encontrarCaminhos(v);
                }
            }               
        }

        u.setCor(Cor.Preto);
    }
    
    private Boolean validarCaminho(Vertice u) {
        for(Vertice v: u.getAdj()) 
            if(!v.equals(u.getAntecessor())) 
                if (v.getValor() > 0) 
                    return false;        
        return true;
    }
            
    public void jogar() {
        encontrarCaminhos(grafo.getRamdomVertice());
    }
    
    /**
     * Método que retorna uma representação gráfica do labirinto na forma de 
     * uma String
     * @return Labirinto em String
     */
    @Override
    public String toString() {
        String str = "";
        
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {
                int aux = matriz[l][c].getValor();
                
                if(aux == 0) 
                    str = str + "  |";
                else if(aux < 10)
                    str = str + aux + " |";
                else 
                    str = str + aux + "|";
            }            
            str = str + "\n";            
        }        
        
        return str;
    }
    
}
