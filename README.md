# Projeto JUnit + TDD

Projeto com 3 exercícios usando Java, JUnit 5 e JaCoCo pra cobertura.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+

## Estrutura

```
src/
├── main/java/
│   ├── exercicio1/   -> Triangulo
│   ├── exercicio2/   -> Person, Email, PersonDAO
│   └── exercicio3/   -> Cargo, Funcionario, CalculadoraSalario
└── test/java/
    ├── exercicio1/   -> TrianguloTest
    ├── exercicio2/   -> PersonDAOTest
    └── exercicio3/   -> CalculadoraSalarioTest
```

## Como rodar (build + testes)

Pra compilar:
```bash
mvn compile
```

Pra rodar os testes:
```bash
mvn test
```

Pra rodar tudo de uma vez (build + test + relatório de cobertura):
```bash
mvn clean test
```

## Como ver o relatório de cobertura (JaCoCo)

Depois de rodar `mvn test`, o relatório fica em:
```
target/site/jacoco/index.html
```

É só abrir esse arquivo no navegador pra ver os percentuais de cobertura.

<img width="686" height="247" alt="image" src="https://github.com/user-attachments/assets/2f470e31-0ab0-4c5b-bc29-00aa43df3ea3" />
<img width="813" height="133" alt="image" src="https://github.com/user-attachments/assets/027d2e92-bd6b-4025-bc63-3dcfb44c2bda" />


## Exercícios

### Exercício 1 - Triângulo

Classifica 3 lados de um triângulo em **EQUILÁTERO**, **ISÓSCELES** ou **ESCALENO**. Se a soma de 2 lados não for maior que o terceiro, ou se algum lado for zero/negativo, retorna **NAO_E_TRIANGULO**.

**Casos de teste cobertos:**
- Escaleno, isósceles e equilátero válidos
- 3 permutações de isósceles (5,5,3 / 5,3,5 / 3,5,5)
- Um valor zero
- Um valor negativo
- Soma de 2 lados igual ao terceiro (3 permutações)
- Soma de 2 lados menor que o terceiro (3 permutações)
- Três valores iguais a zero

**Evidência de cobertura:**

> _Cole aqui o print do relatório do JaCoCo (target/site/jacoco/index.html) referente ao pacote `exercicio1`._

### Exercício 2 - PersonDAO.isValidToInclude

Valida um objeto `Person` retornando uma lista de erros. As validações são:

- Nome: pelo menos 2 partes, só letras (aceita acento)
- Idade: entre 1 e 200
- Pelo menos 1 email associado
- Email no formato `___@___.___` (cada parte com 1+ caractere)

**Casos de teste cobertos:**
- Pessoa válida (sem erros)
- Nome com 1 parte / com número / com caractere especial / vazio / com acento
- Idade 0 / negativa / maior que 200 / nas bordas (1 e 200)
- Sem email
- Email mal formatado (sem @, sem ., sem parte antes do @, sem domínio, sem TLD)
- Múltiplos emails
- Pessoa com vários erros acumulados
- Teste do `save()` (não lança exceção)

**Evidência de cobertura:**

> _Cole aqui o print do relatório do JaCoCo referente ao pacote `exercicio2`._

### Exercício 3 - Calculadora de Salário

Calcula o salário líquido de um funcionário aplicando o desconto conforme o cargo:

| Cargo         | Salário >= X    | Desconto | Senão |
|---------------|-----------------|----------|-------|
| DESENVOLVEDOR | 3000            | 20%      | 10%   |
| DBA           | 2000            | 25%      | 15%   |
| TESTADOR      | 2000            | 25%      | 15%   |
| GERENTE       | 5000            | 30%      | 20%   |

**Casos de teste cobertos:**
- Cada cargo com salário acima do limite (desconto maior)
- Cada cargo com salário abaixo do limite (desconto menor)
- Cada cargo no valor exato de borda (entra no desconto maior)
- Getters do `Funcionario`

**Evidência de cobertura:**

> _Cole aqui o print do relatório do JaCoCo referente ao pacote `exercicio3`._

## Observação sobre TDD

Os exercícios 2 e 3 foram desenvolvidos seguindo a ideia do TDD: pensei primeiro nos casos de teste a partir do enunciado, escrevi os testes e depois fui implementando a classe até todos passarem. No exercício 1, escrevi a classe e os testes em paralelo, já que a lógica era bem direta.
