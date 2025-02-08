import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionariosService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getInstance(Locale.GERMANY);

    // 3.2 - Remover funcionário "João"
    public static void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome));
    }

    // 3.3 - Imprimir funcionários formatados
    public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome()
                    + ", Data Nascimento: " + f.getDataNascimento().format(DATE_FORMATTER)
                    + ", Salário: R$ " + CURRENCY_FORMATTER.format(f.getSalario())
                    + ", Função: " + f.getFuncao());
        }
    }

    // 3.4 - Aumentar salário em 10%
    public static void aumentarSalario(List<Funcionario> funcionarios, BigDecimal percentual) {
        for (Funcionario f : funcionarios) {
            BigDecimal aumento = f.getSalario().multiply(percentual);
            f.setSalario(f.getSalario().add(aumento));
        }
    }

    // 3.5 - Agrupar funcionários por função
    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    // 3.6 - Imprimir funcionários agrupados por função
    public static void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> mapa) {
        mapa.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
        });
    }

    // 3.8 - Imprimir funcionários que fazem aniversário em Outubro (10) e Dezembro (12)
    public static void imprimirAniversariantes(List<Funcionario> funcionarios) {
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .collect(Collectors.toList());

        imprimirFuncionarios(aniversariantes);
    }

    // 3.9 - Imprimir o funcionário mais velho
    public static void imprimirMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (maisVelho != null) {
            int idade = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
            System.out.println("Funcionário mais velho: " + maisVelho.getNome() + ", Idade: " + idade);
        }
    }

    // 3.10 - Ordenar funcionários por nome
    public static void ordenarPorNome(List<Funcionario> funcionarios) {
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
    }

    // 3.11 - Somar total de salários
    public static BigDecimal somarSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 3.12 - Calcular quantos salários mínimos cada funcionário ganha
    public static void calcularSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalarios = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " recebe " + qtdSalarios + " salários mínimos.");
        }
    }
}
