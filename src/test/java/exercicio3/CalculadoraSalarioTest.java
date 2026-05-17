package exercicio3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraSalarioTest {

    private CalculadoraSalario calc;

    @BeforeEach
    void setUp() {
        calc = new CalculadoraSalario();
    }

    // -- DESENVOLVEDOR --

    @Test
    void desenvolvedorComSalarioAltoDeveTer20PorcentoDeDesconto() {
        // 5000 * 0.8 = 4000
        Funcionario f = new Funcionario("Joao", "j@a.com", 5000, Cargo.DESENVOLVEDOR);
        assertEquals(4000.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    @Test
    void desenvolvedorComSalarioBaixoDeveTer10PorcentoDeDesconto() {
        // 2000 * 0.9 = 1800
        Funcionario f = new Funcionario("Joao", "j@a.com", 2000, Cargo.DESENVOLVEDOR);
        assertEquals(1800.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    @Test
    void desenvolvedorComSalarioExatamente3000DeveTer20Porcento() {
        // valor de borda: >= 3000 entra no 20%
        // 3000 * 0.8 = 2400
        Funcionario f = new Funcionario("Joao", "j@a.com", 3000, Cargo.DESENVOLVEDOR);
        assertEquals(2400.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    // -- DBA --

    @Test
    void dbaComSalarioAltoDeveTer25PorcentoDeDesconto() {
        // 4000 * 0.75 = 3000
        Funcionario f = new Funcionario("Maria", "m@a.com", 4000, Cargo.DBA);
        assertEquals(3000.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    @Test
    void dbaComSalarioBaixoDeveTer15PorcentoDeDesconto() {
        // 1500 * 0.85 = 1275
        Funcionario f = new Funcionario("Maria", "m@a.com", 1500, Cargo.DBA);
        assertEquals(1275.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    @Test
    void dbaComSalarioExatamente2000DeveTer25Porcento() {
        // 2000 * 0.75 = 1500
        Funcionario f = new Funcionario("Maria", "m@a.com", 2000, Cargo.DBA);
        assertEquals(1500.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    // -- TESTADOR --

    @Test
    void testadorComSalarioAltoDeveTer25PorcentoDeDesconto() {
        // 3000 * 0.75 = 2250
        Funcionario f = new Funcionario("Ana", "a@a.com", 3000, Cargo.TESTADOR);
        assertEquals(2250.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    @Test
    void testadorComSalarioBaixoDeveTer15PorcentoDeDesconto() {
        // 1000 * 0.85 = 850
        Funcionario f = new Funcionario("Ana", "a@a.com", 1000, Cargo.TESTADOR);
        assertEquals(850.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    @Test
    void testadorComSalarioExatamente2000DeveTer25Porcento() {
        // 2000 * 0.75 = 1500
        Funcionario f = new Funcionario("Ana", "a@a.com", 2000, Cargo.TESTADOR);
        assertEquals(1500.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    // -- GERENTE --

    @Test
    void gerenteComSalarioAltoDeveTer30PorcentoDeDesconto() {
        // 6000 * 0.7 = 4200
        Funcionario f = new Funcionario("Carlos", "c@a.com", 6000, Cargo.GERENTE);
        assertEquals(4200.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    @Test
    void gerenteComSalarioBaixoDeveTer20PorcentoDeDesconto() {
        // 4000 * 0.8 = 3200
        Funcionario f = new Funcionario("Carlos", "c@a.com", 4000, Cargo.GERENTE);
        assertEquals(3200.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    @Test
    void gerenteComSalarioExatamente5000DeveTer30Porcento() {
        // 5000 * 0.7 = 3500
        Funcionario f = new Funcionario("Carlos", "c@a.com", 5000, Cargo.GERENTE);
        assertEquals(3500.0, calc.calcularSalarioLiquido(f), 0.01);
    }

    // teste extra pra cobrir os getters
    @Test
    void funcionarioDeveGuardarOsDadosCorretamente() {
        Funcionario f = new Funcionario("Joao", "j@a.com", 3000, Cargo.DESENVOLVEDOR);
        assertEquals("Joao", f.getNome());
        assertEquals("j@a.com", f.getEmail());
        assertEquals(3000.0, f.getSalarioBase(), 0.01);
        assertEquals(Cargo.DESENVOLVEDOR, f.getCargo());
    }
}
