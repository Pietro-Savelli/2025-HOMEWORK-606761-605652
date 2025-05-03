package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private StanzaBuia casa;
	
	@BeforeEach
	public void setUp() {
		casa = new StanzaBuia("lanterna", "casa");
	}
	
	@Test
	public void TestGetDestrizioneBuia() {
		assertEquals("qui c'è un buio pesto", casa.getDescrizione());
	}
	
	@Test
	public void TestGetDestrizione() {
		casa.addAttrezzo(new Attrezzo("lanterna", 4));
		assertTrue(casa.hasAttrezzo("lanterna"));
//		System.out.println(casa.getDescrizione());
		assertNotEquals("qui c'è un buio pesto", casa.getDescrizione());
	}
}
