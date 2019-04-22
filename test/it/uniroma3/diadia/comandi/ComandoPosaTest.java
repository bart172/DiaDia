package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	Partita partita;
	Attrezzo attrezzoDaPosare;
	
	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		attrezzoDaPosare = new Attrezzo("attrezzoDaPosare", 1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPosare);
		
	}


	@Test
	public void testEsegui() {
		fail("Not yet implemented");
	}


}
