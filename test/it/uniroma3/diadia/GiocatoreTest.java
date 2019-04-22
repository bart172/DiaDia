package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.Giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	
	/*
	 * Funzioni da testare:
	 *  - getCfu;
	 *  - setCfu;
	 */
	
	Giocatore giocatore;

	@Before
	public void setUp() throws Exception {
		giocatore = new Giocatore();

	}
	
	@Test
	public void testGetCfuIniziali() {
		assertEquals(20, this.giocatore.getCfu());
	}

	@Test
	public void testGetCfuConZeroCfu() {
		this.giocatore.setCfu(0);
		assertEquals(0, this.giocatore.getCfu());
	}
	
	@Test
	public void testGetCfuConCfuNegativi() {
		this.giocatore.setCfu(-1);
		assertEquals(-1, this.giocatore.getCfu());
	}


}
