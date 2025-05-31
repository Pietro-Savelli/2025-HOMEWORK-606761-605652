package test;
import static org.junit.Assert.*;

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

        this.strega = new Strega("Morgana", "super magona");
    }

    @Test
    public void testAgisciSenzaSaluto() {
        strega.agisci(partita);
        assertEquals("vuota", partita.getStanzaCorrente().getNome());
    }

    @Test
    public void testAgisciConSaluto() {
        strega.saluta(); // haSalutato true
        String messaggio = strega.agisci(partita);
        assertEquals("piena", partita.getStanzaCorrente().getNome());
    }

    @Test
    public void testRiceviRegalo() {
        Attrezzo regalo = new Attrezzo("cosa", 1);
        String risposta = strega.riceviRegalo(regalo, partita);
        assertEquals("ahahahahahah hai perso il tuo oggetto per sempre", risposta);
        assertFalse(partita.getStanzaCorrente().hasAttrezzo("regalo"));
    }
}
