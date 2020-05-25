package exercicio2.domain;

import java.math.BigDecimal;

public interface ComposicaoGeralInterface {

    public int getCodigo();
    public String getDescricao();
    public String getUnidade();
    public BigDecimal getQuantidade();
    public BigDecimal calculaValorTotal(BigDecimal quantidade);
    public void add(ComposicaoGeralInterface composicaoGeralInterface);

}
