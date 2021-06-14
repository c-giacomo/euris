package it.euris.ofp.shared;

import it.euris.ofp.constants.ConversionFactor;
import it.euris.ofp.core.Operations;
import it.euris.ofp.core.Scale;
import it.euris.ofp.exception.NegativeOperandInsertion;
import it.euris.ofp.model.Pence;
import it.euris.ofp.model.Pound;
import it.euris.ofp.model.Price;
import it.euris.ofp.model.Shillings;
import lombok.SneakyThrows;

public class OperationsImpl implements Operations<Result, Price, Integer>, Scale {

	@Override
	@SneakyThrows
	public Result sum(Price p1, Price p2) {
		if (p1.valueIsNegative() || p2.valueIsNegative()) throw new NegativeOperandInsertion("Valori non consentiti in input");
		Integer pound = p1.getPound().getValue() + p2.getPound().getValue();
		Integer shillings = p1.getShillings().getValue() + p2.getShillings().getValue();
		Integer pence = p1.getPence().getValue() + p2.getPence().getValue();
		
		Price price = scaleUp(pound, shillings, pence);
		return new Result(price);
	}

	@Override
	@SneakyThrows
	public Result multiplication(Price p1, Integer factor) {
		if (p1.valueIsNegative() || factor < 0) throw new NegativeOperandInsertion("Valori non consentiti in input"); 
		Integer pound = p1.getPound().getValue() * factor;
		Integer shillings = p1.getShillings().getValue() * factor;
		Integer pence = p1.getPence().getValue() * factor;
		
		Price price = scaleUp(pound, shillings, pence);
		return new Result(price);
	}

	@Override
	@SneakyThrows
	public Result substraction(Price p1, Price p2) {
		if (p1.valueIsNegative() || p2.valueIsNegative()) throw new NegativeOperandInsertion("Valori non consentiti in input");
		Integer pound = p1.getPound().getValue() - p2.getPound().getValue();
		Integer shillings = p1.getShillings().getValue() - p2.getShillings().getValue();
		Integer pence = p1.getPence().getValue() - p2.getPence().getValue();
		
		Price price = scaleDown(pound, shillings, pence);
		return new Result(price);
	}

	@Override
	@SneakyThrows
	public Result division(Price p1, Integer factor) {
		if (p1.valueIsNegative() || factor < 0) throw new NegativeOperandInsertion("Valori non consentiti in input"); 
		Integer pound = p1.getPound().getValue() / factor;
		Integer temp = (p1.getPound().getValue() % factor) * ConversionFactor.SHILLING;
		
		Integer shillingsAmount = p1.getShillings().getValue() + temp;
		Integer shillings = shillingsAmount / factor;
		
		if (shillings == 0)
			temp += (shillingsAmount % factor) * ConversionFactor.PENCE;
		else
			temp = (shillingsAmount % factor) * ConversionFactor.PENCE;
		
		Integer penceAmount = p1.getPence().getValue() + temp;
		Integer pence = penceAmount / factor;
		
		if (pence == 0)
			temp = penceAmount;
		else
			temp = penceAmount % factor;
		
		Price resultPrice = new Price(new Pound(pound), new Shillings(shillings), new Pence(pence));
		Price rest = scaleRest(temp);
		return new Result(resultPrice, rest);
	}

	

}
