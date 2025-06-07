package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Mago;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MagoTest {
	private Partita partita;
	private Mago mago;
	private Attrezzo regalo;

	@BeforeEach
	public void setUp() throws Exception {
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("iniziale")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.regalo = new Attrezzo("clava", 2);
		this.mago = new Mago("Mago", "Merlino", this.regalo);
	}

	@Test
	public void testAgisci() {
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.mago.agisci(this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}
	
	@Test
	public void testAgisci_DueVolte() {
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.mago.agisci(this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		this.partita.getStanzaCorrente().removeAttrezzo(this.regalo);
		this.mago.agisci(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}

	@Test
	public void testRiceviRegalo() {
		Attrezzo daDimezzare = new Attrezzo("daDimezzare", 5);
		this.mago.riceviRegalo(daDimezzare, this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(daDimezzare.getNome()));
		assertEquals(2, this.partita.getStanzaCorrente().getAttrezzo(daDimezzare.getNome()).getPeso());
	}

}
