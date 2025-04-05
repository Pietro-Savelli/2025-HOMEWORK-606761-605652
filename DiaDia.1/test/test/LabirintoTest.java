package test;

import static org.junit.Assert.*;

import it.uniroma3.diadia.ambienti.Labirinto;
import org.junit.Test;

public class LabirintoTest {

    private final Labirinto labirinto = new Labirinto();

    @Test
    public void testGetStanzaIniziale() {
        assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
    }

    @Test
    public void testGetStanzaVincente() {
        assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());
    }

    @Test
    public void testStanzaInizialeNonUgualeAdAltraStanza() {
        assertNotEquals("Stanza diversa", labirinto.getStanzaIniziale().getNome());
    }
}
