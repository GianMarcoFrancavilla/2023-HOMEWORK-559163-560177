package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {
	private Partita partita;
	private Stanza stanzaCorrente;
	private Attrezzo attrezzo;
	private ComandoPosa comando;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Borsa borsa;
	

	@Before
	public void setUp() throws Exception {
		comando = new ComandoPosa();
		giocatore = new Giocatore();
		labirinto = new Labirinto();
		partita = new Partita(labirinto);
		borsa = new Borsa();
		attrezzo = new Attrezzo("patata", 1);
		stanzaCorrente = new Stanza("N11");
		
		giocatore.setBorsa(borsa);
		giocatore.getBorsa().addAttrezzo(attrezzo);
		
		labirinto.setStanzaCorrente(stanzaCorrente);
		partita.setLabirinto(labirinto);
		partita.setGiocatore(giocatore);
		
	}

	
	@Test
	public void testPosa() {
		comando.setParametro("patata");
		comando.esegui(partita);
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("patata"));
		
	}
	
	@Test
	public void testPresenteInStanza() {
		comando.setParametro("patata");
		comando.esegui(partita);
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("patata"));
		assertTrue(this.stanzaCorrente.hasAttrezzo("patata"));
		
	}
	
//	@Test
//	public void testNonPosa() {
//		assertTrue(this.giocatore.getBorsa().hasAttrezzo("patata"));
//		assertFalse(this.stanzaCorrente.hasAttrezzo("patata"));
//	}

	
	
}
