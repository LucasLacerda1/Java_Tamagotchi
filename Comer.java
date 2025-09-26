import java.util.ArrayList;
public class Comer {
    private ArrayList<String> comidas;

    public Comer() {
        comidas = new ArrayList<String>();
        
        comidas.add("Tutu de camarão");
        comidas.add("Bobó de camarão");
        comidas.add("Risoto de camarão");
        comidas.add("Camarão na manteiga");
        comidas.add("Camarão empanado");
        comidas.add("Strogonofe de camarão");
        comidas.add("Camarão com molho de queijo");
        comidas.add("Muqueca com camarão");
        comidas.add("Lasanha de camarão");
        comidas.add("Empadão de camarão");
    }
    
    public void showMenu() {
        System.out.println("========== Menu de comidas ==========");
        for (int i = 0; i < comidas.size(); i++) {
            System.out.println((i + 1) + " - " + comidas.get(i));
            
        }
        System.out.println("======================================");
    }
}
