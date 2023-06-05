package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	public StanzaBuia(String nome) {
		super(nome);
	}
	
	@Override
	public String getDescrizione() {
		String s = this.toString();
		if(!this.hasAttrezzo("lanterna")) {
			s=s+"qui c'è buio pesto";
		}
		return s;
	}
}
