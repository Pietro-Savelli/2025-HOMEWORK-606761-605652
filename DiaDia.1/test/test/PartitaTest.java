package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class PartitaTest {

	// COME FARE I TEST
	// devo capire cosa devo testare, vorrei avere 2 stanze stanza inizale e stanza vincente



	private Partita partita;

	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
	}

	@Test
	void testNuovaPartitaNonFinita() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	void testPartitaVinta() {
		partita.setStanzaCorrente(partita.getStanzaFinale());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	void testPartitaPersa() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	void testPartitaNonFinitaEPoiFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
}

