package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "guardaborsa"};
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "aiuto";
	}


}
