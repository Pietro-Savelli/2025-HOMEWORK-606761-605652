package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

class IOSimulatorTest {
	
	
	private Labirinto labirinto;

	@BeforeEach
	void setUp() {
	    LabirintoBuilder builder = new LabirintoBuilder();

	    this.labirinto = builder
	        .addStanzaIniziale("Ingresso")
	        .addAttrezzo("lanterna", 3)
	        .addStanzaMagica("StanzaMagica", 1)
	        .addAttrezzo("osso", 1)
	        .addStanzaBuia("StanzaBuia", "lanterna")
	        .addStanzaBloccata("StanzaBloccata", "chiave", Direzione.NORD)
	        .addStanza("StanzaNormale")
	        .addAttrezzo("chiave", 1)
	        .addStanzaVincente("Uscita")

	        // Collegamenti
	        .addAdiacenza("Ingresso", "StanzaMagica", "nord")
	        .addAdiacenza("StanzaMagica", "StanzaBuia", "est")
	        .addAdiacenza("StanzaBuia", "StanzaBloccata", "sud")
	        .addAdiacenza("StanzaBloccata", "StanzaNormale", "nord")
	        .addAdiacenza("StanzaNormale", "Uscita", "ovest")

	        .getLabirinto();
	}

	
	@Test
	public void testSimulazionePartitaConFine() throws Exception{
		// Input simulati (comandi del giocatore)
		String[] comandi = {
				"vai sud",
				"prendi lanterna",  
				"vai nord",
				"guarda",
				"fine"
		};

		IOSimulator io = new IOSimulator(List.of(comandi)); // invio i comandi a alle stringe di IOSimulator

		DiaDia gioco = new DiaDia(io, labirinto); // creo un istanza diadia con parametro IOSimulator(usufruisce dell interfaccia IO)
		gioco.gioca();  // Questo metodo deve usare solo io.leggiRiga() e io.mostraMessaggio()
		assertTrue(io.hasNextMessaggio());

		boolean messaggioFinaleTrovato = false;
		while (io.hasNextMessaggio()) {
			String messaggio = io.nextMessaggio();

			if (messaggio.equals("Grazie di aver giocato!")) {
				messaggioFinaleTrovato = true;
				break;
			}
		}

		assertTrue(messaggioFinaleTrovato); //Il gioco dovrebbe concludersi all' utlimo comando della stringa "fine"
	}

	@Test
	public void testSimulazioneVinta() throws Exception {
		
		String[] comandi = { "vai nord", "fine" }; // comandi che gestiscono la partita (comandiInIngresso)
		
		IOSimulator io = new IOSimulator(List.of(comandi)); // invio i comandi a alle stringe di IOSimulator

		DiaDia gioco = new DiaDia(io, labirinto); // creo un istanza diadia con parametro IOSimulator(usufruisce dell interfaccia IO)
		gioco.gioca();  // Questo metodo deve usare solo io.leggiRiga() e io.mostraMessaggio()
		assertTrue(io.hasNextMessaggio());

		boolean messaggioFinaleTrovato = false;
		while (io.hasNextMessaggio()) {
			String messaggio = io.nextMessaggio();

			if (messaggio.equals("Hai vinto!")) {
				messaggioFinaleTrovato = true;
				break;
			}
		}

		assertTrue(messaggioFinaleTrovato); //Il gioco dovrebbe concludersi perche' hai raggiunto la stanza giusta 
	}
	

	@Test
	public void testSimulazione() throws Exception {
		
		String[] comandi = { "vai sud", "vai nord", "fine" }; // comandi che gestiscono la partita (comandiInIngresso)
		String[] aspettativa = { "Aula N10", "Atrio", "Grazie di aver giocato!" };
		
		IOSimulator io = new IOSimulator(List.of(comandi)); // invio i comandi a alle stringe di IOSimulator

		DiaDia gioco = new DiaDia(io, labirinto); // creo un istanza diadia con parametro IOSimulator(usufruisce dell interfaccia IO)
		gioco.gioca();  // Questo metodo deve usare solo io.leggiRiga() e io.mostraMessaggio()
		assertTrue(io.hasNextMessaggio());

		io.nextMessaggio();
		for (int i=0; i<aspettativa.length-1; i++) {
			assertEquals(io.nextMessaggio(), aspettativa[i]);
		}
	}
}
