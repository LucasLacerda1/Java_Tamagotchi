import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Carrega todos os nossos gerenciadores
        GerenciadorDeEventos gerenciadorEventos = new GerenciadorDeEventos();
        AgenciaDeEmpregos agencia = new AgenciaDeEmpregos();
        ListaDeLazer listaLazer = new ListaDeLazer();

        System.out.print("Qual o nome do seu personagem? ");
        String nome = scanner.nextLine();
        Personagem meuPersonagem = new Personagem(nome);

        System.out.println("\nA vida de " + nome + " começou!");

        while (meuPersonagem.estaVivo()) {
            System.out.println("\n------------------------------------");
            System.out.println("IDADE: " + meuPersonagem.getIdade() + " ANOS");
            System.out.println("Escolaridade: " + meuPersonagem.getNivelEscolar());
            if (meuPersonagem.getIdade() > 5 && meuPersonagem.getIdade() < 18) {
                System.out.println("Desempenho Escolar Anual: " + meuPersonagem.getDesempenhoEscolar() + "/100");
            }
            if (meuPersonagem.getEmpregoAtual() != null) {
                System.out.println("Emprego: " + meuPersonagem.getEmpregoAtual().getNome());
            }
            System.out.println("Status: [Saúde: " + meuPersonagem.getSaude() + 
                               " | Felicidade: " + meuPersonagem.getSatisfacao() + 
                               " | Inteligência: " + meuPersonagem.getInteligencia() +
                               " | Energia: " + meuPersonagem.getEnergia() +
                               " | Dinheiro: R$" + String.format("%.2f", meuPersonagem.getDinheiro()) + "]");
            System.out.println("------------------------------------");

            System.out.println("\nEscolha uma opção para este ano:");
            System.out.println("1. Atividades");
            System.out.println("2. Envelhecer (Avançar para o próximo ano)");
            
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    mostrarMenuAtividades(meuPersonagem, scanner, agencia, listaLazer, gerenciadorEventos);
                    break;
                case 2:
                    meuPersonagem.envelhecer(gerenciadorEventos);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        System.out.println("\nFIM DE JOGO. " + meuPersonagem.getNome() + " viveu até os " + meuPersonagem.getIdade() + " anos.");
        scanner.close();
    }

    public static void mostrarMenuAtividades(Personagem p, Scanner sc, AgenciaDeEmpregos ag, ListaDeLazer ll, GerenciadorDeEventos ge) {
        System.out.println("\n--- ATIVIDADES PARA A IDADE DE " + p.getIdade() + " ANOS ---");
        int idade = p.getIdade();
        int op = 0;

        if (idade <= 5) {
            System.out.println("1. Brincar\n0. Voltar");
            op = sc.nextInt();
            if (op == 1) p.brincar();
        } else if (idade < 18) {
            System.out.println("1. Estudar mais (Melhorar desempenho)\n2. Lazer\n0. Voltar");
            op = sc.nextInt();
            if (op == 1) p.estudar();
            else if (op == 2) escolherLazer(p, sc, ll, ge);
        } else {
            System.out.println("1. Trabalhar\n2. Procurar Emprego\n3. Lazer\n0. Voltar");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    p.trabalhar(ge);
                    break;
                case 2:
                    procurarEmprego(p, sc, ag);
                    break;
                case 3:
                    escolherLazer(p, sc, ll, ge);
                    break;
                default:
                    break;
            }
        }
    }

    public static void procurarEmprego(Personagem p, Scanner sc, AgenciaDeEmpregos ag) {
        ag.mostrarVagas(p);
        System.out.print("Escolha uma vaga (ou 0 para voltar): ");
        int vagaIdx = sc.nextInt() - 1;
        if (vagaIdx < 0) return;

        Trabalho t = ag.getTrabalho(vagaIdx);
        if (t != null && p.getInteligencia() >= t.getRequisitoInteligencia()) {
            System.out.println("Você foi contratado como " + t.getNome() + "!");
            p.setEmpregoAtual(t);
        } else {
            System.out.println("Você não conseguiu o emprego ou não tem a qualificação necessária.");
        }
    }

    public static void escolherLazer(Personagem p, Scanner sc, ListaDeLazer ll, GerenciadorDeEventos ge) {
        ll.mostrarOpcoes(p.getIdade());
        System.out.print("Escolha uma atividade (ou 0 para voltar): ");
        int lazerIdx = sc.nextInt() - 1;
        if (lazerIdx < 0) return;

        Lazer lazerEscolhido = ll.getLazer(lazerIdx);
        if (lazerEscolhido != null && p.getIdade() >= lazerEscolhido.getIdadeMinima()) {
            p.fazerLazer(lazerEscolhido, ge);
        } else {
            System.out.println("Opção inválida ou você não tem idade para isso.");
        }
    }
}
