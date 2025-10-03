import java.util.ArrayList;
import java.util.Random;

public class GerenciadorDeEventos {
    private ArrayList<Evento> eventosDeVida;
    private ArrayList<Evento> eventosDeTrabalho;
    private ArrayList<Evento> eventosDeLazer;
    private Random random;

    public GerenciadorDeEventos() {
        this.random = new Random();
        
        eventosDeVida = new ArrayList<>();
        eventosDeVida.add(new Evento("Você achou uma carteira na rua com R$100!", 100.00, 0, 10, 0));
        eventosDeVida.add(new Evento("Seu bilhete de loteria foi premiado!", 2500.00, 0, 25, 0));
        eventosDeVida.add(new Evento("Você se sentiu incrivelmente disposto e saudável este ano.", 0, 15, 5, 0));
        eventosDeVida.add(new Evento("Você pegou uma gripe forte e precisou ficar de cama.", 0, -15, -10, 0));
        eventosDeVida.add(new Evento("Seu celular quebrou e você precisou comprar um novo.", -800.00, 0, -10, 0));

        eventosDeTrabalho = new ArrayList<>();
        eventosDeTrabalho.add(new Evento("Seu chefe elogiou seu desempenho e te deu um bônus.", 300.00, 0, 15, 0));
        eventosDeTrabalho.add(new Evento("A empresa investiu em você com um curso de capacitação.", 0, 0, 10, 15));
        eventosDeTrabalho.add(new Evento("Você teve uma forte discussão com seu chefe.", 0, 0, -20, 0));

        eventosDeLazer = new ArrayList<>();
        eventosDeLazer.add(new Evento("A atividade foi muito mais divertida do que você esperava!", 0, 0, 15, 0));
        eventosDeLazer.add(new Evento("Você fez um novo amigo durante a atividade.", 0, 0, 20, 0));
        eventosDeLazer.add(new Evento("Você torceu o tornozelo enquanto se divertia.", 0, -10, -10, 0));
        eventosDeLazer.add(new Evento("Você se cagou ao levantar.", 0, -20, -30, 0));
    }

    public Evento sortearEvento(ArrayList<Evento> listaDeEventos) {
        if (listaDeEventos == null || listaDeEventos.isEmpty()) {
            return null;
        }
        int i = random.nextInt(listaDeEventos.size());
        return listaDeEventos.get(i);
    }

    public ArrayList<Evento> getEventosDeVida() {
        return eventosDeVida;
    }

    public ArrayList<Evento> getEventosDeTrabalho() {
        return eventosDeTrabalho;
    }

    public ArrayList<Evento> getEventosDeLazer() {
        return eventosDeLazer;
    }

}
