package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String attrezzoSbloccante;
	private String direzioneBloccata;
	

	public StanzaBloccata(String nome,String attrezzoSbloccante, String direzioneBloccata) {
		super(nome);
		this.setAttrezzoSbloccante(attrezzoSbloccante);
		this.setDirezioneBloccata(direzioneBloccata);
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(this.attrezzoSbloccante) && this.direzioneBloccata==direzione) {
			return this;
		}
		else {
			return stanzeAdiacenti.get(direzione);
		}
	}
	
	@Override
	public String getDescrizione() {
		
		return this.toString() + "\nL'attrezzo bloccante è: " + this.attrezzoSbloccante +
				"\nLa direzione bloccata è: " + this.direzioneBloccata;
	}
	
	public String getAttrezzoSbloccante() {
		return attrezzoSbloccante;
	}

	public void setAttrezzoSbloccante(String attrezzoSbloccante) {
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}
}
