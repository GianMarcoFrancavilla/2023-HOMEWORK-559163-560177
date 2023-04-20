package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

	public class ComandoVai implements Comando {
		private String direzione;
		private IO io;

	@Override
	public void esegui(Partita partita) {
		io = new IOConsole();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione==null) {
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
		return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio("Stanza corrente: " + partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa: " + partita.getGiocatore().getBorsa().toString());
		
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;

	}
	
}
