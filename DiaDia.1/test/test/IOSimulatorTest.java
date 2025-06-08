package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class IOSimulatorTest {

    private Labirinto labirinto;

    @BeforeEach
    void setUp() {
        LabirintoBuilder builder = new LabirintoBuilder();

        this.labirinto = builder
            .addStanzaIniziale("Ingresso")
            .addAttrezzo("lanterna", 3)
            .addStanzaMagica("StanzaMagica", 1)
            .addAttrezzo("osso", 1)
            .addStanzaBuia("StanzaBuia", "lanterna")
            .addStanzaBloccata("StanzaBloccata", "chiave", Direzione.NORD)
            .addStanza("StanzaNormale")
            .addAttrezzo("chiave", 1)
            .addStanzaVincente("Uscita")
            // Collegamenti
            .addAdiacenza("Ingresso", "StanzaMagica", "nord")
            .addAdiacenza("StanzaMagica", "StanzaBuia", "est")
            .addAdiacenza("StanzaBuia", "StanzaBloccata", "sud")
            .addAdiacenza("StanzaBloccata", "StanzaNormale", "nord")
            .addAdiacenza("StanzaNormale", "Uscita", "ovest")
            .getLabirinto();
    }

    @Test
    public void testSimulazionePartitaConFine() throws Exception {
        String[] comandi = {
            "vai sud",         // comando non valido in partenza, rimane in Ingresso
            "prendi lanterna", // prende la lanterna
            "vai nord",        // va in StanzaMagica
            "guarda",          // guarda attorno
            "fine"             // termina il gioco
        };

        IOSimulator io = new IOSimulator(List.of(comandi));
        DiaDia gioco = new DiaDia(io, labirinto);
        gioco.gioca();

        boolean messaggioFinaleTrovato = false;
        while (io.hasNextMessaggio()) {
            String messaggio = io.nextMessaggio();
            if (messaggio.equals("Grazie di aver giocato!")) {
                messaggioFinaleTrovato = true;
                break;
            }
        }

        assertTrue(messaggioFinaleTrovato, "Il messaggio di fine gioco non è stato trovato.");
    }

    @Test
    public void testSimulazioneVinta() throws Exception {
        // Percorso minimo per vincere: Ingresso -> nord -> StanzaMagica -> est -> StanzaBuia -> sud -> StanzaBloccata
        // -> prendi chiave -> nord (sblocca) -> StanzaNormale -> ovest -> Uscita
        String[] comandi = {
            "vai nord",       // Ingresso -> StanzaMagica
            "vai est",        // -> StanzaBuia
            "prendi lanterna",// dovrebbe illuminare la StanzaBuia
            "vai sud",        // -> StanzaBloccata
            "prendi chiave",  // prende chiave
            "vai nord",       // -> StanzaNormale (sbloccata)
            "vai ovest",      // -> Uscita
            "fine"            // chiude la partita
        };

        IOSimulator io = new IOSimulator(List.of(comandi));
        DiaDia gioco = new DiaDia(io, labirinto);
        gioco.gioca();

        boolean vittoria = false;
        while (io.hasNextMessaggio()) {
            String messaggio = io.nextMessaggio();
            if (messaggio.equals("Hai vinto!")) {
                vittoria = true;
                break;
            }
        }

        assertTrue(vittoria);
    }

    @Test
    public void testSimulazioneMessaggi() throws Exception {
        String[] comandi = { "vai nord", "vai est", "fine" };
        IOSimulator io = new IOSimulator(List.of(comandi));
        DiaDia gioco = new DiaDia(io, labirinto);
        gioco.gioca();

        assertTrue(io.hasNextMessaggio());

        // Non possiamo sapere con esattezza tutti i messaggi, ma verifichiamo che almeno il messaggio di fine ci sia
        boolean fineTrovato = false;
        while (io.hasNextMessaggio()) {
            if (io.nextMessaggio().equals("Grazie di aver giocato!")) {
                fineTrovato = true;
                break;
            }
        }

        assertTrue(fineTrovato);
    }
}
