package exercicio2.application.deserializer;

public class EntradaDadosComposicao {

    private int codigoComposicao;
    private String descricaoComposicao;
    private String unidadeComposicao;
    private String tipoItem;
    private int codigoItem;
    private String descricaoItemComposicao;
    private String unidadeItem;
    private String quantidadeComposicao;
    private String valorUnitario;

    public EntradaDadosComposicao() {

    }

    public EntradaDadosComposicao(int codigoComposicao, String descricaoComposicao, String unidadeComposicao, String tipoItem, int codigoItem, String descricaoItemComposicao, String unidadeItem, String quantidadeComposicao, String valorUnitario) {
        this.codigoComposicao = codigoComposicao;
        this.descricaoComposicao = descricaoComposicao;
        this.unidadeComposicao = unidadeComposicao;
        this.tipoItem = tipoItem;
        this.codigoItem = codigoItem;
        this.descricaoItemComposicao = descricaoItemComposicao;
        this.unidadeItem = unidadeItem;
        this.quantidadeComposicao = quantidadeComposicao;
        this.valorUnitario = valorUnitario;
    }

    public int getCodigoComposicao() {
        return codigoComposicao;
    }

    public void setCodigoComposicao(int codigoComposicao) {
        this.codigoComposicao = codigoComposicao;
    }

    public String getDescricaoComposicao() {
        return descricaoComposicao;
    }

    public void setDescricaoComposicao(String descricaoComposicao) {
        this.descricaoComposicao = descricaoComposicao;
    }

    public String getUnidadeComposicao() {
        return unidadeComposicao;
    }

    public void setUnidadeComposicao(String unidadeComposicao) {
        this.unidadeComposicao = unidadeComposicao;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getDescricaoItemComposicao() {
        return descricaoItemComposicao;
    }

    public void setDescricaoItemComposicao(String descricaoItemComposicao) {
        this.descricaoItemComposicao = descricaoItemComposicao;
    }

    public String getUnidadeItem() {
        return unidadeItem;
    }

    public void setUnidadeItem(String unidadeItem) {
        this.unidadeItem = unidadeItem;
    }

    public String getQuantidadeComposicao() {
        return quantidadeComposicao;
    }

    public void setQuantidadeComposicao(String quantidadeComposicao) {
        this.quantidadeComposicao = quantidadeComposicao;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
