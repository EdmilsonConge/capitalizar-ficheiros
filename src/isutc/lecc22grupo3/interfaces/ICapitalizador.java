package isutc.lecc22grupo3.interfaces;

public interface ICapitalizador {
    /**
     * Capitaliza a primeira letra de cada palavra no texto fornecido
     * @param texto o Texto a ser capitalizado
     * @return texto com a primeira letra de cada palavra capitalizada
     * @throws IllegalArgumentException
     */
    String capitalizar(String texto) throws IllegalArgumentException;
}
