package application;

import java.io.File;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import interfaces.AutenticationBackEndCreator;
import interfaces.IAutenticationController;
import interfaces.ICore;

public class AutenticationController implements IAutenticationController {

	@Override
	public boolean initialize(ICore core) {

		try {
			File currentDir = new File("./autentication");
			String[] files = currentDir.list();
			URL[] xmls = new URL[files.length];
			for (int i = 0; i < files.length; i++) {
				try {
					xmls[i] = (new File("./autentication/" + files[i])).toURI().toURL();
				} catch (MalformedURLException ex) {
					Logger.getLogger(AutenticationController.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			String classeName = null;
			for (int i = 0; i < xmls.length; i++) {
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = builderFactory.newDocumentBuilder();
				Document documentAutentication = builder.parse(xmls[i].toString());
				classeName = documentAutentication.getDocumentElement().getTextContent().trim();
			}

			List<AutenticationBackEndCreator> autenticationCreators = core.getPluginController()
					.getLoadedPluginsByType(AutenticationBackEndCreator.class);
			verifyClass(classeName, autenticationCreators);
			this.autenticationBackEndCreator.anOperation();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void setAutenticationBackCreator(AutenticationBackEndCreator autenticationBackEndCreator) {
		this.autenticationBackEndCreator = autenticationBackEndCreator;
	}

	private void verifyClass(String classe, List<AutenticationBackEndCreator> autenticationCreators) {
		for (AutenticationBackEndCreator creator : autenticationCreators) {
			String namePackageClass = creator.getClass().getName();
			String nameClass = namePackageClass.substring(namePackageClass.lastIndexOf(".") + 1);
			if (nameClass.equals(classe)) {
				this.setAutenticationBackCreator(creator);
			}
		}
	}

	private AutenticationBackEndCreator autenticationBackEndCreator;
}
