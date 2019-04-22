package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		labirinto = new Labirinto();
	}
	
	/* Da testare:
	 *  - creaStanze;
	 *  - getStanzaCorrente;
	 *  - setStanzaCorrente;
	 */

	
	@Test
	public void testInitRestituisceStanzaVincente() {
		labirinto.creaStanze();
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testInitRestituisceStanzaCorrente() {
		labirinto.creaStanze();
		assertEquals("Atrio", this.labirinto.getStanzaCorrente().getNome());
	}
	

	
	@Test
	public void testGetStanzaVincenteConStanzaCheNonEsiste() {
		labirinto.creaStanze();
		assertNotEquals("StanzaCheNonEsiste", this.labirinto.getStanzaVincente().getNome());
	}

	@Test 
	public void testSetStanzaCorrenteConStanzaNull() {
		labirinto.setStanzaCorrente(null);
		assertNull(this.labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrenteConStanzaVincente() {
		labirinto.creaStanze();
		labirinto.setStanzaCorrente(this.labirinto.getStanzaVincente());
		assertEquals("Biblioteca", this.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	
	public void testSetStanzaCorenteConStanzaNull() {
		labirinto.setStanzaCorrente(null);
		assertNull(this.labirinto.getStanzaCorrente());
	}
}
