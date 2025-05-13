import isutc.lecc22grupo3.implementacoes.CapitalizadorPalavra;
import isutc.lecc22grupo3.implementacoes.ManipuladorArquivo;
import isutc.lecc22grupo3.interfaces.ICapitalizador;
import isutc.lecc22grupo3.interfaces.IManipulador;
import isutc.lecc22grupo3.servicos.Capitalizacao;

import java.util.Scanner;

public class Aplicacao {
    public static void main (String [] args){
        ICapitalizador capitalizador = new CapitalizadorPalavra();
        IManipulador manipulador = new ManipuladorArquivo();
        Capitalizacao capitalizacao = new Capitalizacao(capitalizador, manipulador);

        Scanner ler = new Scanner(System.in);
        System.out.println("=== Aplicacao para Capitalizar Texto ===");
        System.out.println("\nInsira o nome do arquivo: ");
        String nomeArquivo = ler.nextLine();

        System.out.print("Deseja sobrescrever o arquivo original? (S/N): ");
        String opcao = ler.nextLine().toUpperCase();
        boolean sobrescrever = opcao.equals("S") || opcao.equals("SIM");

        boolean resultado = capitalizacao.PalavraCapitalizada(nomeArquivo, sobrescrever);

        if (resultado) {
            System.out.println("\nProcesso finalizado com sucesso!");
        } else {
            System.out.println("\nO processo não pôde ser concluído. Verifique os erros acima.");
        }
    }
}
