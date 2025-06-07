package testComandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

class FabbricaDiComandiRiflessivaTest {
	
	private FabbricaDiComandiRiflessiva fabbrica;
	private AbstractComando comando;
	private IOConsole io;
	
	@BeforeEach
	public void setUp() {
		fabbrica = new FabbricaDiComandiRiflessiva();
		comando = null;
		this.io = new IOConsole();
	}
	
	
	// ComandoNonValido
	@Test
	void testComandoNonValidoNull()throws Exception{
		comando = fabbrica.costruisciComando("", io);
        assertEquals("non_valido", comando.getNome());
        assertNull(comando.getParametro());
	}
	
	@Test
	void testComandoNonValidoSconosciuito()throws Exception{
		comando = fabbrica.costruisciComando("fdsgsdgfsdgfs", io);
        assertEquals("non_valido", comando.getNome());
        assertNull(comando.getParametro());
	}
	
	@Test
	void testComandoNonValidoSconosciuitoConParametro() throws Exception{
		comando = fabbrica.costruisciComando("fdsgsdgfsdgfs nord", io);
        assertEquals("non_valido", comando.getNome());
        assertEquals("nord", comando.getParametro());
	}
	
	// ComandoVai
	@Test
	public void testComandoVaiSenzaParametro() throws Exception {
		comando = fabbrica.costruisciComando("vai", io);
		assertEquals("vai", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoVaiConParametro() throws Exception {
		comando = fabbrica.costruisciComando("vai nord", io);
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	// ComandoPosa
	@Test
	public void testComandoPosaSenzaParametro() throws Exception {
		comando = fabbrica.costruisciComando("posa", io);
		assertEquals("posa", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoPosaConParametro() throws Exception {
		comando = fabbrica.costruisciComando("posa orso", io);
		assertEquals("posa", comando.getNome());
		assertEquals("orso", comando.getParametro());
	}
	
	// ComandoPrendi 
	@Test
	public void testComandoPrendiSenzaParametro() throws Exception {
		comando = fabbrica.costruisciComando("prendi", io);
		assertEquals("prendi", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoPrendiConParametro() throws Exception {
		comando = fabbrica.costruisciComando("prendi spada", io);
		assertEquals("prendi", comando.getNome());
		assertEquals("spada", comando.getParametro());
	}
	
	//ComandoAiuto
//	@Test
//	public void testComandoAiuto() throws Exception {
//		comando = fabbrica.costruisciComando("aiuto",io);
//		assertEquals("aiuto", comando.getNome());
//		assertNull(comando.getParametro());
//	}
//	
//	@Test
//	public void testComandoAiutoConParametro() throws Exception {
//		comando = fabbrica.costruisciComando("aiuto gianni", io);
//		assertEquals("aiuto", comando.getNome());
//	}

	//ComandoFine
	@Test 
	public void testComandoFine() throws Exception{
		comando = fabbrica.costruisciComando("fine", io);
		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test 
	public void testComandoFineConParametro() throws Exception{
		comando = fabbrica.costruisciComando("fine basta",io);
		assertEquals("fine", comando.getNome());
		assertEquals("basta",comando.getParametro());
	}
	
	//ComandoGuarda
	@Test
	public void testComandoGuarda() throws Exception{
		comando = fabbrica.costruisciComando("guarda",io);
		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	public void testComandoGuardaConParametro() throws Exception{
		comando = fabbrica.costruisciComando("guarda gianni",io);
		assertEquals("guarda", comando.getNome());
		assertEquals("gianni",comando.getParametro());
	}
	
}
