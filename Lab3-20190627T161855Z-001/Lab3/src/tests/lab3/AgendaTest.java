package tests.lab3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;

import lab3.Agenda;

public class AgendaTest {
	
	Agenda novaAgenda;
	
	@Before
	public void criaAgenda() {
		novaAgenda = new Agenda();
	}
	
	
	@Test
	public void testCadastroCom1() {
		
		assertEquals("CADASTRO REALIZADO!", novaAgenda.cadastraContato(1, "Matheus" , "Gaudêncio" , "999-999"));
	}
	@Test
	public void testCadastroCom100() {
		assertEquals("CADASTRO REALIZADO!",  novaAgenda.cadastraContato(1, "Matheus" , "Gaudêncio" , "999-999"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastroCom101() {
		novaAgenda.cadastraContato(101, "Matheus", "Gaudêncio", "999-999");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastroCom0() {
		 novaAgenda.cadastraContato(0, "Matheus" , "Gaudêncio" , "999-999");	
	}
	
	@Test
	public void testCadastraPreenchida() {
		 novaAgenda.cadastraContato(1, "Matheus" , "Gaudêncio" , "999-999");
		 novaAgenda.cadastraContato(1, "Luis", "Morais", "444-444");
		 
		 assertEquals("Luis Morais - 444-444" , novaAgenda.exibirContato(1));
	}
	
	@Test
	public void testExibirContato() {
		
		 novaAgenda.cadastraContato(1, "Matheus" , "Gaudêncio" , "999-999");
		 
		 assertEquals("Matheus Gaudêncio - 999-999" , novaAgenda.exibirContato(1));
		
	}
	
	@Test
	public void testLista() {
		
		 novaAgenda.cadastraContato(1, "Matheus" , "Gaudêncio" , "999-999");
		 novaAgenda.cadastraContato(50, "Alex", "Carvalho", "888-888");
		 
		 String esperado = ("1 - Matheus Gaudêncio\n50 - Alex Carvalho\n");
		assertEquals(esperado, novaAgenda.listaContatos());
	}
	@Test
	public void testListaMais() {
		
		 novaAgenda.cadastraContato(1, "Matheus" , "Gaudêncio" , "999-999");
		 novaAgenda.cadastraContato(50, "Alex", "Carvalho", "888-888");
		 novaAgenda.cadastraContato(1, "Carlos", "Gaudêncio", "666-666");
		 
		 String esperado = ("1 - Carlos Gaudêncio\n50 - Alex Carvalho\n");
		 assertEquals(esperado, novaAgenda.listaContatos());
		 
		
		
	}
	 

}
