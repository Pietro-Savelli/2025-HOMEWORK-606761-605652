import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita;
	private Stanza stanzaTest;
	
	@BeforeEach
	void setUp() {
		partita = new Partita();	// creo una nuova partita
		stanzaTest = new Stanza("stanzaTest");	// creo una nuova stanza
	}
	
	@Test
	void testSetStanzaCorrente() {
		partita.setStanzaCorrente(stanzaTest);
		assertEquals(stanzaTest, partita.getStanzaCorrente(), "la stanza deve essere la stanza dei test");
	}
	
	//CONTINUA
}
