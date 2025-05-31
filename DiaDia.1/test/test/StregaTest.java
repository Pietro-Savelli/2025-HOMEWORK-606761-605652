package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Strega;

public class StregaTest {

    private Partita partita;
    private Strega strega;

    @BeforeEach
    public void setUp() {
        Labirinto labirinto = new LabirintoBuilder()
            .addStanzaIniziale("iniziale")
            .addStanza("vuota")
            .addAdiacenza("iniziale", "vuota", "nord")
            .addStanza("media")
            .addAttrezzo("chiave", 1) // 1 attrezzo
            .addAdiacenza("iniziale", "media", "sud")
            .addStanza("piena")
            .addAttrezzo("spada", 2)
            .addAttrezzo("scudo", 3) // 2 attrezzi
            .addAdiacenza("iniziale", "piena", "est")
            .getLabirinto();

        this.partita = new Partita(labirinto);
        this.partita.setStanzaCorrente(labirinto.getStanzaIniziale());

        this.strega = new Strega("Morgana", "Sono una strega permalosa.");
    }

    @Test
    public void testAgisciSenzaSaluto() {
        String messaggio = strega.agisci(partita);
        assertEquals("vuota", partita.getStanzaCorrente().getNome(),
            "Senza saluto, la strega dovrebbe spostare nella stanza con meno attrezzi");
        assertTrue(messaggio.contains("ti ho spostato"),
            "Il messaggio dovrebbe comunicare lo spostamento");
    }

    @Test
    public void testAgisciConSaluto() {
        strega.saluta(); // Ora haSalutato == true
        String messaggio = strega.agisci(partita);
        assertEquals("piena", partita.getStanzaCorrente().getNome(),
            "Dopo il saluto, la strega dovrebbe spostare nella stanza con più attrezzi");
        assertTrue(messaggio.contains("ti ho spostato"),
            "Il messaggio dovrebbe comunicare lo spostamento");
    }

    @Test
    public void testRiceviRegalo() {
        Attrezzo regalo = new Attrezzo("cosa", 1);
        String risposta = strega.riceviRegalo(regalo, partita);
        assertEquals("ahahahahahah hai perso il tuo oggetto per sempre", risposta,
            "La risposta dovrebbe indicare la perdita dell'oggetto");
    }
}
