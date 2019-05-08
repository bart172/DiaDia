package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPesoENome;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private int pesoMax;

	private List<Attrezzo> attrezzi;


	public Borsa() { 
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while (it.hasNext()) {
			Attrezzo a = it.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}

	public int getPeso() {
		int accumulatore = 0;
		for (Attrezzo attrezzo : this.getAttrezzi()) {
			accumulatore+=attrezzo.getPeso();
		}
		return accumulatore;
	}

	public boolean isEmpty() {
		return attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a; 
			}
		}
		return null;

	}

	public String toString() {
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		StringBuilder s = new StringBuilder();
		if (this.isEmpty()) {
			s.append("Borsa vuota");
		} else
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");

		while(it.hasNext()) { 
				s.append(it.next().toString() + " ");
		}

		return s.toString();

	}


	public List<Attrezzo> getAttrezzi() {
		return Collections.unmodifiableList(this.attrezzi);
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> ordinati = new ArrayList<Attrezzo>(this.getAttrezzi());
		Collections.sort(ordinati, new ComparatorePerPesoENome());
		return ordinati;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<Attrezzo>(this.getAttrezzi());
	}
}
