package exercicio2;

import exercicio2.domain.Insumo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class InsumoTest {

    @Test
    void testCalcularValorTotalQuantidadeUm() {
        Insumo insumo = new Insumo(3148, "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)", "UN", BigDecimal.valueOf(9.4), BigDecimal.valueOf(0.019));
        assertEquals(new BigDecimal("9.40"), insumo.calculaValorTotal(BigDecimal.ONE));
    }

    @Test
    void testCalcularValorTotalQuantidadeMenorQueUm() {
        Insumo insumo = new Insumo(3148, "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)", "UN", BigDecimal.valueOf(9.4), BigDecimal.valueOf(0.019));
        assertEquals(new BigDecimal("7.10"), insumo.calculaValorTotal(BigDecimal.valueOf(0.756)));
    }

    @Test
    void testCalcularValorTotalQuantidadeMaiorQueUm() {
        Insumo insumo = new Insumo(3148, "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)", "UN", BigDecimal.valueOf(9.4), BigDecimal.valueOf(0.019));
        assertEquals(new BigDecimal("23.29"), insumo.calculaValorTotal(BigDecimal.valueOf(2.478)));
    }

    @Test
    void testCalculaValorTotalQuantidadeZero() {
        Insumo insumo = new Insumo(3148, "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)", "UN", BigDecimal.valueOf(9.4), BigDecimal.valueOf(0.019));
        assertEquals(new BigDecimal("0.00"), insumo.calculaValorTotal(BigDecimal.ZERO));
    }

    @Test
    void testCalculaValorTotalValorUnitarioZero() {
        Insumo insumo = new Insumo(3148, "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)", "UN", BigDecimal.ZERO, BigDecimal.valueOf(0.019));
        assertEquals(new BigDecimal("0.00"), insumo.calculaValorTotal(BigDecimal.ONE));
    }
}
