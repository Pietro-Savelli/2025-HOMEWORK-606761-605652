package testLabirinto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirintoTest {

    @Test
    public void testMonolocale() throws Exception {
//        CaricatoreLabirinto loader = new CaricatoreLabirinto("C:\\Users\\Home\\Desktop\\Git Rep\\2025-HOMEWORK-606761-605652\\2025-HOMEWORK-606761-605652\\DiaDia.1\\test\\testLabirinto\\l1.txt");
//        loader.carica();
//        Labirinto lab = loader.getLabirinto();
//        assertNotNull(lab.getStanzaIniziale());
//        assertNotNull(lab.getStanzaFinale());
//        assertEquals(lab.getStanzaIniziale(), lab.getStanzaFinale());
//        assertEquals("stanzaUnica", lab.getStanzaIniziale().getNome());
//        assertTrue(lab.getStanzaIniziale().getAttrezzi().isEmpty());
    	CaricatoreLabirinto loader = new CaricatoreLabirinto("C:\\Users\\Home\\Desktop\\Git Rep\\2025-HOMEWORK-606761-605652\\2025-HOMEWORK-606761-605652\\DiaDia.1\\test\\testLabirinto\\l1.txt");
    	loader.carica();
    	Labirinto lab = loader.getLabirinto();

    	assertEquals("N10", lab.getStanzaIniziale().getNome());
    	assertEquals("N11", lab.getStanzaFinale().getNome());
    	//assertTrue(lab.getListaStanze().get("biblioteca").hasAttrezzo("martello"));
    }
    
    

//    @Test
//    public void testBilocale() throws Exception {
//        CaricatoreLabirinto loader = new CaricatoreLabirinto("src/test/resources/labirinto_bilocale.txt");
//        loader.carica();
//        Labirinto lab = loader.getLabirinto();
//
//        Stanza ingresso = lab.getStanzaIniziale();
//        Stanza camera = lab.getStanzaFinale();
//        assertNotNull(ingresso);
//        assertNotNull(camera);
//        assertEquals("ingresso", ingresso.getNome());
//        assertEquals("camera", camera.getNome());
//
//        // Verifica attrezzo chiave
//        assertTrue(ingresso.hasAttrezzo("chiave"));
//        Attrezzo chiave = ingresso.getAttrezzo("chiave");
//        assertNotNull(chiave);
//        assertEquals(1, chiave.getPeso());
//
//        // Verifica adiacenze
//        assertEquals(camera, ingresso.getStanzaAdiacente("nord"));
//        assertEquals(ingresso, camera.getStanzaAdiacente("sud"));
//    }
//
//    @Test
//    public void testTrilocale() throws Exception {
//        CaricatoreLabirinto loader = new CaricatoreLabirinto("src/test/resources/labirinto_trilocale.txt");
//        loader.carica();
//        Labirinto lab = loader.getLabirinto();
//
//        Stanza ingresso = lab.getStanzaIniziale();
//        Stanza camera = lab.getStanzaFinale();
//        Stanza salotto = ingresso.getStanzaAdiacente("nord");
//
//        assertNotNull(salotto);
//        assertEquals("salotto", salotto.getNome());
//
//        // Verifica attrezzi
//        assertTrue(ingresso.hasAttrezzo("chiave"));
//        assertTrue(salotto.hasAttrezzo("libro"));
//
//        // Verifica collegamenti
//        assertEquals(salotto, ingresso.getStanzaAdiacente("nord"));
//        assertEquals(camera, salotto.getStanzaAdiacente("nord"));
//        assertEquals(salotto, camera.getStanzaAdiacente("sud"));
//    }
//
//    @Test
//    public void testStanzaMagica() throws Exception {
//        CaricatoreLabirinto loader = new CaricatoreLabirinto("src/test/resources/labirinto_quadrilocale_magico.txt");
//        loader.carica();
//        Labirinto lab = loader.getLabirinto();
//        Stanza laboratorio = lab.getStanzaFinale();
//        assertTrue(laboratorio instanceof StanzaMagica);
//        assertEquals("laboratorio", laboratorio.getNome());
//        assertTrue(laboratorio.hasAttrezzo("pozione"));
//    }
//
//    @Test
//    public void testStanzaBuiaEBloccata() throws Exception {
//        CaricatoreLabirinto loader = new CaricatoreLabirinto("src/test/resources/labirinto_buia_bloccata.txt");
//        loader.carica();
//        Labirinto lab = loader.getLabirinto();
//        Stanza cantina = null;
//        Stanza porta = null;
//        // Ricerca per tipo
//        for (Stanza s : loader.getLabirinto().getListaStanze().values()) {
//            if (s instanceof StanzaBuia)
//                cantina = s;
//            if (s instanceof StanzaBloccata)
//                porta = s;
//        }
//        assertNotNull(cantina);
//        assertEquals("cantina", cantina.getNome());
//        assertNotNull(porta);
//        assertEquals("porta", porta.getNome());
//    }
}
