public class Produto {
    private int codigo, quantidade;
    private double preco;
    private String nome;

    public Produto(int codigo, double preco, String nome) {
        this.codigo = codigo;
        this.quantidade = 0;
        this.preco = preco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean entradaEstoque(int quantidade) {
        if(quantidade > 0) {
            this.quantidade += quantidade;
            return true;
        }else{
            return false;
        }
    }

    public boolean saidaEstoque(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            return true;
        } else {
            return false;
        }
    }

    public String emitirRelatorio() {
        return "Nome do Produto: " + this.nome + "\n" +
                "Codigo do Produto: " + this.codigo + "\n" +
                "Quantidade do Produto: " + this.quantidade + "\n" +
                "Preco do Produto: " + this.preco + "\n";
    }
}