public class Evento {
    private String descricao;
    private double mudancaDinheiro;
    private int mudancaSaude;
    private int mudancaSatisfacao;
    private int mudancaInteligencia;

    public Evento(String descricao, double mudancaDinheiro, int mudancaSaude, int mudancaSatisfacao, int mudancaInteligencia) {
        this.descricao = descricao;
        this.mudancaDinheiro = mudancaDinheiro;
        this.mudancaSaude = mudancaSaude;
        this.mudancaSatisfacao = mudancaSatisfacao;
        this.mudancaInteligencia = mudancaInteligencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getMudancaDinheiro() {
        return mudancaDinheiro;
    }

    public int getMudancaSaude() {
        return mudancaSaude;
    }

    public int getMudancaSatisfacao() {
        return mudancaSatisfacao;
    }

    public int getMudancaInteligencia() {
        return mudancaInteligencia;
    }
}
