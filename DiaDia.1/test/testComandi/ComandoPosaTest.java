package testComandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

class ComandoPosaTest {
	private Partita partita;
	private Comando c;

	@BeforeEach
	public void setUp() {
		partita = new Partita();
		c = new ComandoPosa();
	}
	
	@Test 
	public void testPosaAttrezzoPresenteNellaBorsa() {
		partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("pippo",10));
		c.setParametro("pippo");
		c.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("pippo"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("pippo"));
	}
	
	@Test
	public void testPosaAttrezzoNonPresenteNellaBorsa() {
		c.setParametro("pippo");
		c.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("pippo"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("pippo"));
	}
	
	@Test
	// non so come impostarlo 
	public void testPosaNull() {
		c.setParametro(null);
		c.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(null));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(null));
	}
	
	@Test
	public void testPosaAttrezzoStanzaPiena() {
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("p", 1));
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("p", 1));
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("p", 1));
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("p", 1));
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("p", 1));
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("p", 1));
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("p", 1));
		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("p", 1));
		partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("pippo",10));
		c.setParametro("pippo");
		c.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("pippo"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("pippo"));
	}
}
