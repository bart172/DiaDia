package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica factory;
	@Before
	public void setUp() throws Exception {
		this.factory = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testComandoVai() {
		Comando comando = this.factory.costruisciComando("vai nord");
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}

}
