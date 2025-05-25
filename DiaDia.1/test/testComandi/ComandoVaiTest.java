package testComandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	private Partita partita;
	private Stanza atrio;
	private Stanza biblioteca;
	private Stanza n11;
	private Comando c;
	private IO console;

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
		console = new IOConsole();
		c.setIO(console);
	}

	@Test
	public void testEseguiDirezioneValida() {
		c.setParametro("nord");
		c.esegui(partita);
		
		assertSame(biblioteca, partita.getStanzaCorrente());
	}
	
	@Test
	public void testEseguiDirezioniValide() {
		c.setParametro("nord");
		c.esegui(partita);
		c.setParametro("sud");
		c.esegui(partita);
		c.setParametro("sud");
		c.esegui(partita);
		assertSame(n11, partita.getStanzaCorrente());
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
	
	
	@Test
	public void testEseguiDirezioniValideLbitintoBuilder() {
		 Labirinto bilocale = new LabirintoBuilder()
				 .addStanzaIniziale("salotto")
				 .addStanzaVincente("camera")
				 .addAttrezzo("letto",10) // dove? fa riferimento all’ultima stanza aggiunta: la “camera”
				 .addAdiacenza("salotto", "camera", "nord") // camera si trova a nord di salotto
				 .getLabirinto();  // restituisce il Labirinto così specificato
		Partita p2 = new Partita(bilocale);
		
		c.setParametro("nord");
		c.esegui(p2);
		assertSame("camera", p2.getStanzaCorrente().getNome());
		assertTrue(p2.isFinita());
	}
}
