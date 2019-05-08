package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Partita partita;
	private Stanza stanzaNonVincente;
	private Stanza stanzaVincente;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
		this.stanzaNonVincente = new Stanza("stanzaNonVincente");
		this.stanzaVincente = new Stanza("stanzaVincente");
	}

	@Test
	public void testVintaStanzaVincente() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testVintaStanzaNonVincente() {
		this.partita.getLabirinto().setStanzaCorrente(stanzaNonVincente);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testFinitaStanzaVincente() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaZeroCfu() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaImpostata() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
}
