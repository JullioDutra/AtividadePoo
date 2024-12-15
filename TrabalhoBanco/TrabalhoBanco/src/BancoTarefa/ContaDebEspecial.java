package BancoTarefa;

public class ContaDebEspecial extends ContaEspecial {

    public ContaDebEspecial(int numero, double limite) {
        super(numero, limite);
    }

    @Override
    public void debitar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            System.out.println("Débito realizado: " + valor);
        } else {
            System.out.println("Limite e saldo insuficientes para o débito de " + valor);
        }
    }
}
