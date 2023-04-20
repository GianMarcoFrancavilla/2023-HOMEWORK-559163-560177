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


public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Stanza stanzaCorrente;
	private ComandoPrendi comando;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Attrezzo attrezzoPesante;
	private Attrezzo attrezzoProva;
	private Attrezzo attrezzo2;
	
	@Before
	public void setUp() {
		comando = new ComandoPrendi();
		partita = new Partita();
		attrezzo = new Attrezzo("osso",1);
		attrezzo2 = new Attrezzo ("chiave",1);
		attrezzoPesante = new Attrezzo("macchina",20);
		attrezzoProva = new Attrezzo ("piuma",0);
		stanzaCorrente = new Stanza("N11");
		stanzaCorrente.addAttrezzo(attrezzo);
		stanzaCorrente.addAttrezzo(attrezzoPesante);
		stanzaCorrente.addAttrezzo(attrezzo2);
		labirinto = new Labirinto();
		giocatore = new Giocatore();
		labirinto.setStanzaCorrente(stanzaCorrente);
		partita.setLabirinto(labirinto);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		partita.setGiocatore(giocatore);
		
		
	}
	
	@Test
	public void testAttrezzoAssenteInBorsa() {
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	public void testAttrezzoPresenteInBorsa() {
		comando.setParametro("osso");
		comando.esegui(partita);
		assertTrue(this.giocatore.getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	public void testAttrezzoPresenteInStanza() {
		assertTrue(this.stanzaCorrente.hasAttrezzo("osso"));
	}
	
	@Test 
	public void testAttrezzoAssenteInStanza() {
		comando.setParametro("osso");
		comando.esegui(partita);
		assertFalse(this.stanzaCorrente.hasAttrezzo("osso"));
	}
	
	@Test
	public void testAttrezzoTroppoPesante() {
		comando.setParametro("macchina");
		comando.esegui(partita);
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("macchina"));
		assertTrue(this.stanzaCorrente.hasAttrezzo("macchina"));
	}
	
	@Test
	public void testBorsaPiena() {
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		this.giocatore.getBorsa().addAttrezzo(attrezzoProva);
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("chiave"));
		assertTrue(this.stanzaCorrente.hasAttrezzo("chiave"));
	}
}
