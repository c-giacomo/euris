package it.euris.ofp.exception;

public class NegativeOperandInsertion extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NegativeOperandInsertion(String errorMessage) {
        super(errorMessage);
    }

}
