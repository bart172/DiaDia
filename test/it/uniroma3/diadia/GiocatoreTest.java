package it.uniroma3.diadia;
import it.uniroma3.diadia.giocatore.Giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	private Giocatore giocatore;
	
	@Before
	public void setUp(){
		giocatore = new Giocatore();
	}

	/*-------------------------TEST GET-CFU----------------------------*/
	@Test
	public void testCfuIniziali() {
		assertEquals(20, this.giocatore.getCfu());
	}
	
	@Test
	public void testCfuDiversiDaQuelliIniziali() {
		assertNotEquals(10, this.giocatore.getCfu());
	}
	
	/*-------------------------TEST SET-CFU----------------------------*/
	
	@Test
	public void testCfuPositivi() {
		this.giocatore.setCfu(5);
		assertEquals(5, this.giocatore.getCfu());
	}
	
	@Test
	public void testCfuNegativi() {
		this.giocatore.setCfu(-1);
		assertEquals(-1, this.giocatore.getCfu());
	}	
	
	@Test
	public void testZeroCfu() {
		this.giocatore.setCfu(0);
		assertEquals(0, this.giocatore.getCfu());
	}
}
