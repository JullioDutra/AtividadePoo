package BancoTarefa;

import java.util.Scanner;

public class Banco {
    private AcessoADado acessoADado;
    private Scanner scanner;

    public Banco() {
        acessoADado = new AcessoADado();
        scanner = new Scanner(System.in);
    }

    public void criarConta(Conta conta) {
        acessoADado.adicionarConta(conta);
    }

    public void listarContas() {
        for (Conta conta : acessoADado.getContas()) {
            System.out.println(conta);
        }
    }

    public void creditar(int numeroConta, double valor) {
        Conta conta = acessoADado.buscarConta(numeroConta);
        if (conta != null) {
            conta.creditar(valor);
            System.out.println("Crédito de " + valor + " na conta " + numeroConta);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void debitar(int numeroConta, double valor) {
        Conta conta = acessoADado.buscarConta(numeroConta);
        if (conta != null) {
            conta.debitar(valor);
            System.out.println("Débito de " + valor + " na conta " + numeroConta);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public Conta buscarConta(int numeroConta) {
        return acessoADado.buscarConta(numeroConta);
    }

    public void criarContaInterativa() {
        System.out.println("Selecione o tipo de conta que deseja criar:");
        System.out.println("1 - Conta Normal");
        System.out.println("2 - Conta Especial");
        System.out.println("3 - Conta Débito Especial");
        System.out.print("Digite o número da opção: ");
        
        int tipoConta = scanner.nextInt();
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        Conta novaConta = null;
        
        switch (tipoConta) {
            case 1:
                novaConta = new ContaNormal(numeroConta);
                break;
            case 2:
                System.out.print("Digite o limite da conta especial: ");
                double limite = scanner.nextDouble();
                novaConta = new ContaEspecial(numeroConta, limite);
                break;
            case 3:
                System.out.print("Digite o limite da conta débito especial: ");
                double limiteDebito = scanner.nextDouble();
                novaConta = new ContaDebEspecial(numeroConta, limiteDebito);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        criarConta(novaConta);
        System.out.println("Conta criada com sucesso: " + novaConta);
    }

    // Função para transferir dinheiro entre contas
    public void transferir() {
        System.out.print("Digite o número da conta de origem: ");
        int numContaOrigem = scanner.nextInt();
        System.out.print("Digite o número da conta de destino: ");
        int numContaDestino = scanner.nextInt();
        System.out.print("Digite o valor a ser transferido: ");
        double valorTransferido = scanner.nextDouble();

        Conta contaOrigem = acessoADado.buscarConta(numContaOrigem);
        Conta contaDestino = acessoADado.buscarConta(numContaDestino);

        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Uma das contas não foi encontrada!");
            return;
        }

        if (contaOrigem.getSaldo() >= valorTransferido) {
            contaOrigem.debitar(valorTransferido);
            contaDestino.creditar(valorTransferido);
            System.out.println("Transferência de " + valorTransferido + " realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente na conta de origem!");
        }
    }
}
