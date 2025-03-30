package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	// COME FARE I TEST
	// devo capire cosa devo testare, vorrei avere 2 stanze stanza inizale e stanza vincente
	
	
	
	private Partita partita;
	private Stanza iniziale;
	private Stanza vincente;
	
	@BeforeEach
	void setUp() {
		partita = new Partita();	// creo una nuova partita
		iniziale = new Stanza("atrio");	// creo una nuova stanza iniziale
		vincente = new Stanza("bibblioteca");	// creo nuova stnza vincente
	}
	
	@Test
	void testNuovaPartita_NonFinita() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	void testPartita_Vinta() {
		partita.setStanzaCorrente(partita.getStanzaCorrente());
		assertFalse(this.partita.vinta());
	}
	
	
	@Test
	void testSetStanzaCorrente() {
		partita.setStanzaCorrente(iniziale);
		assertEquals(iniziale, partita.getStanzaCorrente(), "la stanza deve essere la stanza inizaile");
	}
	
	//CONTINUA
}
