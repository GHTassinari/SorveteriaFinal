package Sorveteria;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Pagamento p1 = new Dinheiro();
            Pagamento p2 = new Cartao();

            int opcaoPagamento = 0;

            String stringSabor = "";
            String stringTamanho = "";

            Scanner scanner = new Scanner(System.in);

            System.out.println("----------------------------------------------------");
            System.out.println("Seja bem vindo a sorveteria alegria");
            System.out.println("////////////////////////////////////////////////////");
            System.out.println("----------------------------------------------------");

            System.out.println("Opções de sabores:");
            System.out.println("1 - Napolitano");
            System.out.println("2 - Creme");
            System.out.println("3 - Chocolate");
            System.out.println("----------------------------------------------------");

            System.out.println("Informe o sabor do sorvete (1 - Napolitano, 2 - Creme, 3 - Chocolate): ");
            int saborEscolha = scanner.nextInt();
            if (saborEscolha < 1 || saborEscolha > 3) {
                throw new IllegalArgumentException("Erro: Opção de sabor inválida.");
            }

            System.out.println("Opções de tamanho:");
            System.out.println("1 - Pequeno");
            System.out.println("2 - Médio");
            System.out.println("3 - Grande");
            System.out.println("----------------------------------------------------");
            System.out.println("Pequeno = 5 reais, Médio = 6 reais, Grande = 7 reais");
            System.out.println("----------------------------------------------------");
            System.out.println("Informe o tamanho do sorvete, sendo os códigos (1 - Pequeno, 2 - Médio, 3 - Grande): ");
            int tamanhoEscolha = scanner.nextInt();
            if (tamanhoEscolha < 1 || tamanhoEscolha > 3) {
                throw new IllegalArgumentException("Erro: Opção de tamanho inválida.");
            }

            Sorvete s1 = new Sorvete();

            switch (saborEscolha) {
                case 1:
                    stringSabor = "Napolitano";
                    break;
                case 2:
                    stringSabor = "Creme";
                    break;
                case 3:
                    stringSabor = "Chocolate";
                    break;
            }

            switch (tamanhoEscolha) {
                case 1:
                    stringTamanho = "Pequeno";
                    s1.setPreco(5);
                    break;
                case 2:
                    stringTamanho = "Médio";
                    s1.setPreco(6);
                    break;
                case 3:
                    stringTamanho = "Grande";
                    s1.setPreco(7);
                    break;
            }

            System.out.println("-----------------------------");
            System.out.println("Caso o pagamento seja no cartão, terá 5% de taxa");
            System.out.println("E o valor da taxa será arredondado para uma casa decimal!");
            System.out.println("Caso seja no dinheiro, não haverá taxas");
            System.out.println("Qual será o método de pagamento?");
            System.out.println("----------------------------------------------------");
            System.out.println("Informe o método de pagamento (1 - Dinheiro, 2 - Cartão): ");
            int pagamentoEscolha = scanner.nextInt();
            if (pagamentoEscolha != 1 && pagamentoEscolha != 2) {
                throw new IllegalArgumentException("Erro: Opção de pagamento inválida.");
            }

            switch (pagamentoEscolha) {
                case 1:
                    p1.gerar(s1.getPreco());
                    opcaoPagamento = 1;
                    break;
                case 2:
                    p2.gerar(s1.getPreco());
                    opcaoPagamento = 2;
                    break;
            }
            s1.fazerSorvete(stringSabor, stringTamanho);

            System.out.println("-------------------");
            System.out.println("Informe os onze dígitos do seu CPF para o recibo: ");
            String cpfCliente = scanner.next();

            try {
                Long.parseLong(cpfCliente);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Erro: O CPF deve conter apenas números.");
            }

            if (cpfCliente.length() != 11) {
                throw new IllegalArgumentException("Erro: A quantidade de dígitos do CPF está incorreta. O CPF deve conter exatamente nove dígitos.");
            }

            System.out.println("Informe seu primeiro nome: ");
            String nomeCliente = scanner.next();


            if (nomeCliente.matches(".*\\d.*")) {
                throw new IllegalArgumentException("Erro: O nome não pode conter números.");
            }

            Cliente c1 = new Cliente(nomeCliente, cpfCliente);

            System.out.println("---------------------");
            System.out.println("Informe o primeiro nome do atendente: ");
            String nomeAtendente = scanner.next();

            if (nomeAtendente.matches(".*\\d.*")) {
                throw new IllegalArgumentException("Erro: O nome não pode conter números.");
            }

            Funcionario f1 = new Funcionario(nomeAtendente);

            Pedido pe1;
            if (opcaoPagamento == 1) {
                pe1 = new Pedido(s1, c1, f1, p1);
            } else if (opcaoPagamento == 2) {
                pe1 = new Pedido(s1, c1, f1, p2);
            } else {
                throw new IllegalArgumentException("Erro ao criar o pedido. Verifique as informações fornecidas.");
            }

            pe1.mostrarRecibo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Desligando o programa...");
        }
    }
}
