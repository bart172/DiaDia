package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String passepartout;
	
	public StanzaBloccata (String nome, String direzione, String passepartout) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.passepartout = passepartout;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.direzioneBloccata)) {
			if(super.hasAttrezzo(this.passepartout))
				return super.getStanzaAdiacente(direzioneBloccata);
			else 
				return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(passepartout)) {
			StringBuilder stampa = new StringBuilder();
			stampa.append("Ti trovi in una stanza bloccata: ");
			stampa.append(this.toString());
			stampa.append("\nLa direzione " + this.direzioneBloccata + " è bloccata se non hai con te "+ this.passepartout);
			return stampa.toString();
		}
		return this.toString();		 
	}
	

	
	
}
