package it.euris.ofp;

import it.euris.ofp.core.Operations;
import it.euris.ofp.exception.NegativeOperandInsertion;
import it.euris.ofp.exception.NegativeResultException;
import it.euris.ofp.model.Pence;
import it.euris.ofp.model.Pound;
import it.euris.ofp.model.Price;
import it.euris.ofp.model.Shillings;
import it.euris.ofp.shared.OperationsImpl;
import it.euris.ofp.shared.Result;

public class App {
	
    public static void main( String[] args ) {
    	try {
    		Operations<Result, Price, Integer> ops = new OperationsImpl();
    		Result res = null;
    		Price p1 = null;
    		Price p2 = null;
    		Integer factor = null;
    		
    		Integer pound1 = Integer.parseInt(args[0].replaceAll("p",""));
    		Integer shillings1 = Integer.parseInt(args[1].replaceAll("s",""));
    		Integer pence1 = Integer.parseInt(args[2].replaceAll("d",""));
    	
    		p1 = new Price(new Pound(pound1), new Shillings(shillings1), new Pence(pence1));
    		
    		String op = args[3];
    		if (!checkSymbol(op)) throw new Exception("L'operazione non è fra quelle consentite!");
    		
    		if (op.equals("+") || op.equals("-")) {
    			Integer pound2 = Integer.parseInt(args[4].replaceAll("p",""));
        		Integer shillings2 = Integer.parseInt(args[5].replaceAll("s",""));
        		Integer pence2 = Integer.parseInt(args[6].replaceAll("d",""));
        		p2 = new Price(new Pound(pound2), new Shillings(shillings2), new Pence(pence2));
    		} else {
    			factor = Integer.parseInt(args[4]);
    		}
    		
    		switch(op) {
    			case "+":
    				res = ops.sum(p1, p2);
    				break;
    			case "-":
    				res = ops.substraction(p1, p2);
    				break;
    			case "*":
    				res = ops.multiplication(p1, factor);
    				break;
    			case "/":
    				res = ops.division(p1, factor);
    				break;
    			default:
    		}
    		
    		System.out.println(res.toString());
    	
    	} catch (NumberFormatException nfe) {
    		System.out.println(nfe.getMessage());
    	} catch (NegativeResultException nre) {
    		System.out.println(nre.getMessage());
    	} catch (NegativeOperandInsertion noi) {
    		System.out.println(noi.getMessage());
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    }
    
    public static boolean checkSymbol(String op) {
    	if (op.equals("/") || op.equals("*") || op.equals("+") || op.equals("-")) return true;
    	else return false;
    }
    
    
}
