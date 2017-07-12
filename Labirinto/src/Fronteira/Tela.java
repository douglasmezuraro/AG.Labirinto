package Fronteira;

import Entidades.Labirinto;

public class Tela {

    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();
        
        labirinto.criarCaminho();
        
        System.out.println(labirinto.toString());
    }
    
}
