package it.euris.ofp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Pence extends Currency {

	public Pence(Integer value) {
		super(value);
	}

}
