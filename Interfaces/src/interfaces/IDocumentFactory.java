package interfaces;

public interface IDocumentFactory {
    public IDocumentEditor getDocumentEditor();
    public IDocumentValidator getDocumentValidator();
    public IDocumentSerializer getDocumentSerializer();
    public String getSupportedExtensions();
}