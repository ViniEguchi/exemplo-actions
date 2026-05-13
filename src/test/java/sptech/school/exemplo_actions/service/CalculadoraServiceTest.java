package sptech.school.exemplo_actions.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

    @Test
    @DisplayName("Quando adiciona com 10 e 0, então deve lançar exceção")
    public void testDividirPorZero() {
        double a = 10;
        double b = 0;
        var expectedMessage= "400 BAD_REQUEST \"Divisão por zero não permitida\"";

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class, () -> {
                    calculadoraService.dividir(a, b);
                }
        );

        assertEquals(expectedMessage, exception.getMessage());
    }
}