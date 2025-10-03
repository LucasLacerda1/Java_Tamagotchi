import java.util.ArrayList;

public class ListaDeLazer {
    private ArrayList<Lazer> atividades;

    public ListaDeLazer() {
        atividades = new ArrayList<>();
        atividades.add(new Lazer("Brincar no parque", 0.00, 15, 20, 5, 3));
        atividades.add(new Lazer("Jogar videogame", 5.00, 15, 25, 0, 8));
        atividades.add(new Lazer("Ler um livro", 0.00, 5, 10, 0, 10));
        atividades.add(new Lazer("Ir ao cinema", 30.00, 10, 20, 0, 12));
        atividades.add(new Lazer("Sair com amigos", 40.00, 20, 30, 0, 14));
        atividades.add(new Lazer("Ir à academia", 50.00, 25, 10, 15, 18));
    }

    public void mostrarOpcoes(int idade) {
        System.out.println("\n========= Opções de Lazer =========");
        boolean encontrouOpcao = false;
        for (int i = 0; i < atividades.size(); i++) {
            Lazer l = atividades.get(i);
            if (idade >= l.getIdadeMinima()) {
                System.out.println((i + 1) + " - " + l.getNome() + " (Custo: R$" + l.getCustoDinheiro() + ")");
                encontrouOpcao = true;
            }
        }
        if (!encontrouOpcao) {
            System.out.println("Nenhuma atividade de lazer disponível para sua idade.");
        }
        System.out.println("===================================");
    }
    
    public Lazer getLazer(int index) {
        if (index >= 0 && index < atividades.size()) {
            return atividades.get(index);
        }
        return null;
    }
}
