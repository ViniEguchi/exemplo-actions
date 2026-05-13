package sptech.school.exemplo_actions.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculadoraServiceTest {
    CalculadoraService calculadoraService;

    @BeforeEach
    void setup() {
        calculadoraService = new CalculadoraService();
    }

    @Test
    @DisplayName("Quando acionados com 10 e 2, então deve retornar 5")
    public void testDividir() {
        double a = 10;
        double b = 2;
        double esperado = 5;

        double resultado = calculadoraService.dividir(a, b);

        assertEquals(esperado, resultado);
    }
}