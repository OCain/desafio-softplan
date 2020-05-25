package exercicio2.domain;

import java.math.BigDecimal;


public class Insumo implements ComposicaoGeralInterface {

    private int codigo;
    private String descricao;
    private String unidade;
    private BigDecimal quantidade;
    private BigDecimal valorUnitario;

    public Insumo(int codigo, String descricao, String unidade, BigDecimal valorUnitario, BigDecimal quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
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
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public BigDecimal calculaValorTotal(BigDecimal quantidade) {
        return getValorUnitario().multiply(quantidade).setScale(2, BigDecimal.ROUND_FLOOR);
    }

    @Override
    public void add(ComposicaoGeralInterface composicaoGeralInterface) {}
}
