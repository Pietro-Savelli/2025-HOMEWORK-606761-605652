package testComandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoPrendiTest {
	private Partita partita;
	private Comando c;
	private FabbricaDiComandiRiflessiva fabbrica;
	@BeforeEach
	public void setUp() throws Exception {
		partita = new Partita();
		this.fabbrica = new FabbricaDiComandiRiflessiva();
		c = fabbrica.costruisciComando("prendi");
		c.setIO(new IOConsole());
	}

	@Test
	void testPrendiAttrezzoPresenteInStanza() {
		c.setParametro("osso");
		c.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("osso"));
	}

	@Test 
	void testPrendiAttrezzoNonPresenteInStanza() {
		c.setParametro("lanterna");
		c.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("lanterna"));
	}
	
	@Test 
	void testPrendiAtrezzoSenzaParametro(){
		c.setParametro(null);
		c.esegui(partita);
	    assertTrue(partita.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	void testPrendiAttrezzoPresenteInStanzaBorsaPiena() {
		partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("pippo",10));
		c.setParametro("osso");
		c.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("osso"));
	}

}
