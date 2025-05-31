package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Mago;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MagoTest {

    private Mago mago;
    private Partita partita;
    private Stanza stanza;
    private Attrezzo bacchetta;

    @BeforeEach
    public void setUp() {
        bacchetta = new Attrezzo("bacchetta", 2);
        mago = new Mago("Merlino", "Sono il mago Merlino!", bacchetta);
        stanza = new Stanza("Torre");
        partita = new Partita();
        partita.setStanzaCorrente(stanza);
    }

    @Test
    public void testAgisci_conAttrezzo() {
        String risultato = mago.agisci(partita);
        assertEquals("Sei un vero simpaticone, con una mia magica azione, troverai un nuovo oggetto per il tuo borsone!", risultato);
        assertTrue(stanza.hasAttrezzo("bacchetta"));
    }

    @Test
    public void testAgisci_senzaAttrezzo() {
        mago.agisci(partita); // prima chiamata lo esaurisce
        String risultato = mago.agisci(partita); // seconda chiamata
        assertEquals("Mi spiace, ma non ho piu' nulla...", risultato);
        // bacchetta non viene aggiunta due volte
        assertEquals(1, stanza.getAttrezzi().size());
    }

    @Test
    public void testRiceviRegalo() {
        Attrezzo libro = new Attrezzo("libro", 4);
        String risultato = mago.riceviRegalo(libro, partita);
        assertEquals("Grazie per questo bellissimo oggetto, gli hodimezzato il peso e messo nella stanza", risultato);

        Attrezzo attrezzoNellaStanza = stanza.getAttrezzo("libro");
        assertNotNull(attrezzoNellaStanza);
        assertEquals(2, attrezzoNellaStanza.getPeso()); // peso dimezzato
    }

    @Test
    public void testSaluta() {
        String primaVolta = mago.saluta();
        assertTrue(primaVolta.contains("Ciao, io sono Merlino."));
        assertTrue(primaVolta.contains("Sono il mago Merlino!"));
        String secondaVolta = mago.saluta();
        assertTrue(secondaVolta.contains("Ci siamo gia' presentati!"));
    }
}
