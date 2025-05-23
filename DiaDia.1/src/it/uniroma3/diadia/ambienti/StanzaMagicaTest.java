package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {

	private StanzaMagica cantinaS1;
	private StanzaMagica cantinaS0;
	private Attrezzo lanterna;
	
	@BeforeEach
	void setUp(){
		cantinaS1 = new StanzaMagica("cantina");
		cantinaS0 = new StanzaMagica("cantina", -1);
		lanterna = new Attrezzo("lanterna", 2);
	}
	
	@Test
	public void testModificaAttrezzo() {
		cantinaS0.addAttrezzo(lanterna);
		assertTrue(cantinaS0.hasAttrezzo("anretnal"));
		assertEquals(cantinaS0.getAttrezzo("anretnal").getPeso(), 4);
	}
	
	@Test
	public void testModificaAttrezzoSottoSoglia() {
		cantinaS1.addAttrezzo(lanterna);
		assertTrue(cantinaS1.hasAttrezzo("lanterna"));
		assertSame(cantinaS1.getAttrezzo("lanterna"), lanterna);
	}
	
	@Test
	public void testModificaAttrezzoNull() {
		cantinaS1.addAttrezzo(null);
		assertFalse(cantinaS1.hasAttrezzo("lanterna"));
		assertFalse(cantinaS0.hasAttrezzo("anretnal"));
	}


}
