package tests.lab3;

import org.junit.Test;

import lab3.Contato;

public class ContatoTest {
	
	@Test(expected = IllegalArgumentException.class)
	
	public void testNomeNull() {
		Contato contato = new Contato(null, "Gaudêncio", "999-000");
		
	}
	

}
