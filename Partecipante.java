import java.util.ArrayList;

public class Partecipante extends Persona{
    private int id;
    private ArrayList<Float> votiPratico = new ArrayList<Float>();
    private ArrayList<Float> votiScritto = new ArrayList<Float>();
    private ArrayList<Float> votiOrale = new ArrayList<Float>();
    private float mediaPratico = -1;
    private float mediaScritto = -1;
    private float mediaOrale  = -1;
    private float mediaGenerale = -1;

    public Partecipante(String nome, String cognome, int eta, String sesso, int id) {
        super(nome, cognome, eta, sesso);
        this.id = id;
    }

    public void setVotiPratico(float voto) {
        votiPratico.add(voto);
    }

    public void setVotiScritto(float voto) {
        votiScritto.add(voto);
    }

    public void setVotiOrale(float voto) {
        votiOrale.add(voto);
    }

    public void setMediaPratico(float mediaPratico) {
        this.mediaPratico = mediaPratico;
    }

    public void setMediaScritto(float mediaScritto) {
        this.mediaScritto = mediaScritto;
    }

    public void setMediaOrale(float mediaOrale) {
        this.mediaOrale = mediaOrale;
    }

    public void setMediaGenerale(float mediaGenerale) {
        this.mediaGenerale = mediaGenerale;
    }

    public float getVotiOrale(int indice) {
        return votiOrale.get(indice);
    }

    public float getVotiScritto(int indice) {
        return votiScritto.get(indice);
    }

    public float getVotiPratico(int indice) {
        return votiPratico.get(indice);
    }

    

    public int getId() {
        return id;
    }

    public void visualizza() {
        System.out.println("+===========================================+");
        System.out.println("|           DATI PARTECIPANTE               |");
        System.out.println("+===========================================+");
        System.out.println("| Nome: " + nome + " " + cognome);
        System.out.println("| ID  : " + id);
        System.out.println("+-------------------------------------------+");
    
        boolean datiDisponibili = false;
    
        if (mediaPratico != -1) {
            System.out.println("| Media prova pratica : " + mediaPratico);
            datiDisponibili = true;
        }
        if (mediaScritto != -1) {
            System.out.println("| Media prova scritta : " + mediaScritto);
            datiDisponibili = true;
        }
        if (mediaOrale != -1) {
            System.out.println("| Media prova orale   : " + mediaOrale);
            datiDisponibili = true;
        }
        if (mediaGenerale != -1) {
            System.out.println("| Media generale      : " + mediaGenerale);
            datiDisponibili = true;
        }
    
        if (!datiDisponibili) {
            System.out.println("| Una o più medie non sono disponibili.");
        }
    
        System.out.println("+===========================================+\n");
    }
    
    
    
}
