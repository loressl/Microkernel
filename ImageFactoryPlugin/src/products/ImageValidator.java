package products;

import interfaces.IDocumentValidator;

public class ImageValidator implements IDocumentValidator{

	@Override
	public void validate() {
		System.out.println("Valida��o de imagem realizada com sucesso!!");
	}
}
