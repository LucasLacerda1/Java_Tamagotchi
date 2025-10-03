public class Lazer {
    private String nome;
    private double custoDinheiro;
    private int custoEnergia;
    private int ganhoSatisfacao;
    private int ganhoSaude;
    private int idadeMinima;

    public Lazer(String nome, double custoDinheiro, int custoEnergia, int ganhoSatisfacao, int ganhoSaude, int idadeMinima) {
        this.nome = nome;
        this.custoDinheiro = custoDinheiro;
        this.custoEnergia = custoEnergia;
        this.ganhoSatisfacao = ganhoSatisfacao;
        this.ganhoSaude = ganhoSaude;
        this.idadeMinima = idadeMinima;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoDinheiro() {
        return custoDinheiro;
    }

    public int getCustoEnergia() {
        return custoEnergia;
    }

    public int getGanhoSatisfacao() {
        return ganhoSatisfacao;
    }

    public int getGanhoSaude() {
        return ganhoSaude;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }
}
