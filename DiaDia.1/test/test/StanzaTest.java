package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	private Stanza stanza;
	private Attrezzo attrezzo;
	private Stanza stanza2;

	@BeforeEach
	void setUp() {
		stanza = new Stanza("atrio");
		attrezzo = new Attrezzo("prova", 3);
		stanza2 = new Stanza("n11");
	}

	// test per vedere se viene aggiunto corretamente l'attrezzo
	@Test
	void testAddAttrezzo_Disponibile() {
		assertTrue(stanza.addAttrezzo(attrezzo));
	}

	// controlla che dopo il decimo attrezzo non posso piu aggiungerli
	@Test
	void testAddAttrezzo_Piena() {
		for(int i=0; i<10; i++) {
			stanza.addAttrezzo(attrezzo);
		}
		assertFalse(stanza.addAttrezzo(attrezzo));
	}

	@Test 
	void testHasAttrezzo() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo(attrezzo.getNome()));
	}

	@Test 
	void testHasAttrezzo_NonTrovato() {
		stanza.addAttrezzo(attrezzo);
		assertFalse(stanza.hasAttrezzo("penna"));
	}

	@Test
	void testRemoveAttrezzo() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.removeAttrezzo(attrezzo.getNome()));
	}

	@Test
	void testRemoveAttrezzo_NonTrovato() {
		stanza.addAttrezzo(attrezzo);
		assertFalse(stanza.removeAttrezzo("penna"));
	}

	@Test 
	void testImpostaStanzaAdiacente() {
		stanza.impostaStanzaAdiacente("nord", stanza2);
		assertEquals(stanza.getStanzaAdiacente("nord"), stanza2, "andando a nord mi dovrebbe tornare la stanza2");
	}

}
