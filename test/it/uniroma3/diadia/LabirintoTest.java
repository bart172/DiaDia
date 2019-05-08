package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

	/*Da testare:
	 * init()
	 * getStanzaVincente()
	 * setStanzaCorrente()
	 * getStanzaCorrente()
	 * */
	Labirinto labirinto;
	
	@Before
	public void setUp() {
		labirinto = new Labirinto();
	}

	/*----------------TEST GET-STANZA-VINCENTE--------------*/	
	@Test
	public void testGetStanzaVincenteConStanzaVincente() {
		labirinto.creaStanze();
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaVincenteConStanzaCheNonEsiste() {
		labirinto.creaStanze();
		assertNotEquals("StanzaCheNonEsiste", this.labirinto.getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaVincenteConStanzaCorrenteNonVincente() {
		labirinto.creaStanze();
		assertNotEquals("Atrio", this.labirinto.getStanzaVincente().getNome());
	}
	
	/*----------------TEST GET-STANZA-CORRENTE---------------*/
	@Test
	public void testGetStanzaCorrenteConStanzaCorrente() {
		labirinto.creaStanze();
		assertEquals("Atrio", this.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrenteConStanzaCheNonEsiste() {
		labirinto.creaStanze();
		assertNotEquals("StanzaCheNonEsiste", this.labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrenteConStanzaVincenteNonCorrente() {
		labirinto.creaStanze();
		assertNotEquals("Biblioteca", this.labirinto.getStanzaCorrente().getNome());
	}
	
	
	/*----------------TEST SET-STANZA---------------*/
	
	@Test
	public void testSetStanzaCorrenteConStanzaVincente() {
		labirinto.creaStanze();
		labirinto.setStanzaCorrente(this.labirinto.getStanzaVincente());
		assertEquals("Biblioteca", this.labirinto.getStanzaCorrente().getNome());
	}
		
	@Test
	public void testSetStanzaCorrenteConStanzaNull() {
		labirinto.setStanzaCorrente(null);
		assertNull(this.labirinto.getStanzaCorrente());
	}
	
}
