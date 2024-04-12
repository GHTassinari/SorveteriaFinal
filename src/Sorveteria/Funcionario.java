package Sorveteria;

public class Funcionario extends Pessoa{
    public String nome;
    public double comissao;

    public Funcionario(String nome){
        super(nome);
    }

    public void setComissao(double valor) {
        double novaComissao = valor * 0.05;

        novaComissao = Math.round(novaComissao * 100.0) / 100.0;

        this.comissao = novaComissao;
    }

    public double getComissao() {
        return comissao;
    }
}
