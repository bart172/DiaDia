package it.uniroma3.diadia.comandi;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoGuardaBorsa implements Comando {

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void esegui(Partita partita) {
		System.out.println("-- BORSA ORDINATA PER PESO --");
		List<Attrezzo> ordinataPerPeso = partita.getGiocatore().getBorsa().getContenutoOrdinatoPerPeso();
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		Iterator<Attrezzo> it = ordinataPerPeso.iterator();
		Attrezzo a;
		while(it.hasNext()) {
			a = it.next();
			s.append(a.restituisciNome());
			s.append(", ");
		}
		s.append("]");
		System.out.println(s.toString());
		
		
		System.out.println("-- BORSA ORDINATA PER NOME --");
		Set<Attrezzo> ordinataPerNome = partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome();
		
		StringBuilder str = new StringBuilder();
		str.append("{");
		Iterator<Attrezzo> iter = ordinataPerNome.iterator();
		a = null;
		while(iter.hasNext()) {
			a = iter.next();
			str.append(a.restituisciNome());
			str.append(", ");
		}
		str.append("}");
		System.out.println(str.toString());
		
		System.out.println("-- BORSA RAGGRUPPATA PER PESO --");
		Map<Integer, Set<Attrezzo>> raggruppataPerPeso = partita.getGiocatore().getBorsa().getContenutoRaggruppatoPerPeso();
		
		
	}
	

	@Override
	public String getNome() {
		return "guardaBorsa";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
