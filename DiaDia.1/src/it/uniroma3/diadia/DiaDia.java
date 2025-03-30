package it.uniroma3.diadia;


import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


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

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "borsa"};

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

		else if(comandoDaEseguire.getNome().equals("prendi")) {
			this.prendi(comandoDaEseguire.getParametro());
		}

		else if(comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());
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

	private void posa(String oggetto) {
		// TODO Auto-generated method stub
		if(oggetto==null) {// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			System.out.println("cosa vuoi lasciare");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(oggetto);
		if(attrezzo == null) {
			System.out.println("l'attrezzo cercato non e' presente nella borsa");
			return;
		}
		
		if(partita.getStanzaCorrente().addAttrezzo(attrezzo)) {	// aggiunge l'attrezzo dalla stanza
			System.out.println("attrezzo aggiunto alla stanza");
			partita.getGiocatore().removeAttrezzo(oggetto);
		}
		else
			System.out.println("la stanza e' piena, l'attrezzo non puo' essere aggiunto");
	
		System.out.println(partita.getStanzaCorrente().toString());

	}





	/**
	 * Permette al giocatore di raccogliere un attrezzo dalla stanza corrente e aggiungerlo alla propria borsa,
	 * se presente viene aggiunto, stampata la borsa e rimosso dalla stanza, altrimenti viene stampato un messaggio di avviso
	 * 
	 * @param oggetto Il nome dell'attrezzo da raccogliere, se null viene stampato un messaggio di errore
	 */

	private void prendi(String oggetto) {
		// TODO Auto-generated method stub
		if(oggetto==null) {	// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			System.out.println("cosa vuoi prendere");
			return;
		}

		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(oggetto);	// cerco l'attrezzo nella stanza corrente
		if(attrezzo == null) {
			System.out.println("l'attrezzo cercato non e' presente nella stanza");
			return;
		}

		if(partita.getGiocatore().addAttrezzo(attrezzo)) {	//aggiungo l'attrezzo nella borsa se ritorna true
			partita.getStanzaCorrente().removeAttrezzo(oggetto); 	// rimuovo l'attrezzo dalla stanza
			System.out.println("attrezzo aggiunto alla borsa");
		}
		else {
			if(partita.getGiocatore().getBorsa().isFull()) 	
				System.out.println("La borsa è piena, non puoi aggiungere altri attrezzi.");
			else
				System.out.println("La borsa è troppo pesante, non e' possobile aggiungere altri attrezzi.");
		}
		System.out.println(partita.getGiocatore().getBorsa().toString());

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
	 * Sposta il giocatore nella direzione specificata, se possibile.
	 * <p>
	 * Se esiste una stanza adiacente nella direzione indicata il giocatore si sposta in quella stanza,
	 * aggiornando la stanza corrente e decrementando il numero di CFU,
	 * se la direzione non è valida o non viene specificata, viene stampato un messaggio di errore.
	 *
	 * @param direzione la direzione in cui si vuole andare (ad es. "nord", "sud", "est", "ovest")
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {		
			this.partita.setStanzaCorrente(prossimaStanza);
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);	// quando il giocatore cambia stanza i cfu diminuiscono
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine"
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	//main
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}