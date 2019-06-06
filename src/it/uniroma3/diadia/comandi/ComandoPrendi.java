package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	private String nomeAttrezzo;


	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Attrezzo att = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			if(partita.getGiocatore().getBorsa().getPeso() + att.getPeso() < partita.getGiocatore().getBorsa().getPesoMax()) {
				partita.getStanzaCorrente().removeAttrezzo(att);
				partita.getGiocatore().getBorsa().addAttrezzo(att);
				System.out.println("L'oggetto � stato preso! Ora � nella tua borsa");
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
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

}
