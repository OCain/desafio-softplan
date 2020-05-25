package exercicio2;

import exercicio2.domain.Composicao;
import exercicio2.domain.Insumo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ComposicaoTest {

    private Composicao composicao;
    private Composicao composicao2;

    @BeforeEach
    void setUp() throws Exception {
        this.composicao = new Composicao(94793, "REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016", "UN");
        this.composicao2 = new Composicao(98561, "IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018", "M2");
        this.composicao.add(new Insumo(3148, "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)", "UN", BigDecimal.valueOf(9.4), BigDecimal.valueOf(0.019)));
        this.composicao.add(new Insumo(6014, "REGISTRO GAVETA COM ACABAMENTO E CANOPLA CROMADOS, SIMPLES, BITOLA 1 1/4  (REF 1509)", "UN", BigDecimal.valueOf(100.41), BigDecimal.valueOf(1)));
        this.composicao.add(new Insumo(88248, "AUXILIAR DE ENCANADOR OU BOMBEIRO HIDRÁULICO COM ENCARGOS COMPLEMENTARES", "H", BigDecimal.valueOf(15.19), BigDecimal.valueOf(0.789)));
        this.composicao.add(new Insumo(88267, "ENCANADOR OU BOMBEIRO HIDRÁULICO COM ENCARGOS COMPLEMENTARES", "H", BigDecimal.valueOf(20.33), BigDecimal.valueOf(0.789)));
        this.composicao2.add(new Insumo(7325, "ADITIVO IMPERMEABILIZANTE DE PEGA NORMAL PARA ARGAMASSAS E  CONCRETOS SEM ARMACAO", "KG", BigDecimal.valueOf(4.44), BigDecimal.valueOf(0.38)));
        this.composicao2.add(new Insumo(88309, "PEDREIRO COM ENCARGOS COMPLEMENTARES", "H", BigDecimal.valueOf(19.82), BigDecimal.valueOf(0.867)));
        this.composicao2.add(new Insumo(88316, "SERVENTE COM ENCARGOS COMPLEMENTARE", "H", BigDecimal.valueOf(14.78), BigDecimal.valueOf(0.176)));
    }

    @Test
    void calculaValorTotalComposicaoApenasComInsumosQuantidadeUmTest() {
        assertEquals(new BigDecimal("128.60"), this.composicao.calculaValorTotal(BigDecimal.valueOf(1.0)));
    }

    @Test
    void calculaValorTotalComposicaoApenasComInsumosQuantidadeMenorQueUmTest() {
        assertEquals(new BigDecimal("63.78"), this.composicao.calculaValorTotal(BigDecimal.valueOf(0.496)));
    }

    @Test
    void calculaValorTotalComposicaoApenasComInsumosQuantidadeMaiorQueUmTest() {
        assertEquals(new BigDecimal("738.42"), this.composicao.calculaValorTotal(BigDecimal.valueOf(5.742)));
    }

    @Test
    void calculaValorTotalComposicaoApenasComInsumosQuantidadeZeroTest() {
        assertEquals(new BigDecimal("0.00"), this.composicao.calculaValorTotal(BigDecimal.ZERO));
    }

    @Test
    void calculaValorTotalComposicaoComComposicaoFilhaEInsumosQuantidadeUmTest() {
        Composicao composicaoFilha = this.composicao;
        composicaoFilha.setQuantidade(BigDecimal.valueOf(0.022));
        this.composicao2.add(composicaoFilha);
        assertEquals(new BigDecimal("24.28"), this.composicao2.calculaValorTotal(BigDecimal.ONE));
    }

    @Test
    void calculaValorTotalComposicaoComComposicaoFilhaEInsumosQuantidadeMenorQueUmTest() {
        Composicao composicaoFilha = this.composicao;
        composicaoFilha.setQuantidade(BigDecimal.valueOf(0.022));
        this.composicao2.add(composicaoFilha);
        assertEquals(new BigDecimal("5.19"), this.composicao2.calculaValorTotal(BigDecimal.valueOf(0.214)));
    }

    @Test
    void calculaValorTotalComposicaoComComposicaoFilhaEInsumosQuantidadeMaiorQueUmTest() {
        Composicao composicaoFilha = this.composicao;
        composicaoFilha.setQuantidade(BigDecimal.valueOf(0.022));
        this.composicao2.add(composicaoFilha);
        assertEquals(new BigDecimal("337.46"), this.composicao2.calculaValorTotal(BigDecimal.valueOf(13.899)));
    }

    @Test
    void calculaValorTotalComposicaoComComposicaoFilhaEInsumosQuantidadeZeroTest() {
        Composicao composicaoFilha = this.composicao;
        composicaoFilha.setQuantidade(BigDecimal.valueOf(0.022));
        this.composicao2.add(composicaoFilha);
        assertEquals(new BigDecimal("0.00"), this.composicao2.calculaValorTotal(BigDecimal.ZERO));
    }
}
