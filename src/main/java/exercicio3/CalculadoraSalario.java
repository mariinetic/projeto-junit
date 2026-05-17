package exercicio3;

public class CalculadoraSalario {

    public double calcularSalarioLiquido(Funcionario f) {
        double salario = f.getSalarioBase();
        double desconto = 0;

        // pra cada cargo a regra muda
        if (f.getCargo() == Cargo.DESENVOLVEDOR) {
            if (salario >= 3000) {
                desconto = 0.20;
            } else {
                desconto = 0.10;
            }
        } else if (f.getCargo() == Cargo.DBA || f.getCargo() == Cargo.TESTADOR) {
            // DBA e TESTADOR tem a mesma regra
            if (salario >= 2000) {
                desconto = 0.25;
            } else {
                desconto = 0.15;
            }
        } else if (f.getCargo() == Cargo.GERENTE) {
            if (salario >= 5000) {
                desconto = 0.30;
            } else {
                desconto = 0.20;
            }
        }

        // calcula o salario liquido aplicando o desconto
        return salario - (salario * desconto);
    }
}
