package testComandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

class AbstractComandoTest {

	private AbstractComando comando;
	private IO io;

	// Classe nidificata per testare AbstractComando
	static class ComandoProva extends AbstractComando {
		public ComandoProva(String parametro, IO io) {
			super(parametro, io);
		}

		public ComandoProva() {
			super();
		}

		@Override
		public void esegui(Partita partita) {
		}

		@Override
		public String getNome() {
			return "comandoProva";
		}
	}



	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole();
		comando = new ComandoProva("prova", io);
	}

	@Test
	void testGetParametro() {
		assertEquals("prova", comando.getParametro());
	}
	
	@Test
	void testGetConsole() {
		assertSame(io, comando.getConsole());
	}
	
    @Test
    void testCostruttoreVuoto() {
        AbstractComando cmdVuoto = new ComandoProva();
        assertNull(cmdVuoto.getParametro());
        assertNull(cmdVuoto.getConsole());
    }

}
