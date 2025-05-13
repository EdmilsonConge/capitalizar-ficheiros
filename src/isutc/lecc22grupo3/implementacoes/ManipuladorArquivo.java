package isutc.lecc22grupo3.implementacoes;

import isutc.lecc22grupo3.interfaces.IManipulador;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManipuladorArquivo implements IManipulador {


    @Override
    public String lerArquivo(String nomeArquivo) throws IOException, IllegalArgumentException {
        validarNomeArquivo(nomeArquivo);

        Path caminhoArquivo = Paths.get(nomeArquivo);

        if (!Files.exists(caminhoArquivo)) {
            throw new IOException("O arquivo nao existe: " + nomeArquivo);
        }

        if (!Files.isRegularFile(caminhoArquivo)){
            throw new IOException("O caminho especificado nao e um arquivo: " + nomeArquivo);
        }

        if (!Files.isReadable(caminhoArquivo)) {
            throw new IOException("Não é possível ler o arquivo. Verifique as permissões: " + nomeArquivo);
        }
            StringBuilder conteudo = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
                String linha;

                while ((linha = reader.readLine()) != null) {
                    conteudo.append(linha);
                    conteudo.append(System.lineSeparator());
                }
            } catch (IOException e) {
                throw new IOException("Erro ao ler o arquivo: " + e.getMessage(), e);
            }
            return conteudo.toString();
    }

    @Override
    public void escreverArquivo(String nomeArquivo, String conteudo) throws IOException, IllegalArgumentException {
        validarNomeArquivo(nomeArquivo);

        if (conteudo == null) {
            throw new IllegalArgumentException("O conteúdo não pode ser nulo");
        }

        Path caminhoArquivo = Paths.get(nomeArquivo);

        // Verificar se o diretório existe
        Path diretorio = caminhoArquivo.getParent();
        if (diretorio != null && !Files.exists(diretorio)) {
            try {
                Files.createDirectories(diretorio);
            } catch (IOException e) {
                throw new IOException("Não foi possível criar o diretório: " + e.getMessage(), e);
            }
        }


        if (Files.exists(caminhoArquivo) && !Files.isWritable(caminhoArquivo)) {
            throw new IOException("Não é possível escrever no arquivo. Verifique as permissões: " + nomeArquivo);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
            writer.flush();
        } catch (IOException e) {
            throw new IOException("Erro ao escrever no arquivo: " + e.getMessage(), e);
        }
    }

    /**
     * Valida o nome do arquivo
     * @param nomeArquivo Nome do arquivo a ser validado
     * @throws IllegalArgumentException Se o nome do arquivo for inválido
     */
    private void validarNomeArquivo(String nomeArquivo) throws IllegalArgumentException {
        if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do arquivo não pode ser nulo ou vazio");
        }
    }
}
