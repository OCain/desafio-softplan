package exercicio1;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class GeradorObservacaoTest {


    @Test
    public void geraObservacaoListaVaziaTest() {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        String textoEsperado = "";
        assertTrue(geradorObservacao.geraObservacao(Arrays.asList()).equals(textoEsperado));
    }

    @Test
    public void geraObservacaoElementoUnicoListaTest() {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        String textoEsperado = "Fatura da nota fiscal de simples remessa: 1.";
        assertTrue(geradorObservacao.geraObservacao(Arrays.asList(1)).equals(textoEsperado));
    }

    @Test
    public void geraObservacaoDoisElementosListaTest() {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        String textoEsperado = "Fatura das notas fiscais de simples remessa: 1 e 2.";
        assertTrue(geradorObservacao.geraObservacao(Arrays.asList(1, 2)).equals(textoEsperado));
    }

    @Test
    public void geraObservacaoTresElementosListaTest() {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        String textoEsperado = "Fatura das notas fiscais de simples remessa: 1, 2 e 3.";
        assertTrue(geradorObservacao.geraObservacao(Arrays.asList(1, 2, 3)).equals(textoEsperado));
    }

    @Test
    public void geraObservacaoMapVazioTest() {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        String textoEsperado = "";
        TreeMap<Integer, Double> lista = new TreeMap<Integer, Double>();
        assertTrue(geradorObservacao.geraObservacao(lista).equals(textoEsperado));
    }

    @Test
    public void geraObservacaoElementoUnicoDezenaMapTest() {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        String textoEsperado = "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 12,00. Total = 12,00.";
        TreeMap<Integer, Double> lista = new TreeMap<Integer, Double>();
        lista.put(1, 12.00);
        assertTrue(geradorObservacao.geraObservacao(lista).equals(textoEsperado));
    }

    @Test
    public void geraObservacaoElementoUnicoMilharTest() {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        String textoEsperado = "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 3.594,68. Total = 3.594,68.";
        TreeMap<Integer, Double> lista = new TreeMap<Integer, Double>();
        lista.put(1, 3594.68);
        assertTrue(geradorObservacao.geraObservacao(lista).equals(textoEsperado));
    }

    @Test
    public void geraObservacaoCincoElementosMapTest() {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        String textoEsperado = "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10,00, " +
                "2 cujo valor é R$ 35,00, 3 cujo valor é R$ 5,00, 4 cujo valor é R$ 1.500,00 e 5 cujo valor é R$ 0,30. " +
                "Total = 1.550,30.";
        TreeMap<Integer, Double> lista = new TreeMap<Integer, Double>();
        lista.put(1, 10.00);
        lista.put(2, 35.00);
        lista.put(3, 5.00);
        lista.put(4, 1500.00);
        lista.put(5, 0.30);
        assertTrue(geradorObservacao.geraObservacao(lista).equals(textoEsperado));
    }
}
