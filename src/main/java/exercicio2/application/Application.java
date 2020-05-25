package exercicio2.application;

import exercicio2.application.deserializer.EntradaDadosComposicao;
import exercicio2.domain.Composicao;
import exercicio2.domain.ComposicaoGeralInterface;
import exercicio2.domain.Insumo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Application {
    List<Composicao> composicoes = new ArrayList<>();

    public void imprimeComposicoes(List<EntradaDadosComposicao> dadosJson) {
        transformaDados(dadosJson);
        for (Composicao composicao : this.composicoes) {
            StringBuilder resumoComposicao = new StringBuilder();
            resumoComposicao.append(composicao.getCodigo()).append(" ");
            resumoComposicao.append(composicao.getDescricao()).append(" ");
            resumoComposicao.append(composicao.getUnidade()).append(" ");
            resumoComposicao.append(formataValorDecimal(composicao.getValorUnitario(),"#,##0.00"));
            System.out.println(resumoComposicao);
        }
    }

    private void transformaDados(List<EntradaDadosComposicao> dadosJson ) {

        for (EntradaDadosComposicao entradaDadosItemComposicao : dadosJson) {
            Composicao composicaoPai = encontrarComposicao(entradaDadosItemComposicao.getCodigoComposicao());

            if (!composicaoExiste(entradaDadosItemComposicao.getCodigoComposicao())) {
                composicaoPai = new Composicao(entradaDadosItemComposicao.getCodigoComposicao(), entradaDadosItemComposicao.getDescricaoComposicao(), entradaDadosItemComposicao.getUnidadeComposicao());
                this.composicoes.add(composicaoPai);
            }

            if (!composicaoExiste(entradaDadosItemComposicao.getCodigoItem()) && entradaDadosItemComposicao.getTipoItem().equals("COMPOSICAO")) {
                this.composicoes.add(new Composicao(entradaDadosItemComposicao.getCodigoItem(), entradaDadosItemComposicao.getDescricaoItemComposicao(), entradaDadosItemComposicao.getUnidadeItem()));
            }

            composicaoPai.add(retornaItemComposicao(entradaDadosItemComposicao));
        }
    }

    private ComposicaoGeralInterface retornaItemComposicao(EntradaDadosComposicao itemComposicao) {
        BigDecimal quantidade = converteValor(itemComposicao.getQuantidadeComposicao());
        BigDecimal valorUnitario = converteValor(itemComposicao.getValorUnitario());

        if (itemComposicao.getTipoItem().equals("INSUMO")) {
            return new Insumo(itemComposicao.getCodigoItem(), itemComposicao.getDescricaoItemComposicao(), itemComposicao.getUnidadeItem(), valorUnitario, quantidade);
        }

        Composicao composicaoFilha = encontrarComposicao(itemComposicao.getCodigoItem());
        composicaoFilha.setQuantidade(converteValor(itemComposicao.getQuantidadeComposicao()));
        return composicaoFilha;
    }

    private BigDecimal converteValor(String valorTexto) {
        BigDecimal valor = BigDecimal.ZERO;
        if (!valorTexto.isEmpty()) {
            valor = new BigDecimal(valorTexto.replace(",", "."));
        }
        return valor;
    }

    private String formataValorDecimal(BigDecimal valor, String formato) {
        DecimalFormat decimalFormat = new DecimalFormat(formato);
        decimalFormat.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        return decimalFormat.format(valor);
    }

    private Composicao encontrarComposicao(int codigoComposicao) {
        List<Composicao> encontrado = this.composicoes.stream().filter(composicao -> composicao.getCodigo() == codigoComposicao).collect(Collectors.toList());
        if (!encontrado.isEmpty()) {
            return encontrado.get(0);
        }
        return null;
    }

    private boolean composicaoExiste(int codigoComposicao) {
        return !this.composicoes.stream().filter(composicao -> composicao.getCodigo() == codigoComposicao).collect(Collectors.toList()).isEmpty();
    }
}
