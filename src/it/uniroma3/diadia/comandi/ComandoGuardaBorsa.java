package it.uniroma3.diadia.comandi;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoGuardaBorsa extends AbstractComando {

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

		s = new StringBuilder();
		s.append("{");
		Iterator<Attrezzo> iter = ordinataPerNome.iterator();
		a = null;
		while(iter.hasNext()) {
			a = iter.next();
			s.append(a.restituisciNome());
			s.append(", ");
		}
		s.append("}");
		System.out.println(s.toString());

		System.out.println("-- BORSA RAGGRUPPATA PER PESO --");
		Map<Integer, Set<Attrezzo>> raggruppataPerPeso = partita.getGiocatore().getBorsa().getContenutoRaggruppatoPerPeso();
		s = new StringBuilder();
		s.append("(");

		for (int i = 0; i<=10; i++) {	//itero sui pesi, non possono essere maggiori di 10
			if (raggruppataPerPeso.containsKey(i)) {	//stampo solo se ho attrezzi con quel peso
				
				s.append(i + ": [");
				
				Set<Attrezzo> attrezzi = raggruppataPerPeso.get(i);
				Iterator<Attrezzo> iterator = attrezzi.iterator();
				while (iterator.hasNext()) {
					s.append(iterator.next().getNome() + ", ");
				}
				s.append("], ");
			}
		}
		s.append(")");
		System.out.println(s.toString());

	}


	@Override
	public String getNome() {
		return "guardaBorsa";
	}


}
