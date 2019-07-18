package textfactoryplugin;

import interfaces.ICore;
import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
import interfaces.IPlugin;

import products.TextEditor;
import products.TextSerializer;
import products.TextValidator;

public class TextFactoryPlugin implements IPlugin, IDocumentFactory {

    @Override
    public boolean initialize(ICore core) {
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
    
}
