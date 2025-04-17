package testComandi;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	private Partita partita;
	private Stanza atrio;
	private Stanza biblioteca;
	private Stanza n11;
	private Comando c;

	@BeforeEach
	void setUp() throws Exception {
		c = new ComandoVai();
		
		this.partita = new Partita();
		atrio = new Stanza("atrio");
		biblioteca = new Stanza("biblioteca");
		n11 = new Stanza("n11");
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("sud", n11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		n11.impostaStanzaAdiacente("nord", biblioteca);
		partita.setStanzaCorrente(atrio);
	}

	@Test
	public void testEseguiDirezioneValida() {
		c.setParametro("nord");
		c.esegui(partita);
		
		assertEquals("biblioteca", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiDirezioniValide() {
		c.setParametro("nord");
		c.esegui(partita);
		c.setParametro("sud");
		c.esegui(partita);
		c.setParametro("sud");
		c.esegui(partita);
		assertEquals("n11", partita.getStanzaCorrente().getNome());
	}
	
	// rimani nella stessa stanza
	@Test
	public void testEseguiDirezioneNull() {
		c.setParametro(null);
		c.esegui(partita);
		
		assertEquals("atrio", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiDirezioneNonValida() {
		c.setParametro("est");
		c.esegui(partita);
		
		assertEquals("atrio", partita.getStanzaCorrente().getNome());
	}
}
