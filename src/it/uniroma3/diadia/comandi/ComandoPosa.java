package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io=new IOConsole();
		if(nomeAttrezzo!=null) {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				Attrezzo a = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);	
				io.mostraMessaggio(nomeAttrezzo +" e' stato posato nella stanza corrente.");
				io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			}else {
				io.mostraMessaggio("L'attrezzo "+ nomeAttrezzo + " non si trova nella borsa!");
			}
		}else {
			io.mostraMessaggio("Specificare il nome dell'attrezzo che vuoi rimuovere!");
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

}
