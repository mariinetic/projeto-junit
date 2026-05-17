# Projeto JUnit + TDD

Projeto com 3 exercícios usando Java, JUnit 5 e JaCoCo para cobertura de testes.

---

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+

---

## Estrutura do projeto

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

---

## Como rodar (build + testes)

Compilar o projeto:

```bash
mvn compile
```

Rodar os testes:

```bash
mvn test
```

Rodar tudo de uma vez (build + testes + relatório de cobertura):

```bash
mvn clean test
```

<p align="center">
  <img width="686" height="247" alt="image" src="https://github.com/user-attachments/assets/2f470e31-0ab0-4c5b-bc29-00aa43df3ea3" />
</p>

<p align="center">
  <img width="745" height="154" alt="image" src="https://github.com/user-attachments/assets/c10e1bb0-56a7-47d2-bc25-0e43dd829a0b" />
</p>

---

## Exercícios

### Exercício 1 — Triângulo

Classifica 3 lados de um triângulo em **EQUILÁTERO**, **ISÓSCELES** ou **ESCALENO**. Se a soma de 2 lados não for maior que o terceiro, ou se algum lado for zero/negativo, retorna **NAO_E_TRIANGULO**.

**Casos de teste cobertos:**

- Escaleno, isósceles e equilátero válidos
- 3 permutações de isósceles (`5,5,3` / `5,3,5` / `3,5,5`)
- Um valor zero
- Um valor negativo
- Soma de 2 lados igual ao terceiro (3 permutações)
- Soma de 2 lados menor que o terceiro (3 permutações)
- Três valores iguais a zero

**Evidência de cobertura:**

<p align="center">
  <img width="348" height="63" alt="image" src="https://github.com/user-attachments/assets/3dc939b3-3760-4a7f-9132-0be10d8333c5" />
</p>

<p align="center">
  <img width="748" height="131" alt="Captura de tela 2026-05-17 134033" src="https://github.com/user-attachments/assets/6952ef91-8234-4789-917c-c7d262488048" />
</p>

---

### Exercício 2 — `PersonDAO.isValidToInclude`

Valida um objeto `Person` retornando uma lista de erros. As validações são:

- **Nome:** pelo menos 2 partes, só letras (aceita acento)
- **Idade:** entre 1 e 200
- **Email:** pelo menos 1 email associado, no formato `___@___.___` (cada parte com 1+ caractere)

**Casos de teste cobertos:**

- Pessoa válida (sem erros)
- Nome com 1 parte / com número / com caractere especial / vazio / com acento
- Idade 0 / negativa / maior que 200 / nas bordas (1 e 200)
- Sem email
- Email mal formatado (sem `@`, sem `.`, sem parte antes do `@`, sem domínio, sem TLD)
- Múltiplos emails
- Pessoa com vários erros acumulados
- Teste do `save()` (não lança exceção)

**Evidência de cobertura:**

<p align="center">
  <img width="337" height="87" alt="image" src="https://github.com/user-attachments/assets/f8464575-5cef-4a7a-860c-9288200b1587" />
</p>

<p align="center">
  <img width="769" height="162" alt="Captura de tela 2026-05-17 134042" src="https://github.com/user-attachments/assets/01b7f7c9-fff4-4eab-8f93-e17935bfa655" />
</p>

---

### Exercício 3 — Calculadora de Salário

Calcula o salário líquido de um funcionário aplicando o desconto conforme o cargo:

| Cargo         | Salário ≥ X | Desconto | Senão |
|---------------|-------------|----------|-------|
| DESENVOLVEDOR | 3000        | 20%      | 10%   |
| DBA           | 2000        | 25%      | 15%   |
| TESTADOR      | 2000        | 25%      | 15%   |
| GERENTE       | 5000        | 30%      | 20%   |

**Casos de teste cobertos:**

- Cada cargo com salário acima do limite (desconto maior)
- Cada cargo com salário abaixo do limite (desconto menor)
- Cada cargo no valor exato de borda (entra no desconto maior)
- Getters do `Funcionario`

**Evidência de cobertura:**

<p align="center">
  <img width="339" height="100" alt="image" src="https://github.com/user-attachments/assets/c52b7739-6389-4ac8-97c5-54e2f84faed7" />
</p>

<p align="center">
  <img width="793" height="160" alt="Captura de tela 2026-05-17 134051" src="https://github.com/user-attachments/assets/a33b1aa2-96e8-4e65-a336-88e320b5e312" />
</p>

---

## Observação sobre TDD

Os exercícios 2 e 3 foram desenvolvidos seguindo a ideia do TDD: pensei primeiro nos casos de teste a partir do enunciado, escrevi os testes e depois fui implementando a classe até todos passarem. No exercício 1, escrevi a classe e os testes em paralelo, já que a lógica era bem direta.

<p align="center">
  <img width="1365" height="696" alt="image" src="https://github.com/user-attachments/assets/e21e5ff6-faa5-4d27-be68-07a615202794" />
</p>
