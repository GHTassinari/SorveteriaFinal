package Sorveteria;

public class Dinheiro extends Pagamento{

    @Override
    public double gerar(double valor) {
        double resultado = valor * 1;

        resultado = Math.round(resultado * 100.0) / 100.0;

        return resultado;
    }

    public String metodoPagamento(){
        return "Dinheiro";
    }
}
