package it.uniroma3.diadia.giocatore;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPesoENome;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private List<Attrezzo> attrezzi;
	private int pesoMax;


	public Borsa() { 
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); // speriamo che bastino...
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso()+attrezzo.getPeso() <= getPesoMax())
			return this.attrezzi.add(attrezzo);
		else
			return false;
		}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null; 
	}

	public int getPeso() {
		int accumulatore = 0;
		Iterator<Attrezzo> it = this.getAttrezzi().iterator();
		Attrezzo attrezzo = null;
		while(it.hasNext()) {
			attrezzo = it.next();
			accumulatore+=attrezzo.getPeso();
		}
		
		return accumulatore;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while (it.hasNext()) {
			a = it.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				it.remove();
				return a;
				}
			}
		return null;
		}

	public String toString() {
		StringBuilder s = new StringBuilder();
		Iterator <Attrezzo> it = this.attrezzi.iterator();
		if (this.isEmpty()) {
			s.append("La borsa è vuota.");
		} else {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			while(it.hasNext()) {
				s.append(this.attrezzi.toString()+" ");
			}
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
	
	public Map<Integer, Set<Attrezzo>>getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> peso2Attrezzi = new HashMap<>();  //peso to attrezzi
		for(Attrezzo a : this.getAttrezzi()) {
			if(peso2Attrezzi.containsKey(a.getPeso())){
				Set<Attrezzo> oldSet = null;
				oldSet = peso2Attrezzi.get(a.getPeso());
				oldSet.add(a);
			}
			else {
				Set<Attrezzo> newSet = new HashSet<>();
				newSet.add(a);
				peso2Attrezzi.put(a.getPeso(),newSet);
			}
		}
		return peso2Attrezzi;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> a = new TreeSet<Attrezzo>(new ComparatorePerPesoENome());
		a.addAll(this.getAttrezzi());
		return a;
	}
	
	//Seconda opzione: non � utile, anche perch� � limitato
//	public Map<Integer, Set<Attrezzo>>getContenutoRaggruppatoPerPesoLimitatoMax10(){
//		Map<Integer, Set<Attrezzo>> peso2Attrezzi = new HashMap<>();
//		for(int i=0; i<10; i++) {
//			final HashSet<Attrezzo> hashSet = new HashSet<>();
//			peso2Attrezzi.put(i, hashSet);
//		}
//		for(Attrezzo a : this.getAttrezzi()) {
//			peso2Attrezzi.get(a.getPeso()).add(a);
//		}
//		return peso2Attrezzi;
//	}
}
