package Sorveteria;

public class Pedido {
    private Sorvete sorvete;
    private Cliente cliente;
    private Funcionario funcionario;

    private Pagamento pagamento;

    public Pedido(Sorvete sorvete, Cliente cliente, Funcionario funcionario, Pagamento pagamento){
        this.sorvete = sorvete;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pagamento = pagamento;
    }

    public void mostrarRecibo() {
        System.out.println("---------------------");
        System.out.println("Seu recibo do pedido: ");
        System.out.println("---------------------");
        System.out.println("Sorvete: " + sorvete.getSabor() + ", Tamanho: " + sorvete.getTamanho());
        System.out.println("Preço: " + sorvete.getPreco() + " reais");
        System.out.println("Cliente: " + cliente.getNome() + ", CPF: " + cliente.getCPF());
        System.out.println("Atendente: " + funcionario.getNome());
        funcionario.setComissao(sorvete.getPreco());
        System.out.println("Comissão do atendente: " + funcionario.getComissao());
        System.out.println("Método de pagamento: " + pagamento.metodoPagamento());
        System.out.println("Valor pago: " + pagamento.gerar(sorvete.getPreco()));
        System.out.println("---------------------");
        System.out.println("Obrigado, volte sempre! A sorveteria alegria agradece a preferência :)");
    }

}
