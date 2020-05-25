package exercicio2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Composicao implements ComposicaoGeralInterface {

    private int codigo;
    private String descricao;
    private String unidade;
    private BigDecimal quantidade;
    private List<ComposicaoGeralInterface> itensComposicao = new ArrayList<>();

    public Composicao(int codigo, String descricao, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return calculaValorTotal(BigDecimal.ONE);
    }

    @Override
    public BigDecimal calculaValorTotal(BigDecimal quantidade) {
        BigDecimal valorTotal = BigDecimal.ZERO;
        Iterator<ComposicaoGeralInterface> itensComposicaoIterator = itensComposicao.iterator();
        while(itensComposicaoIterator.hasNext()) {
            ComposicaoGeralInterface itemComposisao = itensComposicaoIterator.next();
            valorTotal = valorTotal.add(itemComposisao.calculaValorTotal(itemComposisao.getQuantidade()));
        }
        return valorTotal.multiply(quantidade).setScale(2, BigDecimal.ROUND_FLOOR);
    }

    @Override
    public void add(ComposicaoGeralInterface composicaoGeralInterface) {
        itensComposicao.add(composicaoGeralInterface);
    }
}
