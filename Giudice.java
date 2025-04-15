public class Giudice extends Persona{

    Giudice(String nome, String cognome, int eta, String sesso) {
        super(nome, cognome, eta, sesso);
    }
    
    public void assegnaVoti(float votoPratico, float votoScritto, float votoOrale, Partecipante partecipante) {
        partecipante.setVotiOrale(votoOrale);
        partecipante.setVotiPratico(votoPratico);
        partecipante.setVotiScritto(votoScritto);
    }
}
