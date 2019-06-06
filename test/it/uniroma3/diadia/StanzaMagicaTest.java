package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagicaTest {
 StanzaMagica magic = new StanzaMagica("Magic", 2);
 Attrezzo attrezzoMagico1;
 Attrezzo attrezzoMagico2;
 Attrezzo attrezzoMagico3;

 
 @Before
 public void setUp() throws Exception {
  magic = new StanzaMagica("Magic", 2);
  attrezzoMagico1 = new Attrezzo("attrezzoMagico1", 1);
  attrezzoMagico2 = new Attrezzo("attrezzoMagico2", 3);
  attrezzoMagico3 = new Attrezzo("attrezzoMagico3", 5); 
 }
 

 @Test
 public void testPosaUnaVolta() {
  this.magic.addAttrezzo(attrezzoMagico1);
  assertTrue(this.magic.hasAttrezzo("attrezzoMagico1"));
  assertSame(1, this.magic.getAttrezzo("attrezzoMagico1").getPeso());  
 }
 
 @Test
 public void testPosaDueVolte() {
  this.magic.addAttrezzo(attrezzoMagico1);
  this.magic.addAttrezzo(attrezzoMagico2);
  assertTrue(this.magic.hasAttrezzo("attrezzoMagico1"));
  assertFalse(this.magic.hasAttrezzo("attrezzoMagico2"));
  assertTrue(this.magic.hasAttrezzo("2ocigaMozzertta"));
  }
 
 @Test
 public void testPosatoDueVolteHaPesoDoppio() {
  this.magic.addAttrezzo(attrezzoMagico1);
  this.magic.addAttrezzo(attrezzoMagico2);
  assertSame(1, this.magic.getAttrezzo("attrezzoMagico1").getPeso());
  assertSame(6, this.magic.getAttrezzo("2ocigaMozzertta").getPeso());
 }

 @Test
 public void testPosaTreVolte() {
  this.magic.addAttrezzo(attrezzoMagico1);
  this.magic.addAttrezzo(attrezzoMagico2);
  this.magic.addAttrezzo(attrezzoMagico3);
  assertTrue(this.magic.hasAttrezzo("attrezzoMagico1"));
  assertFalse(this.magic.hasAttrezzo("attrezzoMagico2"));
  assertFalse(this.magic.hasAttrezzo("attrezzoMagico3"));
  assertTrue(this.magic.hasAttrezzo("2ocigaMozzertta"));
  assertTrue(this.magic.hasAttrezzo("3ocigaMozzertta"));  
  }
 
 @Test
 public void testPosatiPiùDiDueVolteHannoPesoDoppio() {
  this.magic.addAttrezzo(attrezzoMagico1);
  this.magic.addAttrezzo(attrezzoMagico2);
  this.magic.addAttrezzo(attrezzoMagico3);
  assertSame(1, this.magic.getAttrezzo("attrezzoMagico1").getPeso());
  assertSame(6, this.magic.getAttrezzo("2ocigaMozzertta").getPeso());
  assertSame(10, this.magic.getAttrezzo("3ocigaMozzertta").getPeso());
 }
}