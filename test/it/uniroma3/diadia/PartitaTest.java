package it.uniroma3.diadia;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

/**
 * Test della classe Partita
 */
public class PartitaTest {
	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
	}
	
	/**
	 *  Controlla se la partita non è finita quando la partita è inizializzata;
	 */
	@Test
	public void testIsFinita_Iniziata() {
		assertFalse(this.partita.getLabirinto().getStanzaCorrente().toString(),this.partita.isFinita());
	}

	/**
	 *  Controlla se la partita è finita attraverso l'invocazione di setFinita();
	 */
	@Test
	public void testIsFinita_Forzata() {
		this.partita.setFinita();
		assertTrue(this.partita.getLabirinto().getStanzaCorrente().toString(),this.partita.isFinita());
	}
	
	/**
	 *  Controlla se la partita è finita attraverso lo spostamento nell astanza vincente
	 */
	@Test
	public void testIsFinita_SpostamentoVincente() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente("nord"));
		assertTrue(this.partita.getLabirinto().getStanzaCorrente().toString(),this.partita.isFinita());
	}
	
	/**
	 *  Controlla se la partita è finita attraverso il raggiungimento dei CFU a 0
	 */
	@Test
	public void testIsFinita_CFU() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.getLabirinto().getStanzaCorrente().toString(),this.partita.isFinita());
	}

	
}