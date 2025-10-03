public class Personagem {
    private String nome;
    private int idade;
    private boolean estaVivo;
    private int saude;
    private int energia;
    private double dinheiro;
    private int satisfacao;
    private int inteligencia;
    private Trabalho empregoAtual;
    private String nivelEscolar;
    private int desempenhoEscolar;

    public Personagem(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.estaVivo = true;
        this.saude = 100;
        this.energia = 100;
        this.dinheiro = 0.00;
        this.satisfacao = 100;
        this.inteligencia = 10;
        this.empregoAtual = null;
        this.nivelEscolar = "Nenhum";
        this.desempenhoEscolar = 0;
    }

    public boolean estaVivo() {
        return estaVivo;
    }

    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getSaude() {
        return saude;
    }

    public int getEnergia() {
        return energia;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public int getSatisfacao() {
        return satisfacao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public Trabalho getEmpregoAtual() {
        return empregoAtual;
    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }

    public int getDesempenhoEscolar() {
        return desempenhoEscolar;
    }

    public void setEmpregoAtual(Trabalho emprego) { this.empregoAtual = emprego; }

    private void normalizarAtributos() {
        if (this.saude > 100) this.saude = 100;
        if (this.saude <= 0) {
            this.saude = 0;
            if (this.estaVivo) {
                System.out.println("Sua saúde chegou a zero. Fim de jogo.");
                this.estaVivo = false;
            }
        }
        if (this.satisfacao > 100) this.satisfacao = 100;
        if (this.satisfacao < 0) this.satisfacao = 0;
        if (this.energia > 100) this.energia = 100;
        if (this.energia < 0) this.energia = 0;
        if (this.inteligencia > 100) this.inteligencia = 100;
        if (this.inteligencia < 0) this.inteligencia = 0;
    }

    public void aplicarEfeitoEvento(Evento evento) {
        if (evento == null) return;
        
        System.out.println("\n>> ACONTECIMENTO INESPERADO <<");
        System.out.println("   " + evento.getDescricao());

        this.dinheiro += evento.getMudancaDinheiro();
        this.saude += evento.getMudancaSaude();
        this.satisfacao += evento.getMudancaSatisfacao();
        this.inteligencia += evento.getMudancaInteligencia();
        normalizarAtributos();
    }

    public void envelhecer(GerenciadorDeEventos gerenciador) {
    if (!this.estaVivo) return;

    this.energia = 100;
    System.out.println("Com o novo ano, suas energias foram totalmente recuperadas!");
    
    this.idade++;
    System.out.println("\nFeliz aniversário! Você fez " + this.idade + " anos.");

    if (this.idade >= 6 && this.idade < 18) {

        double mesada = 5.0 + this.idade; 
        this.dinheiro += mesada;
        System.out.printf(">> Você recebeu R$ %.2f de mesada dos seus pais.%n", mesada);
    }

    if (this.idade == 6) {
        this.nivelEscolar = "Ensino Fundamental";
        System.out.println(">> MARCO NA VIDA: Você começou a frequentar a escola!");
    } else if (this.idade > 6 && this.idade < 18) {
        // ... (resto da lógica escolar, sem alterações)
        this.desempenhoEscolar = (int)(this.inteligencia * 0.7 + Math.random() * 40);
        if (this.desempenhoEscolar > 100) this.desempenhoEscolar = 100;
        System.out.println("Seu desempenho escolar este ano foi: " + this.desempenhoEscolar + "/100");
        if (this.desempenhoEscolar < 50) {
            System.out.println("Suas notas estão baixas. Seus pais não estão felizes.");
            this.satisfacao -= 10;
        }
    } else if (this.idade == 14) {
         this.nivelEscolar = "Ensino Médio";
         System.out.println(">> MARCO NA VIDA: Você se formou no Ensino Fundamental e começou o Ensino Médio!");
    } else if (this.idade == 18) {
        if (!this.nivelEscolar.equals("Formado no Ensino Médio")) {
            this.nivelEscolar = "Formado no Ensino Médio";
            System.out.println(">> MARCO NA VIDA: Você se formou no Ensino Médio! O mundo adulto te espera.");
            this.inteligencia += this.desempenhoEscolar / 10;
        }
    }
    
    this.satisfacao -= 5;
    if (this.idade > 50) this.saude -= 3;
    
    if (Math.random() < 0.30) { 
        Evento eventoSorteado = gerenciador.sortearEvento(gerenciador.getEventosDeVida());
        // Verificação extra para eventos de dinheiro para crianças
        if (this.idade < 18 && eventoSorteado.getMudancaDinheiro() > 500) {
             System.out.println(">> Um evento incrível quase aconteceu, mas você é jovem demais para isso agora.");
        } else {
            aplicarEfeitoEvento(eventoSorteado);
        }
    }

    if (this.idade > 70 && Math.random() < 0.02) {
        System.out.println("Você viveu uma vida longa e faleceu de velhice.");
        this.estaVivo = false;
    }
    normalizarAtributos();
}

    public void trabalhar(GerenciadorDeEventos gerenciador) {
        if (this.empregoAtual == null) {
            System.out.println("Você não tem um emprego!");
            return;
        }
        if (this.energia >= this.empregoAtual.getGastoEnergia()) {
            this.dinheiro += this.empregoAtual.getSalario();
            this.energia -= this.empregoAtual.getGastoEnergia();
            this.satisfacao -= this.empregoAtual.getGastoSatisfacao();
            System.out.printf("Você trabalhou como " + this.empregoAtual.getNome() + " e ganhou R$ %.2f%n", this.empregoAtual.getSalario());
            if (Math.random() < 0.2) {
                aplicarEfeitoEvento(gerenciador.sortearEvento(gerenciador.getEventosDeTrabalho()));
            }
        } else {
            System.out.println("Você está cansado demais para trabalhar!");
        }
        normalizarAtributos();
    }

    public void fazerLazer(Lazer atividade, GerenciadorDeEventos gerenciador) {
        if (this.dinheiro >= atividade.getCustoDinheiro() && this.energia >= atividade.getCustoEnergia()) {
            this.dinheiro -= atividade.getCustoDinheiro();
            this.energia -= atividade.getCustoEnergia();
            this.satisfacao += atividade.getGanhoSatisfacao();
            this.saude += atividade.getGanhoSaude();
            System.out.println("Você se divertiu fazendo '" + atividade.getNome() + "'.");
            if (Math.random() < 0.30) {
                aplicarEfeitoEvento(gerenciador.sortearEvento(gerenciador.getEventosDeLazer()));
            }
        } else {
            System.out.println("Você não tem dinheiro ou energia suficiente para esta atividade.");
        }
        normalizarAtributos();
    }
    
    public void estudar() {
        if (this.energia >= 15) {
            this.energia -= 15;
            this.satisfacao -= 5;
            this.desempenhoEscolar += 10;
            if (this.desempenhoEscolar > 100) this.desempenhoEscolar = 100;
            System.out.println("Você se dedicou aos estudos. Seu desempenho escolar melhorou!");
        } else {
            System.out.println("Você não tem energia suficiente para estudar.");
        }
        normalizarAtributos();
    }
    
    public void brincar() {
        if (this.energia >= 10) {
            this.energia -= 10;
            this.satisfacao += 15;
            System.out.println("Você brincou bastante e está mais feliz!");
        } else {
            System.out.println("Você está cansado demais para brincar agora.");
        }
        normalizarAtributos();
    }
}
