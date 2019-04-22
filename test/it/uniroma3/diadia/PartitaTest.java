package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
	}

	@Test
	public void testVintaInizioPartita() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testVintaStanzaNonVincente() {
		this.partita.getLabirinto().setStanzaCorrente(new Stanza(("stanzaNonVincente")));
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testVintaSenzaStanzaVincente() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	
	

}
