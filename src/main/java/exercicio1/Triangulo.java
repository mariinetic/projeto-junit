package exercicio1;

public class Triangulo {

    public String classificar(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return "NAO_E_TRIANGULO";
        }
        // se for igual ou menor, nao forma triangulo
        if (a + b <= c) return "NAO_E_TRIANGULO";
        if (a + c <= b) return "NAO_E_TRIANGULO";
        if (b + c <= a) return "NAO_E_TRIANGULO";

        if (a == b && b == c) {
            return "EQUILATERO";
        }

        if (a == b || a == c || b == c) {
            return "ISOSCELES";
        }
        return "ESCALENO";
    }
}
