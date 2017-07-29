package Fronteira;

import Entidades.Labirinto;
import java.util.Scanner;

public class Tela {
    
    public static int perguntarVertice(String pergunta) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(pergunta);
        return scanner.nextInt();
    }
    
    public static void main(String[] args) {        
        Labirinto labirinto = new Labirinto(7);
        
        labirinto.dfs();
        System.out.println(labirinto.toString());
        
        int origem = perguntarVertice("Digite a origem:");
        
        labirinto.bfs(origem);
        
        int destino = perguntarVertice("Digite o destino: ");
        
        System.out.println("Caminho: " + labirinto.getCaminho(origem, destino));                
    }
    
}
