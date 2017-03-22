package app;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class TesteContaMagica {

	private ContaMagica clienteFeliz;
	
	@Before
	public void setUp() { 
		clienteFeliz = new ContaMagica("Joao"); 
	}
	
	@Test
	public void testGetNomeIgualJoao() {
		assertTrue(clienteFeliz.getNomeCliente().equals("Joao"));
	}
	
	@Test
	public void testGetSaldoIgual2000(){
		BigDecimal deposito = new BigDecimal("2000.00");
		clienteFeliz.deposito(deposito);
		assertTrue(clienteFeliz.getSaldo().compareTo(deposito) == 0);
	}
	
	public void testGetMudancaSilverParaGold(){
		BigDecimal deposito = new BigDecimal("250000.00");
		clienteFeliz.deposito(deposito);
		assertTrue(clienteFeliz.getStatus() == Categorias.GOLD);
	}
}
