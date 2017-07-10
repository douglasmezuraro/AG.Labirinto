package Fronteira;

import Entidades.Labirinto;

public class Tela {

    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();
        
        labirinto.jogar(labirinto.getVerticeInicial());
        
        System.out.println(labirinto.toString());
    }
    
}
