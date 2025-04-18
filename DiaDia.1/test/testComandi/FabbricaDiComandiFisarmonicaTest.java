package testComandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	private Comando comando;
	
	@BeforeEach
	public void setUp() {
		fabbrica = new FabbricaDiComandiFisarmonica();
		comando = null;
	}
	
	
	// ComandoNonValido
	@Test
	void testComandoNonValidoNull() {
		comando = fabbrica.costruisciComando("");
        assertEquals("non valido", comando.getNome());
        assertNull(comando.getParametro());
	}
	
	@Test
	void testComandoNonValidoSconosciuito() {
		comando = fabbrica.costruisciComando("fdsgsdgfsdgfs");
        assertEquals("non valido", comando.getNome());
        assertNull(comando.getParametro());
	}
	
	@Test
	void testComandoNonValidoSconosciuitoConParametro() {
		comando = fabbrica.costruisciComando("fdsgsdgfsdgfs nord");
        assertEquals("non valido", comando.getNome());
        assertNull(comando.getParametro());
	}
	
	// ComandoVai
	@Test
	public void testComandoVaiSenzaParametro() {
		comando = fabbrica.costruisciComando("vai");
		assertEquals("vai", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoVaiConParametro() {
		comando = fabbrica.costruisciComando("vai nord");
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	// ComandoPosa
	@Test
	public void testComandoPosaSenzaParametro() {
		comando = fabbrica.costruisciComando("posa");
		assertEquals("posa", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoPosaConParametro() {
		comando = fabbrica.costruisciComando("posa orso");
		assertEquals("posa", comando.getNome());
		assertEquals("orso", comando.getParametro());
	}
	
	// ComandoPrendi 
	@Test
	public void testComandoPrendiSenzaParametro() {
		comando = fabbrica.costruisciComando("prendi");
		assertEquals("prendi", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoPrendiConParametro() {
		comando = fabbrica.costruisciComando("prendi spada");
		assertEquals("prendi", comando.getNome());
		assertEquals("spada", comando.getParametro());
	}
	
	//ComandoAiuto
	@Test
	public void testComandoAiuto() {
		comando = fabbrica.costruisciComando("aiuto");
		assertEquals("aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoAiutoConParametro() {
		comando = fabbrica.costruisciComando("aiuto gianni");
		assertEquals("aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}

	//ComandoFine
	@Test 
	public void testComandoFine() {
		comando = fabbrica.costruisciComando("fine");
		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test 
	public void testComandoFineConParametro() {
		comando = fabbrica.costruisciComando("fine basta");
		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	//ComandoGuarda
	@Test
	public void testComandoGuarda() {
		comando = fabbrica.costruisciComando("guarda");
		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoGuardaConParametro() {
		comando = fabbrica.costruisciComando("guarda gianni");
		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
