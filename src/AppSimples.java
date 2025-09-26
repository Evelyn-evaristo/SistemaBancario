import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AppSimples {
    static Scanner scanner = new Scanner(System.in);
    static List<String> extrato = new ArrayList<>();
    // variaveis globais 
    static float saldo = 200.0f;
    static float saque = 0.0f;

    static class Texto {
        String desejo = "\nDigite o valor desejado do saque:";
        String menu = """
        \n
                Por favor insira uma das opções desejadas:
                1 - Sacar
                2 - Depositar
                3 - Consultar saldo
                4 - Emitir Extrato
                0 - Sair
                """;
        String insuficiente = "\nSaldo Insuficiente. Deposite a quantia desejada";
        String digite = "\nDigite a quantia desejada";
        String atualizado = "\nTudo certo. Já foi atualizado!!!";
        String erro = "\nHouve um erro";
    }
    
static Texto textos = new Texto();

    // Funções
    static void sacar(){
        if (saldo<0) {
            System.out.println(textos.insuficiente);
        }else {
                System.out.println(textos.digite); {
                    float saque = scanner.nextFloat();
                    if (saque > saldo){
                        System.out.println(textos.insuficiente);
                    }else{
                        saldo -= saque;
                        extrato.add("Saque: -" + saque);
                        System.out.println(textos.atualizado);
                    }
                }
        }
    }

    static void depositar(){
        System.out.println(textos.digite);
        float deposito = scanner.nextFloat();
        if (deposito < 0){
            System.out.println(textos.erro);
        } else {
            extrato.add("Depósito: +" + deposito);
            saldo += deposito;
            System.out.println(textos.atualizado);
        }
    }

    static void consultarSaldo(){
        System.out.println(saldo);
    }

    static void exibirExtrato(){
        System.out.println("=== Extrato ===");
        if (extrato.isEmpty()){
            System.out.println("Nenhuma movimentação registrada.");
        } else {
            for (String mov : extrato) {
                System.out.println(mov);
        }
    }
}

    public static void main(String[] args){
    int opcao;
        do {
        System.out.println(textos.menu);
         opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                sacar();
                break;

            case 2:
                depositar();
                break;
            
            case 3:
            System.out.println("\n");
                System.out.println(saldo);
                break;
            case 4:
            System.out.println("\n");
                exibirExtrato();
                break;
            case 0:
            System.out.println("\n");
                System.out.println("Obrigada... Tchau");
                break;
            default:
            System.out.println("\n");
                System.out.println("Opção Inválida");
                break;
        }
    }
     while (opcao != 0);
}
    }
