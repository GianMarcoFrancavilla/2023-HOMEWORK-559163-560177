package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test della classe Giocatore
 */

public class GiocatoreTest {

	private Giocatore giocatore;

	
	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore();
	}

	/**
	 *  Controlla se la borsa viene creata
	 */
	@Test
	public void testGetBorsa() {
		assertNotNull(this.giocatore.getBorsa());
	}
	
	/**
	 *  Controlla se i CFU sono impostati correttamente e quindi se la partita è iniziata
	 */
	@Test
	public void testGetCFU() {
		assertEquals(this.giocatore.toString(), 20, this.giocatore.getCfu());
	}
	
	/**
	 *  Controlla se i CFU sono impostati correttamente e quindi se la partita è iniziata
	 */
	@Test
	public void testSetCFU() {
		this.giocatore.setCfu(25);
		assertEquals(this.giocatore.toString(),25,this.giocatore.getCfu());
	}

}