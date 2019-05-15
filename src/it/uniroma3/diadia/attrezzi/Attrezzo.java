
package it.uniroma3.diadia.attrezzi;

import java.util.Objects;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo> {

	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
		Objects.requireNonNull(nome, "Non puoi creare attrezzi senza nome!");
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
	
	/**
	 * Restituisce l'attrezzo nel formato <i>nome:peso</i>
	 */
	public String restituisciNome() {
		StringBuilder s = new StringBuilder();
		s.append(this.nome);
		s.append(":");
		s.append(this.peso);
		
		return s.toString();
	}

	@Override 
	public boolean equals(Object o) {
		Attrezzo that = (Attrezzo)o;

		return Objects.equals(this.getNome(), that.getNome());
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	@Override
	public int compareTo(Attrezzo that) {
		return this.getNome().compareTo(that.getNome());
	}

}

//package it.uniroma3.diadia.attrezzi;
//
//import it.uniroma3.diadia.ambienti.Stanza;
//
///**
//* Una semplice classe che modella un attrezzo.
//* Gli attrezzi possono trovarsi all'interno delle stanze
//* del labirinto.
//* Ogni attrezzo ha un nome ed un peso.
//*
//* @author  docente di POO
//* @see Stanza
//* @version base
//*/
//public class Attrezzo {
//
//	private String nome;
//	private int peso;
//
//	/**
//	 * Crea un attrezzo
//	 * @param nome il nome che identifica l'attrezzo
//	 * @param peso il peso dell'attrezzo
//	 */
//	public Attrezzo(String nome, int peso) {
//		this.peso = peso;
//		this.nome = nome;
//	}
//
//	/**
//	 * Restituisce il nome identificatore dell'attrezzo
//	 * @return il nome identificatore dell'attrezzo
//	 */
//	public String getNome() {
//		return this.nome;
//	}
//
//	/**
//	 * Restituisce il peso dell'attrezzo
//	 * @return il peso dell'attrezzo
//	 */
//	public int getPeso() {
//		return this.peso;
//	}
//
//	/**
//	 * Restituisce una rappresentazione stringa di questo attrezzo
//	 * @return la rappresentazione stringa
//	 */
//	public String toString() {
//		return this.getNome()+" ("+this.getPeso()+"kg)";
//	}
//
//}