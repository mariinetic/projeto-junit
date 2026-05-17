package exercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOTest {

    private PersonDAO dao;

    @BeforeEach
    void setUp() {
        dao = new PersonDAO();
    }

    // metodo auxiliar pra nao ficar repetindo codigo nos testes
    private Person criarPessoaValida() {
        Person p = new Person(1, "Joao Silva", 25);
        p.addEmail(new Email(1, "joao@email.com"));
        return p;
    }

    @Test
    void pessoaValidaNaoDeveTerErros() {
        Person p = criarPessoaValida();
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    // -- testes do nome --

    @Test
    void nomeComUmaSoParteDeveDarErro() {
        Person p = new Person(1, "Joao", 25);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.contains("Nome deve ter pelo menos 2 partes"));
    }

    @Test
    void nomeComNumeroDeveDarErro() {
        Person p = new Person(1, "Joao123 Silva", 25);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.contains("Nome deve conter apenas letras"));
    }

    @Test
    void nomeComCaractereEspecialDeveDarErro() {
        Person p = new Person(1, "Joao@ Silva", 25);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.contains("Nome deve conter apenas letras"));
    }

    @Test
    void nomeVazioDeveDarErro() {
        Person p = new Person(1, "", 25);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.contains("Nome nao pode ser vazio"));
    }

    @Test
    void nomeComAcentoDeveSerValido() {
        Person p = new Person(1, "João Conceição", 25);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    // -- testes da idade --

    @Test
    void idadeZeroDeveDarErro() {
        Person p = new Person(1, "Joao Silva", 0);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.contains("Idade deve estar entre 1 e 200"));
    }

    @Test
    void idadeNegativaDeveDarErro() {
        Person p = new Person(1, "Joao Silva", -5);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.contains("Idade deve estar entre 1 e 200"));
    }

    @Test
    void idadeMaiorQue200DeveDarErro() {
        Person p = new Person(1, "Joao Silva", 201);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.contains("Idade deve estar entre 1 e 200"));
    }

    @Test
    void idadeIgualA1DeveSerValida() {
        Person p = new Person(1, "Joao Silva", 1);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    @Test
    void idadeIgualA200DeveSerValida() {
        Person p = new Person(1, "Joao Silva", 200);
        p.addEmail(new Email(1, "joao@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    // -- testes do email --

    @Test
    void pessoaSemEmailDeveDarErro() {
        Person p = new Person(1, "Joao Silva", 25);
        // nao adiciona nenhum email
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.contains("Pessoa deve ter pelo menos 1 email"));
    }

    @Test
    void emailSemArrobaDeveDarErro() {
        Person p = new Person(1, "Joao Silva", 25);
        p.addEmail(new Email(1, "joaoemail.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertFalse(erros.isEmpty());
    }

    @Test
    void emailSemPontoDeveDarErro() {
        Person p = new Person(1, "Joao Silva", 25);
        p.addEmail(new Email(1, "joao@emailcom"));
        List<String> erros = dao.isValidToInclude(p);
        assertFalse(erros.isEmpty());
    }

    @Test
    void emailSemPartePreArrobaDeveDarErro() {
        Person p = new Person(1, "Joao Silva", 25);
        p.addEmail(new Email(1, "@email.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertFalse(erros.isEmpty());
    }

    @Test
    void emailSemDominioDeveDarErro() {
        Person p = new Person(1, "Joao Silva", 25);
        p.addEmail(new Email(1, "joao@.com"));
        List<String> erros = dao.isValidToInclude(p);
        assertFalse(erros.isEmpty());
    }

    @Test
    void emailSemFinalDeveDarErro() {
        Person p = new Person(1, "Joao Silva", 25);
        p.addEmail(new Email(1, "joao@email."));
        List<String> erros = dao.isValidToInclude(p);
        assertFalse(erros.isEmpty());
    }

    @Test
    void pessoaComMaisDeUmEmailValido() {
        Person p = new Person(1, "Joao Silva", 25);
        p.addEmail(new Email(1, "joao@email.com"));
        p.addEmail(new Email(2, "j@a.b")); // tambem eh valido, cada parte tem 1+ caractere
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    // teste pra ver se acumula varios erros
    @Test
    void pessoaTotalmenteInvalidaDeveAcumularErros() {
        Person p = new Person(1, "X", -1);
        // sem email tbm
        List<String> erros = dao.isValidToInclude(p);
        assertTrue(erros.size() >= 3); // pelo menos 3 erros: nome, idade e email
    }

    // teste do save (so pra cobertura)
    @Test
    void saveNaoDeveLancarExcecao() {
        Person p = criarPessoaValida();
        assertDoesNotThrow(() -> dao.save(p));
    }
}
