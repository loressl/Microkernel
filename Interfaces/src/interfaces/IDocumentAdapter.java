package interfaces;

import java.io.File;

public interface IDocumentAdapter {
	public void setAdaptee(String typeExtension);
	public void openDocument(File file);
}
