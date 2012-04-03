package generator;

import model.BusinessRule;

public interface Generator {
	public String generateBR(BusinessRule br);

	public String getName();
}