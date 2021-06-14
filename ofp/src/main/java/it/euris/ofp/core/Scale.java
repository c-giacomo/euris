package it.euris.ofp.core;

import it.euris.ofp.constants.ConversionFactor;
import it.euris.ofp.exception.NegativeResultException;
import it.euris.ofp.model.Pence;
import it.euris.ofp.model.Pound;
import it.euris.ofp.model.Price;
import it.euris.ofp.model.Shillings;
import lombok.SneakyThrows;

public interface Scale {
	
	default Price scaleUp(Integer pound, Integer shillings, Integer pence) {
		if (pence >= ConversionFactor.PENCE) {
			shillings += pence / ConversionFactor.PENCE;
			pence = pence % ConversionFactor.PENCE;
		}
		if (shillings >= ConversionFactor.SHILLING) {
			pound += shillings / ConversionFactor.SHILLING;
			shillings = shillings % ConversionFactor.SHILLING;
		}
		return new Price(new Pound(pound), new Shillings(shillings), new Pence(pence));
	}
	
	@SneakyThrows
	default Price scaleDown(Integer pound, Integer shillings, Integer pence) {
		if (pence < 0) {
			pence += ConversionFactor.PENCE;
			shillings--;
		}
		if (shillings < 0) {
			shillings += ConversionFactor.SHILLING;
			pound--;
		}
		if (pound < 0 || shillings < 0 || pence < 0 ) throw new NegativeResultException("Il risultato è negativo");
		return new Price(new Pound(pound), new Shillings(shillings), new Pence(pence));
	}
	
	@SneakyThrows
	default Price scaleRest(Integer restAmount) {
		Integer pence, shillings, pound = 0;
		if (restAmount == 0) return new Price();
		if (restAmount < 0) throw new NegativeResultException("Il resto è negativo");
		
		pence = restAmount % ConversionFactor.PENCE;
		shillings = restAmount / ConversionFactor.PENCE;
		
		if (shillings > ConversionFactor.SHILLING) {
			Integer temp = shillings;
			shillings = shillings / ConversionFactor.SHILLING;
			pound = temp % ConversionFactor.SHILLING;
		}
		
		return new Price(new Pound(pound), new Shillings(shillings), new Pence(pence));
	}

}
