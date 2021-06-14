package it.euris.ofp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Pound extends Currency {

	public Pound(Integer value) {
		super(value);
	}

}
