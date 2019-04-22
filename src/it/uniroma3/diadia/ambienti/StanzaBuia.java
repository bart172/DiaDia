package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	
	private String oggettoChiave;
	
	public StanzaBuia(String nome, String oggettoChiave) {
        super(nome);
        this.oggettoChiave = oggettoChiave;
	}
	
	@Override
	public String getDescrizione() {
		if (super.hasAttrezzo(this.oggettoChiave)) {
			return super.toString();
		} else {
			return "Quì c'è buio pesto! Se solo avessi un " + this.oggettoChiave + "...";
		}
	}
		
}
