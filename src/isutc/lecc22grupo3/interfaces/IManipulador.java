package isutc.lecc22grupo3.interfaces;

import java.io.IOException;

/**
 * Interface que define as operacoes de manipulacao de arquivos
 */
public interface IManipulador {

    /**
     * Le o conteudo de um arquivo
     * @param nomeArquivo Nome do arquivo a ser lido
     * @return Conteudo do arquivo como String
     * @throws IOException Em caso de erro de Leitura
     * @throws IllegalArgumentException Se o nome do arquivo for invalido
     */
    String lerArquivo(String nomeArquivo) throws IOException, IllegalArgumentException;

    /**
     * Escreve conteudo em um arquivo
     * @param nomeArquivo Nome do arquivo onde sera escrito
     * @param conteudo Conteudo a ser escrito
     * @throws IOException Em caso de erro de escrita
     * @throws IllegalArgumentException Se o nome do arquivo for invalido ou o conteudo for nulo
     */
    void escreverArquivo(String nomeArquivo, String conteudo) throws IOException, IllegalArgumentException;
}
