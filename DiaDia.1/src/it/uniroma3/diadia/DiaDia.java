package it.uniroma3.diadia;


import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "raccogli", "lascia", "borsa"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
		scannerDiLinee.close();
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @param istruzione e'una stringa
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if(comandoDaEseguire.getNome() == null) {	// gestisce-il-problema-del-null-pointer-nel-caso-di-invio-senza-nessun-comando
			return false;
		}

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		}
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());

		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();

		else if(comandoDaEseguire.getNome().equals("raccogli")) {
			this.raccogli(comandoDaEseguire.getParametro());
		}
		
		else if(comandoDaEseguire.getNome().equals("lascia")) {
			this.lascia(comandoDaEseguire.getParametro());
		}
		else if(comandoDaEseguire.getNome().equals("borsa")) {
			System.out.println(partita.getGiocatore().getBorsa().toString());
		}
		else
			System.out.println("Comando sconosciuto");

		if (this.partita.isFinita()) {
			if(this.partita.vinta())
				System.out.println("Hai vinto!");
			else
				System.out.println("Hai perso tutti i cfu!");	
			fine();
			return true;	
		} 
		else
			return false;
	}   

	
	
	// implementazioni dei comandi dell'utente:

	
	
	/**
	 * Permette al giocatore di lascaire un attrezzo dalla borsa e aggiungerlo alla stanza corrente,
	 * se presente viene lasciato, stampata la stanza con il nuovo oggeto e rimosso dalla borsa,
	 *  altrimenti viene stampato un messaggio di avviso
	 * 
	 * @param oggetto Il nome dell'attrezzo da raccogliere, se null viene stampato un messaggio di errore
	 */
	
	private void lascia(String oggetto) {
		// TODO Auto-generated method stub
		if(oggetto==null)	// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			System.out.println("cosa vuoi lasciare");
		else {
			Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(oggetto);
			if(attrezzo == null)
				System.out.println("l'attrezzo cercato non e' presente nella borsa");
			else {
				partita.getStanzaCorrente().addAttrezzo(attrezzo);	// aggiunge l'attrezzo dalla stanza
				partita.getGiocatore().getBorsa().removeAttrezzo(oggetto);
				System.out.println("attrezzo aggiunto alla stanza");
				System.out.println(partita.getStanzaCorrente().toString());
			}
		}
	}
	

	/**
	 * Permette al giocatore di raccogliere un attrezzo dalla stanza corrente e aggiungerlo alla propria borsa,
	 * se presente viene aggiunto, stampata la borsa e rimosso dalla stanza, altrimenti viene stampato un messaggio di avviso
	 * 
	 * @param oggetto Il nome dell'attrezzo da raccogliere, se null viene stampato un messaggio di errore
	 */
	
	private void raccogli(String oggetto) {
		// TODO Auto-generated method stub
		if(oggetto==null)	// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			System.out.println("cosa vuoi prendere");
		
		else {
			Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(oggetto);	// cerco l'attrezzo nella stanza corrente
			if(attrezzo == null)
				System.out.println("l'attrezzo cercato non e' presente nella stanza");
			
			else {
				partita.getGiocatore().addAttrezzo(attrezzo);	//aggiungo l'attrezzo nella borsa
				partita.getStanzaCorrente().removeAttrezzo(oggetto); 	// rimuovo l'attrezzo dalla stanza
				System.out.println("attrezzo aggiunto alla borsa");
				System.out.println(partita.getGiocatore().getBorsa().toString());
			}
		}

	}

	
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}
	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			Giocatore giocatore = partita.getGiocatore();	// salvo il giocatore attuale in giocatore
			this.partita.setStanzaCorrente(prossimaStanza);
			giocatore.setCfu(giocatore.getCfu()-1);	// ogni volta che Giocatore cambia stanza chiamato mossa
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}