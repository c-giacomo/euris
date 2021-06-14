package it.euris.ofp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Price {
	protected @NonNull Pound pound;
	protected @NonNull Shillings shillings;
	protected @NonNull Pence pence;
	
	public Boolean valueIsNull() {
		return ( (pound == null) && (shillings == null) && (pence == null) );
	}
	
	public Boolean valueIsNegative() {
		return ( (pound.getValue() < 0) || (shillings.getValue() < 0) && (pence.getValue() < 0) );
	}
}
