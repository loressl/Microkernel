package application;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import interfaces.AutenticationBackEndCreator;
import interfaces.IAutenticationController;

public class AutenticationController implements IAutenticationController {

	@Override
	public boolean initialize() {
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
			List<AutenticationBackEndCreator> autenticationCreators = Core.getInstance().getPluginController()
					.getLoadedPluginsByType(AutenticationBackEndCreator.class);
			for (int i = 0; i < xmls.length; i++) {
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = builderFactory.newDocumentBuilder();
				Document documentAutentication = builder.parse(xmls[i].toString());
				classeName = documentAutentication.getDocumentElement().getTextContent().trim();
				if (verifyClass(classeName, autenticationCreators))
					break;
			}
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

	private boolean verifyClass(String classe, List<AutenticationBackEndCreator> autenticationCreators) {
		for (AutenticationBackEndCreator creator : autenticationCreators) {
			String namePackageClass = creator.getClass().getName();
			String nameClass = namePackageClass.substring(namePackageClass.lastIndexOf(".") + 1);
			if (nameClass.equals(classe)) {
				this.setAutenticationBackCreator(creator);
				return true;
			}
		}
		return false;
	}

	private AutenticationBackEndCreator autenticationBackEndCreator;
}
