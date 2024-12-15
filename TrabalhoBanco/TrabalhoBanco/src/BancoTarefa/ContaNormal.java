package BancoTarefa;

public class ContaNormal extends Conta {

    public ContaNormal(int numero) {
        super(numero);
    }

    @Override
    public void debitar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
