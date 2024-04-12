package Sorveteria;

public abstract class Pagamento {
    public double valor;
    public abstract double gerar(double valor);

    public abstract String metodoPagamento();
}
