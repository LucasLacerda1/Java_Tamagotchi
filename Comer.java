public class Comida {
    private String nome;
    private double preco;
    private int valorEnergia;
    private int valorSatisfacao;

    public Comida(String nome, double preco, int valorEnergia, int valorSatisfacao) {
        this.nome = nome;
        this.preco = preco;
        this.valorEnergia = valorEnergia;
        this.valorSatisfacao = valorSatisfacao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getValorEnergia() {
        return valorEnergia;
    }

    public int getValorSatisfacao() {
        return valorSatisfacao;
    }
}
