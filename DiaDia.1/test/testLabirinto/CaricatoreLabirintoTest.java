package testLabirinto;

import static org.junit.jupiter.api.Assertions.*;
import java.io.StringReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirintoTest {
	
	private static final String DESCRIZIONE_LABIRINTO 
			= "Stanze:\n"
			+ "N12\n"
			+ "Magiche:\n"
			+ "N1\n"
			+ "Estremi:\n"
			+ "N10\n"
			+ "Biblioteca\n"
			+ "Attrezzi:\n"
			+ "Osso 5 N10\n"
			+ "Uscite:\n"
			+ "N10 nord Biblioteca\n"
			+ "Biblioteca sud N10";

	@Test
	public void testCarica() {
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(DESCRIZIONE_LABIRINTO));
		caricatore.carica();
		Labirinto labiritno = caricatore.getLabirinto();
		assertEquals("N10", labiritno.getStanzaIniziale().getNome());
		assertEquals("Biblioteca", labiritno.getStanzaVincente().getNome());
		assertEquals("Osso", labiritno.getStanzaIniziale().getAttrezzo("Osso").getNome());
		assertEquals(5, labiritno.getStanzaIniziale().getAttrezzo("Osso").getPeso());
	}
	
}
