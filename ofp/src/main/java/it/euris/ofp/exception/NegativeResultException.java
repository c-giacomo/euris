package it.euris.ofp.exception;

public class NegativeResultException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NegativeResultException(String errorMessage) {
        super(errorMessage);
    }

}
