import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        final int ETA_MIN_GIUDICI = 18;
        ArrayList<Partecipante> partecipanti = new ArrayList<>();
        ArrayList<Giudice> giudice = new ArrayList<>();
        int partecipantiTotali;
        String tipoConcorso; 
        String modalitaValutazione;
        int numeroGiudici;
        int etaMinima;

        System.out.println("Inserisci il tipo di concorso: ");
        tipoConcorso = scanner.nextLine();

        System.out.println("Inserisci l'età minima per partecipare al concorso di "+ tipoConcorso + " (età minima 18 anni)");
        do {
            etaMinima = scanner.nextInt();

            if (etaMinima < 18) {
                System.out.println("L'età minima è di 18 anni");
            }
        } while (etaMinima < 18);
        
        //inserimento numero partecipanti totali
        do {
            System.out.println("Inserisci il numero di partecipanti: ");
            partecipantiTotali = scanner.nextInt();

            if (partecipantiTotali < 0) {   //verifica che il valore inserito sia valido
                System.out.println("I partecipanti totali non possono essere minori di 0");;
            }
        } while (partecipantiTotali < 0);
        scanner.nextLine();

        //Inserimeto dati partecipanti
        boolean partecipanteValido = true;
        for (int i = 0; i < partecipantiTotali; i++) {
            do {
                partecipanteValido = true;
                try {
                    System.out.println("Inserisci i dati del partecipante: " +  (i+1));
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Cognome: ");
                    String cognome = scanner.nextLine();
                    
                    int id;
                    boolean esiste = false;

                    do {
                        id = (int) (Math.random()* 999 + 1);
                        for(int j = 0; j<partecipanti.size(); j++) {
                            if (id == partecipanti.get(j).getId()) {
                                esiste = true;
                                break;
                            }
                        }
                    } while (esiste);
                    

                    System.out.println("ID: " + id);
                    
                    String sesso;
                    do {
                        System.out.println("Sesso (M/F/Maschio/Femmina): ");
                        sesso = scanner.nextLine().toLowerCase(); 

                        if(!sesso.equals("m") && !sesso.equals("f") && !sesso.equals("femmina") && !sesso.equals("maschio")) {
                            System.out.println("Il sesso inserito non è valido");
                        }
                    } while (!sesso.equals("m") && !sesso.equals("f") && !sesso.equals("femmina") && !sesso.equals("maschio"));
                    
                    System.out.println("Età (minima " + etaMinima +"): ");
                    int eta;

                    do {
                        eta = scanner.nextInt();

                        if (eta < etaMinima) {
                            System.out.println("Valore non valido, l'età minima è di " + etaMinima );
                        }

                    } while (eta < etaMinima);

                    scanner.nextLine(); 

                    partecipanti.add( new Partecipante(nome, cognome, eta, sesso, id));
                    System.out.println("Partecipante aggiunto correttamente");
                    
                    System.out.println();
                } catch (InputMismatchException e) {
                    partecipanteValido = false;
                    System.out.println("Input non valido, riprova.");
                    scanner.nextLine(); 
                }
            } while (!partecipanteValido);
        }

        

        System.out.println();
        
        do {
            System.out.println("Inserisci il numero di giudici (3-5): ");
            numeroGiudici = scanner.nextInt();
            if (numeroGiudici <3 || numeroGiudici > 5) {
                System.out.println("Scelta non valida, riprova.");
            }
        } while (numeroGiudici <3 || numeroGiudici > 5);
        scanner.nextLine(); 

        //inserimento dati giudici
        boolean giudiceValido = true;
        for (int i = 0; i<numeroGiudici; i++) {
            do{
                giudiceValido = true;
                try {
                    System.out.println("Inserisci i dati del giudice " + (i+1));
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Cognome: ");
                    String cognome = scanner.nextLine();

                    String sesso;
                    do {
                        System.out.println("Sesso (M/F/Maschio/Femmina): ");
                        sesso = scanner.nextLine().toLowerCase(); 

                        if(!sesso.equals("m") && !sesso.equals("f") && !sesso.equals("femmina") && !sesso.equals("maschio")) {
                            System.out.println("Il sesso inserito non è valido");
                        }
                    } while (!sesso.equals("m") && !sesso.equals("f") && !sesso.equals("femmina") && !sesso.equals("maschio"));

                    int eta;
                    System.out.println("Età (minima " + ETA_MIN_GIUDICI +"): ");
                    
                    do { 
                        eta = scanner.nextInt();
                        scanner.nextLine(); 

                        if (eta < ETA_MIN_GIUDICI) {
                            System.out.println("Valore non valido, l'età minima è di " + ETA_MIN_GIUDICI );
                        }
                    } while (eta < ETA_MIN_GIUDICI);
                    
                    giudice.add(new Giudice(nome, cognome, eta, sesso));
                    System.out.println("Giudice aggiunto correttamente.");
                    System.out.println();
                } catch (Exception e) {
                    giudiceValido = false;
                    System.out.println("Input non valido, riprova.");
                    scanner.nextLine(); 
                }
            } while (!giudiceValido);
        }

        //scelta modalità di valutazione
        do {
            System.out.println("Inserisci la modalità di valutazione (decimi, trentesimi, sessantesimi, centesimi): ");
            modalitaValutazione = scanner.nextLine().toLowerCase();

            if (!modalitaValutazione.equals("decimi") && !modalitaValutazione.equals("trentesimi") && !modalitaValutazione.equals("sessantesimi") && !modalitaValutazione.equals("centesimi")) {
                System.out.println("Scelta non valida, riprova.");
            }

        } while (!modalitaValutazione.equals("decimi") && !modalitaValutazione.equals("trentesimi") && !modalitaValutazione.equals("sessantesimi") && !modalitaValutazione.equals("centesimi"));

        //inserimento voti per ogni giudice
        //TODO add try catch
        for (int j = 0; j < partecipantiTotali; j++) {  //TODO add numero partecipante
            for (int i = 0; i < numeroGiudici; i++) {
                System.out.println("GIUDICE " + (i+1));
    
                System.out.println("Inserisci il voto per la prova orale: ");
                float votoOrale = inserisciVoto(modalitaValutazione, scanner);
    
                System.out.println("Inserisci il voto per la prova scritta: ");
                float votoScritto = inserisciVoto(modalitaValutazione, scanner);
    
                System.out.println("Inserisci il voto per la prova pratica: ");
                float votoPratica = inserisciVoto(modalitaValutazione, scanner);
                
                giudice.get(i).assegnaVoti(votoOrale, votoScritto, votoPratica, partecipanti.get(j));
            }
        }
        

        //calcolo media per ogni partecipante
        for (Partecipante p : partecipanti) {
            float mediaOrale = 0;
            float mediaScritto = 0;
            float  mediaPratico = 0;
            float mediaGenerale = 0;
            
            for (int i = 0; i < numeroGiudici; i++) {
                mediaOrale += p.getVotiOrale(i);
                mediaScritto += p.getVotiScritto(i);
                mediaPratico += p.getVotiPratico(i);
            }

            mediaOrale /= numeroGiudici;
            mediaScritto /= numeroGiudici;
            mediaPratico /= numeroGiudici;

            

            mediaGenerale = (mediaOrale + mediaScritto + mediaPratico) / 3;

            p.setMediaOrale(mediaOrale);
            p.setMediaScritto(mediaScritto);
            p.setMediaPratico(mediaPratico);
            p.setMediaGenerale(mediaGenerale);

        }

        //*Debug */
        for (int i = 0; i<partecipanti.size(); i++) {
            //System.out.println("dwdw");
            partecipanti.get(i).visualizza();
        }

        scanner.close();
    }

    public static float inserisciVoto(String modalitaValutazione, Scanner scanner) {
        float voto = 0;
        boolean validitaVoto;
        do {
            validitaVoto = true;
            try {
                if (modalitaValutazione.equals("decimi")) {
                    voto = scanner.nextFloat();
                    if(voto < 0 || voto > 10) {
                        validitaVoto = false;
                        System.out.println("Voto non valido, inserire un valore tra 0 e 10");
                    }
                } else if (modalitaValutazione.equals("trentesimi")) {
                    voto = scanner.nextInt();
                    if(voto < 0 || voto > 30) {
                        validitaVoto = false;
                        System.out.println("Voto non valido, inserire un valore tra 0 e 30");
                    }
                } else if (modalitaValutazione.equals("sessantesimi")) {
                    voto = scanner.nextInt();
                    if(voto < 0 || voto > 60) {
                        validitaVoto = false;
                        System.out.println("Voto non valido, inserire un valore tra 0 e 60");
                    }
                } else if (modalitaValutazione.equals("centesimi")) {
                    voto = scanner.nextInt();
                    if(voto < 0 || voto > 100) {
                        validitaVoto = false;
                        System.out.println("Voto non valido, inserire un valore tra 0 e 100");
                    }
                }
            } catch (Exception e) {
                validitaVoto = false;
                System.out.println("Input non valido, riprova.");
                scanner.nextLine(); 
            }
        } while (!validitaVoto);    //chiedi fino a quando non viene inserito un voto valido
        return voto;
    }
}


/*
 * utilizzare metodi 
 * verificare dati
 * commenti
 */