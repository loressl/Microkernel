package products;

import interfaces.IDocumentSerializer;

public class ImageSerializer implements IDocumentSerializer{

	@Override
	public void load() {
		System.out.println("Documento de imagem carregado com sucesso!!");
	}

	@Override
	public void save() {
		System.out.println("Documento de imagem salvo com sucesso!!");
	}
}
