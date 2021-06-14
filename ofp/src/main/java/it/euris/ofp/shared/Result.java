package it.euris.ofp.shared;

import it.euris.ofp.model.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Result {
	protected Price price;
	protected Price rest;
	
	public Result(Price price) {
		this.price = price;
	}
	
	public Result(Price price, Price rest) {
		this.price = price;
		this.rest = rest;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append(price.getPound().getValue())
											  .append("p ")
											  .append(price.getShillings().getValue())
											  .append("s ")
											  .append(price.getPence().getValue())
											  .append("d ");
		
		if (rest != null && !rest.valueIsNull()) {
			sb.append("(");
			if (rest.getPound().getValue() != null && rest.getPound().getValue() != 0)
				sb.append(rest.getPound().getValue()).append("p").append(", ");
			if (rest.getShillings().getValue() != null && rest.getShillings().getValue() != 0)
				sb.append(rest.getShillings().getValue()).append("s").append(", ");
			if (rest.getPence() != null && rest.getPence().getValue() != 0)
				sb.append(rest.getPence().getValue()).append("d");
			sb.append(")");
		}
		return sb.toString();
	}
}
