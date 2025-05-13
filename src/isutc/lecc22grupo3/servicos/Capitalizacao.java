package isutc.lecc22grupo3.servicos;

import isutc.lecc22grupo3.interfaces.ICapitalizador;
import isutc.lecc22grupo3.interfaces.IManipulador;

import java.io.IOException;

public class Capitalizacao {
    private final ICapitalizador capitalizador;
    private final IManipulador manipulador;

    public Capitalizacao(ICapitalizador capitalizador, IManipulador manipulador) {
        if (capitalizador == null) {
            throw new IllegalArgumentException("O capitalizador nao pode ser nulo");
        }
        if (manipulador == null) {
            throw new IllegalArgumentException("O manipulador de arquivo nao pode ser nulo");
        }
        this.capitalizador = capitalizador;
        this.manipulador = manipulador;
    }

    public boolean PalavraCapitalizada(String nomeArquivo, boolean sobrescrever) {
        try {
            if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
                System.err.println("Nome de arquivo invalido");
                return false;
            }

            System.out.println("Lendo arquivo: " + nomeArquivo);
            String textoInicial = manipulador.lerArquivo(nomeArquivo);

            System.out.println("Capitalizando o texto...");
            String textoCapitalizado = capitalizador.capitalizar(textoInicial);

            System.out.println("\nTexto Original: ");
            System.out.println(textoInicial);
            System.out.println("\nTexto Capitalizado");
            System.out.println(textoCapitalizado);

            String arquivoFinal;
            if (sobrescrever) {
                arquivoFinal = nomeArquivo;
                System.out.println("\nSobrescrevendo o arquivo original...");
            } else {
                int indecePonto = nomeArquivo.lastIndexOf(".");
                if (indecePonto > 0) {
                    arquivoFinal = nomeArquivo.substring(0, indecePonto) + "_capitalizado" + nomeArquivo.substring(indecePonto);

                } else {
                    arquivoFinal = nomeArquivo + "_capitalizado";
                }
                System.out.println("Salvando resultado em novo arquivo: " + arquivoFinal);
            }

            manipulador.escreverArquivo(arquivoFinal, textoCapitalizado);
            System.out.println("Processo concluido com sucesso!");

            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro de validação: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Causa: " + e.getCause().getMessage());
            }
            return false;
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean PalavraCapitalizada(String nomeArquivo) {
        return PalavraCapitalizada(nomeArquivo, false);
    }
}
