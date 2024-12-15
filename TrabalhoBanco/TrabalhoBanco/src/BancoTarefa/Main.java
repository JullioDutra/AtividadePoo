package BancoTarefa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        // Menu interativo
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Creditar em conta");
            System.out.println("4 - Debitar de conta");
            System.out.println("5 - Transferir dinheiro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    banco.criarContaInterativa();  // Função que cria uma nova conta
                    break;
                case 2:
                    banco.listarContas();  // Lista todas as contas
                    break;
                case 3:
                    System.out.print("Digite o número da conta: ");
                    int numContaCredito = scanner.nextInt();
                    System.out.print("Digite o valor a ser creditado: ");
                    double valorCredito = scanner.nextDouble();
                    banco.creditar(numContaCredito, valorCredito);  // Credita valor na conta
                    break;
                case 4:
                    System.out.print("Digite o número da conta: ");
                    int numContaDebito = scanner.nextInt();
                    System.out.print("Digite o valor a ser debitado: ");
                    double valorDebito = scanner.nextDouble();
                    banco.debitar(numContaDebito, valorDebito);  // Debita valor da conta
                    break;
                case 5:
                    banco.transferir();  // Função para transferir dinheiro entre contas
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;  // Encerra o programa
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
