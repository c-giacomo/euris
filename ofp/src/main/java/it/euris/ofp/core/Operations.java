package it.euris.ofp.core;

import it.euris.ofp.exception.NegativeResultException;

public interface Operations<T, P, V> {
	
	public T sum(P p1, P p2);
	public T multiplication(P p1, V v);
	public T substraction(P p1, P p2) throws NegativeResultException;
	public T division(P p1, V v);
}
