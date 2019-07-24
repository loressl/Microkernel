package products;

import interfaces.IDocumentValidator;

public class TextValidator implements IDocumentValidator{

	@Override
	public void validate() {
		System.out.println("Valida��o de texto realizada com sucesso!!");
	}
}
