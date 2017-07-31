package Entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafo {    
    
    public final int infinito = -1;
    public List<Vertice> vertices;    
    private int valor;  
    
    Grafo() {
        vertices = new ArrayList<>();
    }
    
    /**
     * Método que cria um vértice com o valor passado como parâmetro na lista de 
     * vértices que compõe o grafo
     * @param valor
     * @return vértice adicionado
     */ 
    Vertice addVertice(int valor) {
        Vertice v = new Vertice(valor);
        vertices.add(v);
        return v;
    }
   
    /**
     * @return vértice de maior valor dentre os vértices que compõe o grafo
     */
    public Vertice verticeDeMaiorValor() {
        Vertice u = new Vertice();
        
        for(Vertice v: vertices) 
            if(v.valor > u.valor)
                u = v;
        
        return u;
    }
    
    /**
     * Algoritmo de busca em profundidade.
     * OBS: Esse algoritmo foi modificado em relação ao visto em sala de aula
     * para que faça a busca em profundidade a partir de um vértice aleatório e
     * não para que faça a busca em profundade a partir de cada vértice que seja
     * branco do grafo
     */
    public void dfs() {
        for(Vertice u: vertices) {
            u.cor = Cor.Branco;
            u.antecessor = null;
        }
        this.valor = 0;
        dfsVisit(vertices.get(0));
    }
    
    /**
     * Método de visita do algoritmo de busca em profundidade
     * OBS: Esse algoritmo foi um pouco modificado em relação ao visto em sala
     * para atender os requisitos da especificação
     * @param u 
     */
    private void dfsVisit(Vertice u) {
        u.cor = Cor.Cinza;        
        for(Vertice v: u.adjacentes) {
            if(v.cor == Cor.Branco) {                                   
                if(validarJogada(v, u)) {
                    v.antecessor = u;  
                    this.valor++;
                    v.valor = this.valor;
                    dfsVisit(v);
                }
            }               
        }        
        u.cor = Cor.Preto;
    }
    
    /**
     * Método que valida se a jogada é valida
     * @param adjacente
     * @param antecessor
     * @return resultado da validação
     */
    private Boolean validarJogada(Vertice adjacente, Vertice antecessor) {
        for(Vertice v: adjacente.adjacentes) 
            if(!v.equals(antecessor)) 
                if(v.getCelula() == Celula.caminho) 
                    return false;        
        return true;
    }
    
    /**
     * Algoritmo de busca em largura
     * @param s 
     */
    public void bfs(Vertice s) {
        for(Vertice v: vertices) {
            if(!v.equals(s)) {
                v.d = infinito;
                v.antecessor = null;
                v.cor = Cor.Branco;                
            }            
        }
        
        s.d = 0;
        s.antecessor = null;
        s.cor = Cor.Cinza;
        
        Queue<Vertice> q = new LinkedList<>();        
        q.add(s);
        
        while(!q.isEmpty()) {
            Vertice u = q.remove();
            for(Vertice v: u.adjacentes) {
                if(v.cor == Cor.Branco) {
                    if(v.getCelula() == Celula.caminho) {
                        v.d = u.d + 1;
                        v.antecessor = u;
                        v.cor = Cor.Cinza;
                        q.add(v);
                    }
                }
            }            
            u.cor = Cor.Preto;
        }                
    }
    
    /**
     * @param origem
     * @param destino
     * @return String com o menor caminho entre os vértices passados como parâmetro
     */
    public String getCaminho(Vertice origem, Vertice destino) {        
        try {
            final String begin     = "{";
            final String end       = "}";
            final String separator = ", ";

            Stack<Integer> pilha = new Stack();
            
            // popula a pilha
            acharCaminho(pilha, origem, destino);
            
            // caminho = "{"
            String caminho = begin;
            
            // inverte a pilha
            Collections.reverse(pilha);
            
            // enquanto a pilha não for vazia vai concatenando o caminho
            while(!pilha.isEmpty()) {
                if(caminho.equals(begin))
                    // exemplo: caminho = "{1"
                    caminho = caminho + pilha.pop();
                else
                    // exemplo: caminho = "{1, 2"
                   caminho = caminho + separator + pilha.pop();
            }
            
            // exemplo: caminho = "{1, 2}"
            return caminho + end;
        } catch(NullPointerException e) {
            return e.getMessage();
        }
    }
    
    /**
     * Método que "monta" o caminho na forma de pilha entre os vértices passados
     * como parâmetro 
     * @param pilha
     * @param origem
     * @param destino
     * @throws NullPointerException 
     */
    private void acharCaminho(Stack pilha, Vertice origem, Vertice destino) throws NullPointerException {
        if(origem == destino) 
            pilha.add(origem.valor);
        else if((origem == null) || (destino == null) || (destino.antecessor == null))
            throw new NullPointerException("Nao foi encontrado caminho.");
        else {
            acharCaminho(pilha, origem, destino.antecessor);
            pilha.add(destino.valor);
        }  
    }
    
}
