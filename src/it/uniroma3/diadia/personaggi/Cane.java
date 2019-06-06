package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private String ciboPreferito = "Carne";
	private Attrezzo pistola = new Attrezzo("Pistola", 3);

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return "Hey! Il cane ti ha morso. Hai perso 1 CFU.";
	}
	
	@Override
	public String saluta() {
		return "Bau! Bau! Bau!";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {

		if (attrezzo.getNome().equals(this.ciboPreferito)) {
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			partita.getStanzaCorrente().addAttrezzo(this.pistola);
			
			return "Bau! Bau! Bau! (ho davvero gradito questo succoso pezzo di carne, eccoti la mia pistola.)";
		} else {
			return "Bau! Bau! Bau! (non mi piace! Quanto vorrei un po'di carne...)";
		}
	}

}
