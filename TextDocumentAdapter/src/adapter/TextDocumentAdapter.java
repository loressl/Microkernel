package adapter;

import java.io.File;

import adaptee.PdfFile;
import interfaces.IDocumentAdaptee;
import interfaces.IDocumentAdapter;

public class TextDocumentAdapter implements IDocumentAdapter{

	@Override
	public void setAdaptee(String typeExtension) {
		if(typeExtension.equalsIgnoreCase("Pdf"))
			documentAdaptee = new PdfFile();
	}
	
	@Override
	public void openDocument(File file) {
		if(documentAdaptee != null)
			documentAdaptee.openTypeFile(file);
	}
	
	private IDocumentAdaptee documentAdaptee;
}
