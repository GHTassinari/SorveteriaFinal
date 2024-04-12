package Sorveteria;

public class Sorvete implements MaquinaDeSorvete {
    private double preco;
    private String sabor;
    private String tamanho;

    public void fazerSorvete(String sabor, String tamanho){
        this.sabor = sabor;
        this.tamanho = tamanho;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public String getSabor() {
        return sabor;
    }

    public String getTamanho() {
        return tamanho;
    }
}
