package Sorveteria;

public class Cliente extends Pessoa {

    public String CPF;
    public Cliente(String nome, String CPF) {
        super(nome);
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }
}
