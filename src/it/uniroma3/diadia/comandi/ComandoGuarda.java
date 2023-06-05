package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoGuarda extends AbstractComando {
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io=new IOConsole();
		
		
		StringBuilder risultato = new StringBuilder();
		risultato.append(partita.getLabirinto().getStanzaCorrente().getNome());
		risultato.append("\nUscite: ");
		for (String direzione : partita.getLabirinto().getStanzaCorrente().getDirezioni())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : partita.getLabirinto().getStanzaCorrente().getAttrezzi()) {
			if(attrezzo!=null)
				risultato.append(attrezzo.toString()+" ");
		}
		io.mostraMessaggio(risultato);
	}


}
