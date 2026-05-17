package exercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrianguloTest {

    private Triangulo triangulo;

    @BeforeEach
    void setUp() {
        triangulo = new Triangulo();
    }

    // 1) escaleno valido
    @Test
    void deveSerEscaleno() {
        assertEquals("ESCALENO", triangulo.classificar(3, 4, 5));
    }

    // 2) isosceles valido
    @Test
    void deveSerIsosceles() {
        assertEquals("ISOSCELES", triangulo.classificar(6, 6, 4));
    }

    // 3) equilatero valido
    @Test
    void deveSerEquilatero() {
        assertEquals("EQUILATERO", triangulo.classificar(4, 4, 4));
    }

    // 4) 3 CTs de isosceles com permutacao dos mesmos valores
    @Test
    void isoscelesPermutacao1() {
        assertEquals("ISOSCELES", triangulo.classificar(5, 5, 3));
    }

    @Test
    void isoscelesPermutacao2() {
        assertEquals("ISOSCELES", triangulo.classificar(5, 3, 5));
    }

    @Test
    void isoscelesPermutacao3() {
        assertEquals("ISOSCELES", triangulo.classificar(3, 5, 5));
    }

    // 5) um valor zero
    @Test
    void naoDeveSerTrianguloComUmZero() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(0, 4, 5));
    }

    // 6) um valor negativo
    @Test
    void naoDeveSerTrianguloComValorNegativo() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(-1, 4, 5));
    }

    // 7) soma de 2 lados igual ao terceiro
    @Test
    void naoDeveSerTrianguloQuandoSomaDeDoisIgualAoTerceiro() {
        // 2 + 3 = 5, entao nao forma triangulo
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(2, 3, 5));
    }

    // 8) permutacoes do caso acima
    @Test
    void somaIgualAoTerceiroPermutacao1() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(3, 2, 5));
    }

    @Test
    void somaIgualAoTerceiroPermutacao2() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(2, 5, 3));
    }

    @Test
    void somaIgualAoTerceiroPermutacao3() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(5, 2, 3));
    }

    // 9) soma de 2 lados menor que o terceiro
    @Test
    void naoDeveSerTrianguloQuandoSomaDeDoisMenorQueTerceiro() {
        // 1 + 2 = 3, e 3 < 10
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(1, 2, 10));
    }

    // 10) permutacoes do caso acima
    @Test
    void somaMenorQueTerceiroPermutacao1() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(2, 1, 10));
    }

    @Test
    void somaMenorQueTerceiroPermutacao2() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(1, 10, 2));
    }

    @Test
    void somaMenorQueTerceiroPermutacao3() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(10, 1, 2));
    }

    // 11) tres valores iguais a zero
    @Test
    void naoDeveSerTrianguloComTodosZero() {
        assertEquals("NAO_E_TRIANGULO", triangulo.classificar(0, 0, 0));
    }
}
