package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {
	
	private Partita partita;
	private Attrezzo attrezzo;
	private Stanza stanzaCorrente;
	private ComandoPosa comando;
	private Labirinto labirinto;
	private Giocatore giocatore;

	@Before
	public void setUp() {
		comando = new ComandoPosa();
		partita = new Partita();
		attrezzo = new Attrezzo("osso",1);
		stanzaCorrente = new Stanza("N11");
		labirinto = new Labirinto();
		giocatore = new Giocatore();
		giocatore.getBorsa().addAttrezzo(attrezzo);
		labirinto.setStanzaCorrente(stanzaCorrente);
		partita.setLabirinto(labirinto);
		partita.setGiocatore(giocatore);
	}
	
	@Test
	public void testAttrezzoPresenteInBorsa() {
		assertTrue(this.giocatore.getBorsa().hasAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testAttrezzoPosato() {
		comando.setParametro(attrezzo.getNome());
		comando.esegui(partita);
		assertFalse(this.giocatore.getBorsa().hasAttrezzo(attrezzo.getNome()));
		assertTrue(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
		
	}
	
	

}
