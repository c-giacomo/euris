package it.euris.ofp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.euris.ofp.core.Operations;
import it.euris.ofp.exception.NegativeResultException;
import it.euris.ofp.model.Pence;
import it.euris.ofp.model.Pound;
import it.euris.ofp.model.Price;
import it.euris.ofp.model.Shillings;
import it.euris.ofp.shared.OperationsImpl;
import it.euris.ofp.shared.Result;


public class AppTest {
	Operations<Result, Price, Integer> operations;
	
	@Test
    public void sumTest() {
    	operations = new OperationsImpl();
    	Price p1 = new Price(new Pound(19), new Shillings(8), new Pence(10));
    	Price p2 = new Price(new Pound(21), new Shillings(17), new Pence(8));
    	Result res = operations.sum(p1, p2);
    	assertTrue( (res.getPrice().getPound().getValue() == 41
    			&& res.getPrice().getShillings().getValue() == 6
    			&& res.getPrice().getPence().getValue() == 6) );
    	
    	p1 = new Price(new Pound(11), new Shillings(3), new Pence(5));
    	p2 = new Price(new Pound(22), new Shillings(7), new Pence(3));
    	res = operations.sum(p1, p2);
    	assertTrue( (res.getPrice().getPound().getValue() == 33
    			&& res.getPrice().getShillings().getValue() == 10
    			&& res.getPrice().getPence().getValue() == 8) );
    	
    	p1 = new Price(new Pound(20), new Shillings(18), new Pence(7));
    	p2 = new Price(new Pound(42), new Shillings(14), new Pence(6));
    	res = operations.sum(p1, p2);
    	assertTrue( (res.getPrice().getPound().getValue() == 63
    			&& res.getPrice().getShillings().getValue() == 13
    			&& res.getPrice().getPence().getValue() == 1) );
    	
    	p1 = new Price(new Pound(14), new Shillings(4), new Pence(6));
    	p2 = new Price(new Pound(38), new Shillings(5), new Pence(11));
    	res = operations.sum(p1, p2);
    	assertTrue( (res.getPrice().getPound().getValue() == 52
    			&& res.getPrice().getShillings().getValue() == 10
    			&& res.getPrice().getPence().getValue() == 5) );
    	
    	p1 = new Price(new Pound(15), new Shillings(3), new Pence(4));
    	p2 = new Price(new Pound(50), new Shillings(1), new Pence(4));
    	res = operations.sum(p1, p2);
    	assertTrue( (res.getPrice().getPound().getValue() == 65
    			&& res.getPrice().getShillings().getValue() == 4
    			&& res.getPrice().getPence().getValue() == 8) );
    	
    	p1 = new Price(new Pound(6), new Shillings(13), new Pence(8));
    	p2 = new Price(new Pound(37), new Shillings(9), new Pence(7));
    	res = operations.sum(p1, p2);
    	assertTrue( (res.getPrice().getPound().getValue() == 44
    			&& res.getPrice().getShillings().getValue() == 3
    			&& res.getPrice().getPence().getValue() == 3) );
    	
    	p1 = new Price(new Pound(9), new Shillings(5), new Pence(11));
    	p2 = new Price(new Pound(3), new Shillings(5), new Pence(7));
    	res = operations.sum(p1, p2);
    	assertTrue( (res.getPrice().getPound().getValue() == 12
    			&& res.getPrice().getShillings().getValue() == 11
    			&& res.getPrice().getPence().getValue() == 6) );
    	
    	p1 = new Price(new Pound(0), new Shillings(14), new Pence(9));
    	p2 = new Price(new Pound(2), new Shillings(6), new Pence(3));
    	res = operations.sum(p1, p2);
    	assertTrue( (res.getPrice().getPound().getValue() == 3
    			&& res.getPrice().getShillings().getValue() == 1
    			&& res.getPrice().getPence().getValue() == 0) );
    	
    }
	
	@Test
	@SuppressWarnings("unused")
	public void subTest() {
		operations = new OperationsImpl();
    	Price p1 = new Price(new Pound(23), new Shillings(8), new Pence(10));
    	Price p2 = new Price(new Pound(21), new Shillings(17), new Pence(8));
    	try {
    		Result res = operations.substraction(p1, p2);
    		assertTrue( (res.getPrice().getPound().getValue() == 1
    			&& res.getPrice().getShillings().getValue() == 11
    			&& res.getPrice().getPence().getValue() == 2) );
    	} catch (NegativeResultException e) {
    		
    	}
    	
    	p1 = new Price(new Pound(24), new Shillings(3), new Pence(5));
    	p2 = new Price(new Pound(22), new Shillings(7), new Pence(3));
    	try {
    		Result res = operations.substraction(p1, p2);
    		assertTrue( (res.getPrice().getPound().getValue() == 1
    			&& res.getPrice().getShillings().getValue() == 16
    			&& res.getPrice().getPence().getValue() == 2) );
    	} catch (NegativeResultException e) {
    		
    	}
    	
    	p1 = new Price(new Pound(20), new Shillings(18), new Pence(7));
    	p2 = new Price(new Pound(42), new Shillings(14), new Pence(6));
    	try {
    		Result res = operations.substraction(p1, p2);
    	} catch (NegativeResultException e) {
    		assertTrue(true);
    	}
    	
    	p1 = new Price(new Pound(39), new Shillings(4), new Pence(6));
    	p2 = new Price(new Pound(38), new Shillings(5), new Pence(11));
    	try {
    		Result res = operations.substraction(p1, p2);
    		assertTrue( (res.getPrice().getPound().getValue() == 0
    			&& res.getPrice().getShillings().getValue() == 18
    			&& res.getPrice().getPence().getValue() == 7) );
    	} catch (NegativeResultException e) {
    		
    	}
    	
    	p1 = new Price(new Pound(37), new Shillings(13), new Pence(8));
    	p2 = new Price(new Pound(37), new Shillings(9), new Pence(7));
    	try {
    		Result res = operations.substraction(p1, p2);
    		assertTrue( (res.getPrice().getPound().getValue() == 0
    			&& res.getPrice().getShillings().getValue() == 4
    			&& res.getPrice().getPence().getValue() == 1) );
    	} catch (NegativeResultException e) {
  
    	}
    	
    	p1 = new Price(new Pound(0), new Shillings(0), new Pence(2));
    	p2 = new Price(new Pound(0), new Shillings(0), new Pence(3));
    	try {
    		Result res = operations.substraction(p1, p2);
    	} catch (NegativeResultException e) {
    		assertTrue(true);
    	}
    	
	}
	
	@Test
	public void multiplicationsTest() {
		operations = new OperationsImpl();
    	Price p1 = new Price(new Pound(5), new Shillings(17), new Pence(8));
    	Result res = operations.multiplication(p1, 2);
    	assertTrue( (res.getPrice().getPound().getValue() == 11
    		&& res.getPrice().getShillings().getValue() == 15
    		&& res.getPrice().getPence().getValue() == 4) );
    	
    	p1 = new Price(new Pound(23), new Shillings(8), new Pence(10));
    	res = operations.multiplication(p1, 4);
    	assertTrue( (res.getPrice().getPound().getValue() == 93
    		&& res.getPrice().getShillings().getValue() == 15
    		&& res.getPrice().getPence().getValue() == 4) );
    	
    	p1 = new Price(new Pound(23), new Shillings(8), new Pence(10));
    	res = operations.multiplication(p1, 4);
    	assertTrue( (res.getPrice().getPound().getValue() == 93
    		&& res.getPrice().getShillings().getValue() == 15
    		&& res.getPrice().getPence().getValue() == 4) );
    	
    	p1 = new Price(new Pound(7), new Shillings(3), new Pence(5));
    	res = operations.multiplication(p1, 4);
    	assertTrue( (res.getPrice().getPound().getValue() == 28
    		&& res.getPrice().getShillings().getValue() == 13
    		&& res.getPrice().getPence().getValue() == 8) );
    	
    	p1 = new Price(new Pound(11), new Shillings(18), new Pence(7));
    	res = operations.multiplication(p1, 4);
    	assertTrue( (res.getPrice().getPound().getValue() == 47
    		&& res.getPrice().getShillings().getValue() == 14
    		&& res.getPrice().getPence().getValue() == 4) );
    	
    	p1 = new Price(new Pound(5), new Shillings(4), new Pence(6));
    	res = operations.multiplication(p1, 4);
    	assertTrue( (res.getPrice().getPound().getValue() == 20
    		&& res.getPrice().getShillings().getValue() == 18
    		&& res.getPrice().getPence().getValue() == 0) );
    	
    	p1 = new Price(new Pound(8), new Shillings(13), new Pence(8));
    	res = operations.multiplication(p1, 4);
    	assertTrue( (res.getPrice().getPound().getValue() == 34
    		&& res.getPrice().getShillings().getValue() == 14
    		&& res.getPrice().getPence().getValue() == 8) );
	}
	
	@Test
	public void divisionTest() {
		operations = new OperationsImpl();
    	Price p1 = new Price(new Pound(5), new Shillings(17), new Pence(8));
    	Result res = operations.division(p1, 3);
    	assertTrue( (res.getPrice().getPound().getValue() == 1
    		&& res.getPrice().getShillings().getValue() == 19
    		&& res.getPrice().getPence().getValue() == 2) 
    		&& (res.getRest().getPound() == null || res.getRest().getPound().getValue() == 0)
    		&& (res.getRest().getShillings() == null || res.getRest().getShillings().getValue() == 0)
    		&& res.getRest().getPence().getValue() == 2);
    	
    	p1 = new Price(new Pound(18), new Shillings(16), new Pence(1));
    	res = operations.division(p1, 15);
    	assertTrue( (res.getPrice().getPound().getValue() == 1
    		&& res.getPrice().getShillings().getValue() == 5
    		&& res.getPrice().getPence().getValue() == 0) 
    		&& (res.getRest().getPound() == null || res.getRest().getPound().getValue() == 0)
    		&& (res.getRest().getShillings() != null && res.getRest().getShillings().getValue() == 1)
    		&& res.getRest().getPence().getValue() == 1);
    	
    	p1 = new Price(new Pound(6), new Shillings(10), new Pence(11));
    	res = operations.division(p1, 3);
    	assertTrue( (res.getPrice().getPound().getValue() == 2
    		&& res.getPrice().getShillings().getValue() == 3
    		&& res.getPrice().getPence().getValue() == 7) 
    		&& (res.getRest().getPound() == null || res.getRest().getPound().getValue() == 0)
    		&& (res.getRest().getShillings() == null || res.getRest().getShillings().getValue() == 0)
    		&& res.getRest().getPence().getValue() == 2);
    	
    	p1 = new Price(new Pound(1), new Shillings(5), new Pence(10));
    	res = operations.division(p1, 3);
    	assertTrue( (res.getPrice().getPound().getValue() == 0
    		&& res.getPrice().getShillings().getValue() == 8
    		&& res.getPrice().getPence().getValue() == 7) 
    		&& (res.getRest().getPound() == null || res.getRest().getPound().getValue() == 0)
    		&& (res.getRest().getShillings() == null || res.getRest().getShillings().getValue() == 0)
    		&& res.getRest().getPence().getValue() == 1);
    	
    	p1 = new Price(new Pound(8), new Shillings(4), new Pence(11));
    	res = operations.division(p1, 5);
    	assertTrue( (res.getPrice().getPound().getValue() == 1
    		&& res.getPrice().getShillings().getValue() == 12
    		&& res.getPrice().getPence().getValue() == 11) 
    		&& (res.getRest().getPound() == null || res.getRest().getPound().getValue() == 0)
    		&& (res.getRest().getShillings() == null || res.getRest().getShillings().getValue() == 0)
    		&& res.getRest().getPence().getValue() == 4);
	}
    
}
