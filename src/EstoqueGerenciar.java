import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EstoqueGerenciar {
    public List<Produto> listaDeProdutos = new ArrayList<>();

    public static void main(String[] args){
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        EstoqueGerenciar estoqueGerenciar = new EstoqueGerenciar();
        do{
            System.out.println("Menu Principal");
            System.out.println("1 - Cadastrar um novo Produto");
            System.out.println("2 - Realizar entrada de mercadoria");
            System.out.println("3 - Realizar saida de mercadoria");
            System.out.println("4 - Consultar informações de um produto");
            System.out.println("5 - Mostrar o relatório de todos os produtos");
            System.out.println("9. Sair");
            System.out.println("Escolha sua opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1 -> estoqueGerenciar.cadastrarProduto();
                case 2 -> estoqueGerenciar.entradaMercadoria();
                case 3 -> estoqueGerenciar.saidaMercadoria();
                case 4 -> estoqueGerenciar.consultarProduto();
                case 5 -> estoqueGerenciar.consultarTodosProdutos();
                case 9 -> System.out.println("Fim do Programa");
                default -> System.out.println("Opcao invalida\n");
            }
        }while(opcao!=9);
    }
    public void cadastrarProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do Produto: ");
        int codigoPod = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o nome do Produto: ");
        String nomePod = sc.nextLine();
        System.out.println("Digite o preço do Produto: ");
        double precoPod = Double.parseDouble(sc.nextLine());
        Produto produto = new Produto(codigoPod,precoPod,nomePod);
        listaDeProdutos.add(produto);
        System.out.println("Produto: " + nomePod + " Cadastrado com Sucesso!\n");
    }
    public void entradaMercadoria(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Código do produto: ");
        int codigoPod = Integer.parseInt(sc.nextLine());
        for(Produto produto: listaDeProdutos){
            if(produto.getCodigo() == codigoPod){
                System.out.println("Produto: " + produto.getNome() + " selecionado com sucesso!");
                System.out.println("Digite a quantidade de mercadoria que vai ser adicionada: ");
                int quantidadePod = Integer.parseInt(sc.nextLine());
                boolean ok = produto.entradaEstoque(quantidadePod);
                if(ok){
                    System.out.println(quantidadePod + " " + produto.getNome() + " Adicionado(s) com Sucesso\n");
                }else{
                    System.out.println("Quantidade Inválida!");
                }
            }
        }
    }
    public void saidaMercadoria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Código do produto: ");
        int codigoPod = Integer.parseInt(sc.nextLine());
        for (Produto produto : listaDeProdutos) {
            if (produto.getCodigo() == codigoPod) {
                System.out.println("Produto: " + produto.getNome() + " selecionado com sucesso!");
                System.out.println("Digite a quantidade de mercadoria que vai ser retirado: ");
                int quantidadePod = Integer.parseInt(sc.nextLine());
                boolean ok = produto.saidaEstoque(quantidadePod);
                if (ok) {
                    System.out.println(quantidadePod + " " + produto.getNome() + " retirado(s) com Sucesso\n");
                } else {
                    System.out.println("a quantidade que você está tentando retirar é maior que a quantidade que temos em estoque\n");
                }
            }
        }
    }

        public void consultarProduto(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o Código do produto: ");
            int codigoPod = Integer.parseInt(sc.nextLine());
            boolean prodEncontrado = false;
            for(Produto produto: listaDeProdutos) {
                if(produto.getCodigo() == codigoPod) {
                    System.out.println(produto.emitirRelatorio());
                    prodEncontrado = true;
                }
            }
            if(!prodEncontrado){
                System.out.println("produto não encontrado!\n");
            }

        }

    public void consultarTodosProdutos(){
            for (Produto produto : listaDeProdutos) {
                System.out.println("================================");
                System.out.println(produto.emitirRelatorio());
            }
    }
}





