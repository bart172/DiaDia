package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() { 
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (attrezzo == null) 
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;

	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a; 
	}

	public int getPeso() {
		int peso = 0;

		for (int i= 0; i<this.numeroAttrezzi; i++) {
			peso += this.attrezzi[i].getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if (this.hasAttrezzo(nomeAttrezzo)) {
			a = this.getAttrezzo(nomeAttrezzo);
		}

		boolean trovato = false;
		int mark = 0;		//ricorda la posizione dell'attrezzo da rimuovere

		/* trovo l'attrezzo da rimuovere, me ne ricordo la posizione e scorro l'array per rimpiazzarlo */
		for (int i = 0; i<attrezzi.length & trovato; i++) {
			if (attrezzi[i] != null) {
				mark++;
				if (attrezzi[i].getNome().equals(nomeAttrezzo)) {
					trovato = true;
				}
			}
		}

		for (int i = mark; i<attrezzi.length-1; i++) {
			attrezzi[i] = attrezzi[i+1];
		}

		if (trovato) {
			this.pesoMax -= a.getPeso();
			this.numeroAttrezzi--;
		}
		return a; 

	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		
		if (this.isEmpty()) {
			s.append("La borsa è vuota.");
		} else {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}

		return s.toString();

	}

}