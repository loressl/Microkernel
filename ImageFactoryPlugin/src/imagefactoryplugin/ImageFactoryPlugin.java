package imagefactoryplugin;

import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
import interfaces.IPlugin;
import products.ImageEditor;
import products.ImageSerializer;
import products.ImageValidator;

public class ImageFactoryPlugin implements IPlugin, IDocumentFactory {

	private ImageFactoryPlugin() {}
	
	public static ImageFactoryPlugin getInstance() {
		if(instance == null)
			instance = new ImageFactoryPlugin();
		return instance;
	}
	
	@Override
	public boolean initialize() {
		return true;
	}

	@Override
	public IDocumentEditor getDocumentEditor() {
		return new ImageEditor();
	}

	@Override
	public IDocumentValidator getDocumentValidator() {
		return new ImageValidator();
	}

	@Override
	public IDocumentSerializer getDocumentSerializer() {
		return new ImageSerializer();
	}

	@Override
	public String getSupportedExtensions() {
		return "bitmap|bmp|tiff|jpeg|gif|png|jpg";
	}

	private static ImageFactoryPlugin instance = null;
}
