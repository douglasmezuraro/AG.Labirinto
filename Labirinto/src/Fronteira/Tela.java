package Fronteira;

import Entidades.Labirinto;
import java.util.Scanner;

public class Tela {
    
    public static int perguntarVertice(String pergunta) {
        System.out.println(pergunta);
        return new Scanner(System.in).nextInt();
    }
    
    public static void main(String[] args) {        
        Labirinto labirinto = new Labirinto(7);
        
        labirinto.dfs();
        System.out.println(labirinto.toString());
        
        int origem = perguntarVertice("Digite a origem:");
        
        labirinto.bfs(origem);
        
        int destino = perguntarVertice("Digite o destino: ");
        
        System.out.println("\nCaminho: " + labirinto.getCaminho(origem, destino));                
    }
    
}
