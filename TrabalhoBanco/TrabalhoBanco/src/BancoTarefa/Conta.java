package BancoTarefa;

public abstract class Conta {
    protected int numero;
    protected double saldo;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) {
        saldo += valor;
    }

    public abstract void debitar(double valor);

    @Override
    public String toString() {
        return "Conta " + numero + " - Saldo: " + saldo;
    }
}
