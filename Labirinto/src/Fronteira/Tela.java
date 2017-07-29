package Fronteira;

import Entidades.Labirinto;
import java.util.Scanner;

public class Tela {

    public static void main(String[] args) {        
        Labirinto labirinto = new Labirinto(7);
        
        labirinto.criarCaminho();
        System.out.println(labirinto.toString());
        
        labirinto.acharMenorCaminho();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a origem: ");
        int origem = scanner.nextInt();
        System.out.println("Digite o destino: ");
        int destino = scanner.nextInt();
        System.out.println(labirinto.getCaminho(origem, destino));                
    }
    
}
