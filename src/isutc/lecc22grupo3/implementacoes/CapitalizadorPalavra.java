package isutc.lecc22grupo3.implementacoes;

import isutc.lecc22grupo3.interfaces.ICapitalizador;
import java.util.StringTokenizer;


public class CapitalizadorPalavra implements ICapitalizador {

    @Override
    public String capitalizar(String texto) throws IllegalArgumentException {
        if (texto == null) {
            throw new IllegalArgumentException("O texto nao pode ser nulo");
        }

        if (texto.trim().isEmpty()) {
            return texto;
        }

        StringTokenizer tokenizer = new StringTokenizer(texto, " \t\n\r\f", true);
        StringBuffer resultado = new StringBuffer();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (token.trim().isEmpty()) {
                resultado.append(token);
            }else {
                StringBuffer palavraBuffer = new StringBuffer(token);

                if (palavraBuffer.length() > 0) {
                    palavraBuffer.setCharAt(0, Character.toUpperCase(palavraBuffer.charAt(0)));
                }

                resultado.append(palavraBuffer);
            }
        }
        return resultado.toString();
    }
}
