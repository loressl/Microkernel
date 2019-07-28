package products;

import java.io.File;

import adapter.TextDocumentAdapter;
import interfaces.IDocumentAdapter;
import interfaces.IDocumentEditor;

public class TextEditor implements IDocumentEditor{
	
	public TextEditor() {
		this.documentAdapter = new TextDocumentAdapter();
	}
	
	@Override
	public void open(String typeExtension, File file) {
		documentAdapter.setAdaptee(typeExtension);
		documentAdapter.openDocument(file);
		System.out.println("Editor de texto aberto com sucesso!!");
	}

	private IDocumentAdapter documentAdapter;
}
