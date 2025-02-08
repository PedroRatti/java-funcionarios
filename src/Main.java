import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 3.1 - Criar lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 Remover João
        FuncionariosService.removerFuncionario(funcionarios, "João");

        // 3.3 Imprimir funcionários formatados
        FuncionariosService.imprimirFuncionarios(funcionarios);

        // 3.4 Aumento de 10% no salário
        FuncionariosService.aumentarSalario(funcionarios, new BigDecimal("0.10"));

        // 3.5 Agrupar por função e imprimir
        Map<String, List<Funcionario>> grupo = FuncionariosService.agruparPorFuncao(funcionarios);
        FuncionariosService.imprimirFuncionariosPorFuncao(grupo);

        // 3.8 Aniversariantes de outubro e dezembro
        FuncionariosService.imprimirAniversariantes(funcionarios);

        // 3.9 Funcionário mais velho
        FuncionariosService.imprimirMaisVelho(funcionarios);

        // 3.10 Ordem alfabética
        FuncionariosService.ordenarPorNome(funcionarios);
        FuncionariosService.imprimirFuncionarios(funcionarios);

        // 3.11 Somar salários
        System.out.println("Montante total: " + FuncionariosService.somarSalarios(funcionarios));

        // 3.12 Calcular quantos salários mínimos cada funcionário recebe
        FuncionariosService.calcularSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }
}
