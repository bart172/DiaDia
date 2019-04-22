package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {


	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		System.out.println("--- STANZA CORRENTE ---");
		System.out.println(partita.getLabirinto().getStanzaCorrente().toString());
		
		System.out.println("--- STATO GIOCATORE ---");
		System.out.println("CFU attuali: " + partita.getGiocatore().getCfu());
		System.out.println(partita.getGiocatore().getBorsa().toString());
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "guarda";
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}


}
