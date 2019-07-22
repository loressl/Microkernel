package products;

import interfaces.IDocumentValidator;

public class ImageValidator implements IDocumentValidator{

	@Override
	public void validate() {
		System.out.println("Validação de imagem realizada com sucesso!!");
	}

}
