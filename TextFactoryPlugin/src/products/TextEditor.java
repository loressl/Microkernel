package products;

import interfaces.IDocumentEditor;

public class TextEditor implements IDocumentEditor{

	@Override
	public void open() {
		System.out.println("Editor de texto aberto com sucesso!!");
	}
}
