package products;

import java.io.File;

import adapter.TextAdapter;
import interfaces.IDocumentAdapter;
import interfaces.IDocumentEditor;

public class TextEditor implements IDocumentEditor{
	
	public TextEditor() {
		this.documentAdapter = new TextAdapter();
	}
	
	@Override
	public void open(String typeExtension, File file) {
		documentAdapter.setAdaptee(typeExtension);
		documentAdapter.openDocument(file);
		System.out.println("Editor de texto aberto com sucesso!!");
	}

	private IDocumentAdapter documentAdapter;
}
