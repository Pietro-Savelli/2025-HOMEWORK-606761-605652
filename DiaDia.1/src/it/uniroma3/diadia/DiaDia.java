package it.uniroma3.diadia;


import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;



/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version implemantazione polimorfismo
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

	private Partita partita;
	private IO console;

	public DiaDia(IO io) {
		this.console = io;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = console.leggiRiga();//cambio istruzione in leggi riga per la classe IO
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
		 Comando comandoDaEseguire;
		 FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		 comandoDaEseguire = factory.costruisciComando(istruzione);
		 comandoDaEseguire.setIO(this.console);	//mi serve per portare il riferimanto IOConsole nei comandi
		 comandoDaEseguire.esegui(this.partita);

		if (this.partita.isFinita()) {
			if(this.partita.vinta())
				console.mostraMessaggio("Hai vinto!");
			else if(partita.getGiocatore().getCfu() == 0)
				console.mostraMessaggio("Hai perso tutti i cfu!");
		} 
		 return this.partita.isFinita();
	}   

	//main
	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		
		gioco.gioca();
	}
}