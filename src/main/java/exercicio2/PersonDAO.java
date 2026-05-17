package exercicio2;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void save(Person p) {
        System.out.println("Pessoa salva: " + p.getName());
    }

    public List<String> isValidToInclude(Person p) {
        List<String> erros = new ArrayList<>();

        // 1) valida o nome
        if (p.getName() == null || p.getName().trim().isEmpty()) {
            erros.add("Nome nao pode ser vazio");
        } else {
            // separa o nome por espaco pra ver se tem pelo menos 2 partes
            String[] partes = p.getName().trim().split("\\s+");
            if (partes.length < 2) {
                erros.add("Nome deve ter pelo menos 2 partes");
            }

            for (String parte : partes) {
                if (!parte.matches("[a-zA-ZáéíóúâêîôûãõçÁÉÍÓÚÂÊÎÔÛÃÕÇ]+")) {
                    erros.add("Nome deve conter apenas letras");
                    break; // ja achei erro, nao precisa continuar
                }
            }
        }

        // 2) valida a idade (entre 1 e 200)
        if (p.getAge() < 1 || p.getAge() > 200) {
            erros.add("Idade deve estar entre 1 e 200");
        }

        // 3) valida se tem pelo menos 1 email
        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            erros.add("Pessoa deve ter pelo menos 1 email");
        } else {
            // 4) valida o formato de cada email
            for (Email e : p.getEmails()) {
                if (!emailValido(e.getName())) {
                    erros.add("Email invalido: " + e.getName());
                }
            }
        }

        return erros;
    }

    // metodo auxiliar pra validar o formato do email
    // formato: ____@____.____  (cada parte com pelo menos 1 caractere)
    private boolean emailValido(String email) {
        if (email == null) return false;
        // regex: 1 ou mais qualquer coisa (menos @ e .) + @ + algo + . + algo
        return email.matches("[^@.]+@[^@.]+\\.[^@.]+");
    }
}
