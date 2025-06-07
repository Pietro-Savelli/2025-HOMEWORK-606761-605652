package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;

public class CaneTest {
	private Cane cane;
	private Partita partita;
	private Attrezzo regalo;
	private Attrezzo ciboPreferito;

	@BeforeEach
	public void setUp() throws Exception {
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("iniziale")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.regalo = new Attrezzo("Regalo", 1);
		this.ciboPreferito = new Attrezzo("CiboPreferito", 2);
		this.cane = new Cane("Cane", "Presentazione!", this.ciboPreferito.getNome(), this.regalo);
	}

	@Test
	public void testAgisci() {
		this.partita.setCfu(10);
		this.cane.agisci(this.partita);
		assertEquals(9, this.partita.getCfu());
	}

	@Test
	public void testRiceviRegalo_CiboCorretto() {
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.cane.riceviRegalo(this.ciboPreferito, this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));		
	}
	
	@Test
	public void testRiceviRegalo_Sbagliato() {
		Attrezzo ciboSbagliato = new Attrezzo("CiboSbagliato", 2);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(ciboSbagliato.getNome()));
		this.cane.riceviRegalo(ciboSbagliato, this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(ciboSbagliato.getNome()));
	}
	
}
