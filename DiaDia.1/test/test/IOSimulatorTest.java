package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

class IOSimulatorTest {

	@Test
	public void testSimulazionePartitaConFine(){
		// Input simulati (comandi del giocatore)
		String[] comandi = {
				"vai sud",
				"prendi lanterna",
				"vai nord",
				"guarda",
				"fine"
		};

		IOSimulator io = new IOSimulator(comandi); // invio i comandi a alle stringe di IOSimulator

		DiaDia gioco = new DiaDia(io); // creo un istanza diadia con parametro IOSimulator(usufruisce dell interfaccia IO)
		gioco.gioca();  // Questo metodo deve usare solo io.leggiRiga() e io.mostraMessaggio()
		assertTrue(io.hasNextMessaggio());

		boolean messaggioFinaleTrovato = false;
		while (io.hasNextMessaggio()) {
			String messaggio = io.leggiNextMessaggio();

			if (messaggio.equals("Grazie di aver giocato!")) {
				messaggioFinaleTrovato = true;
				break;
			}
		}

		assertTrue(messaggioFinaleTrovato); //Il gioco dovrebbe concludersi all' utlimo comando della stringa "fine"
	}

	@Test
	public void testSimulazioneVinta() {
		
		String[] comandi = { "vai nord", "fine" }; // comandi che gestiscono la partita (comandiInIngresso)
		
		IOSimulator io = new IOSimulator(comandi); // invio i comandi a alle stringe di IOSimulator

		DiaDia gioco = new DiaDia(io); // creo un istanza diadia con parametro IOSimulator(usufruisce dell interfaccia IO)
		gioco.gioca();  // Questo metodo deve usare solo io.leggiRiga() e io.mostraMessaggio()
		assertTrue(io.hasNextMessaggio());

		boolean messaggioFinaleTrovato = false;
		while (io.hasNextMessaggio()) {
			String messaggio = io.leggiNextMessaggio();

			if (messaggio.equals("Hai vinto!")) {
				messaggioFinaleTrovato = true;
				break;
			}
		}

		assertTrue(messaggioFinaleTrovato); //Il gioco dovrebbe concludersi perche' hai raggiunto la stanza giusta 
	}
	
	
	@Test
	public void testSimulazioneFineCfu() {
		// comandi del giocatore
		String[] comandi = {
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				"vai sud",
				"vai nord",
				};
		
		IOSimulator io = new IOSimulator(comandi); // invio i comandi a alle stringe di IOSimulator

		DiaDia gioco = new DiaDia(io); 	// creo un istanza diadia con parametro IOSimulator(usufruisce dei servizi dell interfaccia IO)
		gioco.gioca();  	// Questo metodo deve usare solo io.leggiRiga() e io.mostraMessaggio()
		assertTrue(io.hasNextMessaggio());

		boolean messaggioFinaleTrovato = false;
		while (io.hasNextMessaggio()) {
			String messaggio = io.leggiNextMessaggio();

			if (messaggio.equals("Hai perso tutti i cfu!")) {
				messaggioFinaleTrovato = true;
				break;
			}
		}

		assertTrue(messaggioFinaleTrovato); //Il gioco dovrebbe concludersi perche' "Hai perso tutti i cfu!"
	}

}
