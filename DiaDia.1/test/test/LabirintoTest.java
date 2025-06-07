package test;

import static org.junit.Assert.*;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.ambienti.Labirinto;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class LabirintoTest {
	
	private String VINCENTE = "LabCampusOne";
	private  String INIZIALE = "Biblioteca";
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() {
		labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","nord")
				.getLabirinto();
//		DiaDia gioco = new DiaDia(new IOConsole(), labirinto);
//		gioco.gioca();
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
