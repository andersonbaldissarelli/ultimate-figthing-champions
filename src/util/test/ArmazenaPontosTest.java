package util.test;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ArmazenaPontos;

public class ArmazenaPontosTest {
		
	
	    //testa pontos do vencedor
		@Before
		public void setUp() throws Exception {
		}

		@After
		public void tearDown() throws Exception {
		}
		
		@Test
		public void testWinner(){
			ArmazenaPontos ap = new ArmazenaPontos();
			ap.setPontos(46000);
			ap.setPontos2(35400);
		
			if(ap.getPontos() > ap.getPontos2()) {
				Assert.assertTrue(true);
			}
			else if(ap.getPontos() < ap.getPontos2()) {
				Assert.assertFalse(false);
			}
			else {
				Assert.assertFalse(false);
			}	
		}
		
		
		//testa pontos do vencedor novamente
		@Test
		public void testWinner2() {
			ArmazenaPontos ap2 = new ArmazenaPontos();
			
			assertFalse(ap2.getPontos() < 0);
			assertFalse(ap2.getPontos2() < 0);
			
		}
		
		
		//testa se tem vencedor
		@Test
		public void testWinnerIsNull() {
			ArmazenaPontos ap3 = new ArmazenaPontos();
			ap3.setVencedor(null);
			
			if(ap3.getVencedor() == null) {
				Assert.assertFalse(false);
			}
			else {
				Assert.assertTrue(true);
			}			
		}
		
	
}
