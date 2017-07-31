package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Point;

public class Labirinto {
   
    private final Vertice[][] matriz;
    private final Grafo grafo;
    
    public Labirinto(int tamanho) {
        matriz = new Vertice[tamanho][tamanho];
        grafo = new Grafo();
      
        criarVertices();
        grafo.vertices = getVertices(); 
        adicionarAdjacentes();
    }
    
    public void dfs() {
        grafo.dfs();
    }
    
    public void bfs(int valor) {
        bfs(getVertice(valor));
    }
    
    private void bfs(Vertice u) {
        grafo.bfs(u);
    }
    
    /**
     * Método que cria os vértices da matriz passeando por cada posição
     */
    private void criarVertices() {      
        for(int l = 0; l < matriz.length; l++)
            for(int c = 0; c < matriz.length; c++)
                matriz[l][c] = new Vertice();
    }
    
    /**
     * Método que retorna uma lista dos vértices que compõe a matriz
     * @return lista de vértices
     */
    private List<Vertice> getVertices() {
        List<Vertice> list = new ArrayList<>();        
       
        for(int l = 0; l < matriz.length; l++) 
            for(int c = 0; c < matriz.length; c++) 
                list.add(matriz[l][c]);
     
        return list;
    }
    
    /**
     * Método que passeia na matriz e para cada posição atribui seus adjacentes 
     * através do método "getAdjacentes()"
     */
    private void adicionarAdjacentes() {
        for(int l = 0; l < matriz.length; l++) 
            for(int c = 0; c < matriz.length; c++) 
                matriz[l][c].adj = getAdjacentes(matriz[l][c]);
    }
    
    /**
     * Método que retorna uma lista com os vértices adjacentes do vértice "u" que
     * é passado como parâmetro
     * @param u
     * @return lista de adjacentes de "u"
     */
    private List<Vertice> getAdjacentes(Vertice u) {
        List<Vertice> list = new ArrayList<>();
        
        for(Direcao direcao: Direcao.values()) {
            Vertice v = getVertice(u, direcao);
            
            if(v != null)
               list.add(v);        
        }
        
        Collections.shuffle(list);
        return list;        
    }
    
    /**
     * Método que retorna a coordenada do vértice "u" na matriz
     * @param u
     * @return coordenada de "u"
     */
    private Point getPosicaoVertice(Vertice u) {
        for(int l = 0; l < matriz.length; l++) 
            for(int c = 0; c < matriz.length; c++) 
                if(matriz[l][c].equals(u))
                    return new Point(l, c);          
        return null;
    }
    
    /**
     * Método que verifica se a coordenada "p" está dentro dos limites da matriz
     * @param p
     * @return resultado da verificação
     */
    private boolean posicaoExiste(Point p) {
        return (p.x >= 0) 
            && (p.y >= 0)
            && (p.x < matriz.length)
            && (p.y < matriz.length);
    }
    
    /**
     * Método que retorna o vértice da matriz através de sua posição
     * @param p
     * @return vértice caso exista, null caso contrário
     */
    private Vertice getVertice(Point p){
        if(posicaoExiste(p))
            return matriz[p.x][p.y];
        else
            return null;
    }
    
    /**
     * Método que retorna o vértice adjacente do vértice u  na direção passada 
     * como parâmetro da matriz
     * @param u
     * @param direcao
     * @return vértice caso exista, null caso contrário
     */
    private Vertice getVertice(Vertice u, Direcao direcao) {
        Point origem = getPosicaoVertice(u),
              destino = null;
        
        if(origem != null) {
            switch(direcao) {
                case cima: 
                    destino = new Point(origem.x - 1, origem.y);
                    break;
                case baixo:
                    destino = new Point(origem.x + 1, origem.y);
                    break;
                case direita:
                    destino = new Point(origem.x, origem.y + 1);
                    break;
                case esquerda:
                    destino = new Point(origem.x, origem.y - 1);
                    break;
            }
            return getVertice(destino);
        }
        else return null;
    }
    
    /**
     * Método que retorna o vértice que tem o valor passado como parâmetro
     * @param valor
     * @return vértice caso exista, null caso contrário
     */
    private Vertice getVertice(int valor) {
        for(Vertice u: grafo.vertices) 
            if(u.valor == valor) 
                return u;
             
        return null; 
    }
    
    /**
     * Método que retorna o caminho entre os vértices passado como parâmetro.
     * Este método é um overload que foi feito pelo motivo que o usuário só tem
     * acesso ao valor dos vértices
     * @param origem
     * @param destino
     * @return caminho entre os vértices
     */
    public String getCaminho(int origem, int destino) {
        return getCaminho(getVertice(origem), getVertice(destino));
    }
    
    /**
     * Método que retorna o caminho entre os vértices passado como parâmetro
     * @param origem
     * @param destino
     * @return caminho entre os vértices
     */
    private String getCaminho(Vertice origem, Vertice destino) {
        return grafo.getCaminho(origem, destino);
    }
    
    /**
     * @return o labirinto em forma de String 
     */
    @Override
    public String toString() {
        String labirinto = "";
        int lenghtMaior = String.valueOf(grafo.verticeDeMaiorValor().valor).length();
        
        for(int l = 0; l < matriz.length; l++) {
            for(int c = 0; c < matriz.length; c++) {   
                String value = " ";
                   
                if(matriz[l][c].getCelula() == Celula.caminho)
                    value = String.valueOf(matriz[l][c].valor); 
                
                while(value.length() < lenghtMaior)
                    value = value + " ";
                
                labirinto = labirinto + value + "|";
            }
            labirinto = labirinto + "\n"; 
        }        
        
        return labirinto;
    }
    
}


