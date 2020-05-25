package exercicio1;

import java.text.DecimalFormat;
import java.util.*;

public class GeradorObservacao {

    //Textos pré-definidos
    private static final String OBSERVACAO_SINGULAR = "Fatura da nota fiscal de simples remessa: ";
    private static final String OBSERVACAO_PLURAL = "Fatura das notas fiscais de simples remessa: ";
    private static final String TEXTO_VALOR_TOTAL = " Total = %s.";
    private static final String TEXTO_VALOR_NOTA_FISCAL = " cujo valor é R$ %s";
    //Identificador da entidade
    private String texto;

    //Gera observações, com texto pre-definido, incluindo os números, das notas fiscais, recebidos no parâmetro
    public String geraObservacao(List lista) {
        if (!lista.isEmpty()) {
            return retornaCodigos(lista);
        }
        return "";
    }

    public String geraObservacao(TreeMap<Integer, Double> map) {
        if (!map.isEmpty()) {
            return retornaCodigosComValor(map);
        }
        return "";
    }

    private String retornaCodigos(List lista) {
        this.texto = textoObservacao(lista.size());

        StringBuilder textoCodigo = new StringBuilder();
        for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
            Integer codigo = iterator.next();
            String separador = retornaSeparadorTexto(textoCodigo.toString(), iterator.hasNext());
            textoCodigo.append(separador + codigo);
        }
        textoCodigo.append(".");

        return this.texto + textoCodigo;
    }

    private String retornaCodigosComValor(TreeMap<Integer, Double> map) {
        this.texto = textoObservacao(map.size());

        StringBuilder codigoComValor = new StringBuilder();
        Double valorTotal = 0.0;
        for (Map.Entry<Integer, Double> codigoValor : map.entrySet()) {
            Integer codigo = codigoValor.getKey();
            String separador = retornaSeparadorTexto(codigoComValor.toString(), codigoValor.getKey() != map.lastKey());
            String textoValor = retornaTextoValor(codigoValor.getValue());
            valorTotal += codigoValor.getValue();
            codigoComValor.append(separador + codigo + textoValor);
        }
        codigoComValor.append(".");

        String textoValorTotal = retornaTextoValorTotal(valorTotal);
        return this.texto + codigoComValor + textoValorTotal;
    }

    private String textoObservacao(int tamanhoLista) {
        return tamanhoLista >= 2 ? OBSERVACAO_PLURAL : OBSERVACAO_SINGULAR;
    }

    private String retornaSeparadorTexto(String codigo, boolean existeProximoElemento) {
        if (validaTextoVazio(codigo)) {
            return "";
        }
        return existeProximoElemento ? ", " : " e ";
    }

    private boolean validaTextoVazio(String texto) {
        return texto == null || texto.isEmpty();
    }

    private String retornaTextoValor(Double valor) {
        return String.format(TEXTO_VALOR_NOTA_FISCAL, formataValorMonetario(valor));
    }

    private String retornaTextoValorTotal(Double valor) {
        return String.format(TEXTO_VALOR_TOTAL, formataValorMonetario(valor));
    }

    private String formataValorMonetario(Double valor) {
        return new DecimalFormat("#,###,##0.00").format(valor);
    }
}