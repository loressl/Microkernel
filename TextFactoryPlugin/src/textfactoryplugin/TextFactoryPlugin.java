package textfactoryplugin;

import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
import interfaces.IPlugin;
import products.TextEditor;
import products.TextSerializer;
import products.TextValidator;

public class TextFactoryPlugin implements IPlugin, IDocumentFactory {

	private TextFactoryPlugin() {}

	public static TextFactoryPlugin getInstance() {
		if(instance == null)
			instance = new TextFactoryPlugin();
		return instance;
	}
	
	@Override
	public boolean initialize() {
		return true;
	}

	@Override
	public IDocumentEditor getDocumentEditor() {
		return new TextEditor();
	}

	@Override
	public IDocumentValidator getDocumentValidator() {
		return new TextValidator();
	}

	@Override
	public IDocumentSerializer getDocumentSerializer() {
		return new TextSerializer();
	}

	@Override
	public String getSupportedExtensions() {
		return "txt|xml|pdf|doc|docx";
	}
	
	private static TextFactoryPlugin instance = null;
}
