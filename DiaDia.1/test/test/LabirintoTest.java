package test;

import static org.junit.Assert.*;

import it.uniroma3.diadia.ambienti.Labirinto;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class LabirintoTest {
	
	private static final String VINCENTE = "vincente";
	private static final String INIZIALE = "iniziale";
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		this.labirinto = Labirinto.newBuilder()
				.addStanzaIniziale(INIZIALE)
				.addStanzaVincente(VINCENTE)
				.getLabirinto();
	}

	@Test
	public void testGetStanzaIniziale() {
		assertEquals(INIZIALE, this.labirinto.getStanzaIniziale().getNome());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals(VINCENTE, this.labirinto.getStanzaVincente().getNome());
	}

}
