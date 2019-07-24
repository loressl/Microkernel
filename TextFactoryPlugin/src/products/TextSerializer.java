package products;

import interfaces.IDocumentSerializer;

public class TextSerializer implements IDocumentSerializer{

	@Override
	public void load() {
		System.out.println("Documento de texto carregado com sucesso!!");
	}

	@Override
	public void save() {
		System.out.println("Documento de texto salvo com sucesso!!");
	}
}
