public abstract class Persona {

    protected String nome;
    protected String cognome;
    protected int eta;
    protected String sesso;

    Persona(String nome, String cognome, int eta, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.sesso = sesso;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    
}