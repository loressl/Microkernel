package products;

import interfaces.IDocumentEditor;

public class ImageEditor implements IDocumentEditor{

	@Override
	public void open() {
		System.out.println("Editor de imagem aberto com sucesso!!");	
	}
}
