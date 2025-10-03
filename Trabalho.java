public class Trabalho {
    private String nome;
    private double salario;
    private int gastoEnergia;
    private int gastoSatisfacao;
    private int requisitoInteligencia;

    public Trabalho(String nome, double salario, int gastoEnergia, int gastoSatisfacao, int requisitoInteligencia) {
        this.nome = nome;
        this.salario = salario;
        this.gastoEnergia = gastoEnergia;
        this.gastoSatisfacao = gastoSatisfacao;
        this.requisitoInteligencia = requisitoInteligencia;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public int getGastoEnergia() {
        return gastoEnergia;
    }

    public int getGastoSatisfacao() {
        return gastoSatisfacao;
    }

    public int getRequisitoInteligencia() {
        return requisitoInteligencia;
    }
}
