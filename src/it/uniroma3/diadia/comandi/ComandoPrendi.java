package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Attrezzo att = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			if(partita.getGiocatore().getBorsa().getPeso() + att.getPeso() < partita.getGiocatore().getBorsa().getPesoMax()) {
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(att);
				partita.getGiocatore().getBorsa().addAttrezzo(att);
				System.out.println("Hai preso "+ att + " e l'hai messo nella borsa.");
			}
			else
				System.out.println("Hai superato il limite di peso della tua borsa");
		}
		else
			System.out.println("Non puoi prendere " + nomeAttrezzo);

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

}
