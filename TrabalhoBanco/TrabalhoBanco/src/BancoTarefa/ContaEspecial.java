package BancoTarefa;

public class ContaEspecial extends Conta {
    protected double limite;

    public ContaEspecial(int numero, double limite) {
        super(numero);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public void debitar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
        } else {
            System.out.println("Limite e saldo insuficientes!");
        }
    }

    @Override
    public String toString() {
        return "Conta Especial " + numero + " - Saldo: " + saldo + " - Limite: " + limite;
    }
}

