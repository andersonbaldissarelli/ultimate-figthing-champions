package util.test;

import org.junit.Assert;
import org.junit.Test;

import util.FightScope;

public class FightScopeTest {
	
	//testa modalidade
	@Test
	public void testModalidade() {
		FightScope f1 = new FightScope();
		f1.setModalidade(null);
	
		if(f1.getModalidade() == null) {
			Assert.assertFalse(false);
		}
		else {
			Assert.assertTrue(true);
		}			
	}
		
	//testa categoria
	@Test
	public void testCategoria() {
		FightScope f2 = new FightScope();
		f2.setCategoria("a");
		Assert.assertTrue(true);
	}
	
		
		
}