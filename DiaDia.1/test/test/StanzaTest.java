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
		stanza.addAttrezzo(new Attrezzo("p-", 0));
		stanza.addAttrezzo(new Attrezzo("p0", 0));
		stanza.addAttrezzo(new Attrezzo("p9", 0));
		stanza.addAttrezzo(new Attrezzo("p8", 0));
		stanza.addAttrezzo(new Attrezzo("p7", 0));
		stanza.addAttrezzo(new Attrezzo("p6", 0));
		stanza.addAttrezzo(new Attrezzo("p5", 0));
		stanza.addAttrezzo(new Attrezzo("p4", 0));
		stanza.addAttrezzo(new Attrezzo("p3", 0));
		stanza.addAttrezzo(new Attrezzo("p2", 0));
		stanza.addAttrezzo(new Attrezzo("p1", 0));
		assertFalse(stanza.addAttrezzo(new Attrezzo("p4434343434", 0)));
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
		assertEquals(stanza.getStanzaAdiacente("nord"), stanza2);
	}
	
	@Test 
	void testImpostaStanzaAdiacenteNull() {
		stanza.impostaStanzaAdiacente(null, stanza2);
		assertNull(stanza.getStanzaAdiacente(null));
		
	}
	
	@Test 
	void testImpostaStanzaAdiacenteNullAttrezzo() {
		stanza.impostaStanzaAdiacente("sud", null);
		assertNull(stanza.getStanzaAdiacente("sud"));
		
	}

}
