package it.euris.ofp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Shillings extends Currency {

	public Shillings(Integer value) {
		super(value);
	}

}
