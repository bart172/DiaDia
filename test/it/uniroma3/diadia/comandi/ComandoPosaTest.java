package it.uniroma3.diadia.comandi;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;

public class ComandoPosaTest {

 Partita partita;
 Attrezzo attrezzoDaPosare;

 @Before
 public void setUp() throws Exception {
  partita = new Partita();
  attrezzoDaPosare = new Attrezzo("attrezzoDaPosare", 1);
  partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPosare);

 }

    /*---------Test getNome-------*/

 @Test
 public void testGetNomePositivo() {
  ComandoPosa comandoPosa = new ComandoPosa();
  assertEquals("posa", comandoPosa.getNome());
 }

 @Test
 public void testGetNomeNegativo() {
  ComandoPosa comandoPosa = new ComandoPosa();
  assertNotEquals("comando sconosciuto", comandoPosa.getNome());
 }

 /*-----------Test setParametro------------*/
 @Test
 public void testSetParametroPositivo() {
  ComandoPosa comandoPosa = new ComandoPosa();
  comandoPosa.setParametro("attrezzo1");
  assertEquals("attrezzo1", comandoPosa.getParametro());
 }

 @Test
 public void testSetParametroNegativo() {
  ComandoPosa comandoPosa = new ComandoPosa();
  comandoPosa.setParametro("attrezzo1");
  assertNotEquals("attrezzo2", comandoPosa.getParametro());
 }

 /*---------Test getParametro-------*/

 @Test
 public void testGetParametroPositivo() {
  ComandoPosa comandoPosa = new ComandoPosa();
  comandoPosa.setParametro("attrezzoDaPosare");
  assertEquals("attrezzoDaPosare", comandoPosa.getParametro());
 }

 @Test 
 public void testGetParametroNegativo() {
  ComandoPosa comandoPosa = new ComandoPosa();
  comandoPosa.setParametro("attrezzoDaPosare");
  assertNotEquals("attrezzoNonDaPosare", comandoPosa.getParametro());
 }

 /*---------Test Esegui-------*/

 @Test 
 public void testEseguiDiUnAttrezzoDaPosare() {
  ComandoPosa comandoPosa = new ComandoPosa();
  comandoPosa.setParametro("attrezzoDaPosare");
  comandoPosa.esegui(partita);
  assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzoDaPosare"));
 }

 @Test
 public void testEseguiDiUnAttrezzoNonNellaBorsa() {
  ComandoPosa comandoPosa = new ComandoPosa();
  comandoPosa.setParametro("attrezzoNonNellaBorsa");
  comandoPosa.esegui(partita);
  assertFalse(partita.getGiocatore().getBorsa().isEmpty());
 }


}