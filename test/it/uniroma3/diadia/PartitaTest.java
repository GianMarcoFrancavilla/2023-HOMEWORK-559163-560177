package it.uniroma3.diadia;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;


/**
 * Test della classe Partita
 */
public class PartitaTest {
	private Partita partita;
	private Labirinto labirinto;

	
	
	@Before
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne") 
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca") 
				.addAdiacenza("LabCampusOne","Biblioteca","nord") 
				.getLabirinto();
		partita = new Partita(labirinto);
		
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