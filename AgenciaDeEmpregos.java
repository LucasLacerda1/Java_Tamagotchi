import java.util.ArrayList;

public class AgenciaDeEmpregos {
    private ArrayList<Trabalho> vagas;

    public AgenciaDeEmpregos() {
        vagas = new ArrayList<>();
        vagas.add(new Trabalho("Lixeiro", 80.00, 30, 15, 0));
        vagas.add(new Trabalho("Artista de Rua", 60.00, 20, -5, 10));
        vagas.add(new Trabalho("Entregador de Pizza", 100.00, 25, 10, 20));
        vagas.add(new Trabalho("Vendedor", 150.00, 20, 20, 35));
        vagas.add(new Trabalho("Desenvolvedor Júnior", 250.00, 40, 5, 60));
        vagas.add(new Trabalho("Médico Residente", 400.00, 50, 25, 90));
    }

    public void mostrarVagas(Personagem personagem) {
        System.out.println("\n========= Vagas de Emprego Disponíveis (Sua Inteligência: " + personagem.getInteligencia() + ") =========");
        boolean encontrouVaga = false;
        for (int i = 0; i < vagas.size(); i++) {
            Trabalho t = vagas.get(i);
            if (personagem.getInteligencia() >= t.getRequisitoInteligencia()) {
                System.out.println((i + 1) + " - " + t.getNome() + " (Salário: R$" + t.getSalario() + ")");
                encontrouVaga = true;
            }
        }
        if (!encontrouVaga) {
            System.out.println("Nenhuma vaga disponível para seu nível de inteligência. Continue estudando!");
        }
        System.out.println("=======================================================================");
    }
    
    public Trabalho getTrabalho(int index) {
        if (index >= 0 && index < vagas.size()) {
            return vagas.get(index);
        }
        return null;
    }
}
