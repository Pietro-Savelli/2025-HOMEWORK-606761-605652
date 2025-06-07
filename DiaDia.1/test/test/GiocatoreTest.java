package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

    private Giocatore giocatore;
    private Attrezzo spada;
    
    @BeforeEach
    void setUp() {
        giocatore = new Giocatore();
        spada = new Attrezzo("Spada", 3);
    }

    @Test
    void testGiocatoreCfuIniziali() {
        assertEquals(20, giocatore.getCfu(), "Il giocatore deve avere 20 CFU iniziali");
    }

    @Test
    void testSetCfu() {
        giocatore.setCfu(15);
        assertEquals(15, giocatore.getCfu(), "Dopo la modifica, i CFU devono essere 15");
    }

    @Test
    void testBorsaNonNull() {
        assertNotNull(giocatore.getBorsa(), "La borsa del giocatore non deve essere null");
    }

    @Test
    void testAggiuntaAttrezzo() {
        assertTrue(giocatore.getBorsa().addAttrezzo(spada), "L'attrezzo deve essere aggiunto con successo");
        assertTrue(giocatore.getBorsa().hasAttrezzo("Spada"), "La borsa deve contenere la Spada");
    }

    @Test
    void testRimozioneAttrezzo() {
        giocatore.getBorsa().addAttrezzo(spada);
        assertNotNull(giocatore.getBorsa().removeAttrezzo("Spada"), "L'attrezzo deve essere rimosso con successo");
        assertFalse(giocatore.getBorsa().hasAttrezzo("Spada"), "La borsa non deve contenere la Spada dopo la rimozione");
    }

    @Test
    void testRimozioneAttrezzoNonPresente() {
        assertFalse(giocatore.getBorsa().removeAttrezzo("Martello"), "Tentare di rimuovere un attrezzo non presente deve restituire null");
    }
}
