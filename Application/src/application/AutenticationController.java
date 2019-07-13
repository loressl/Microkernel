package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import interfaces.AutenticationBackEndCreator;
import interfaces.IAutenticationController;
import interfaces.ICore;


public class AutenticationController implements IAutenticationController{

	@Override
	public boolean initialize(ICore core) {
		String url= "C:\\Users\\maqui\\OneDrive\\Documentos\\ANÁLISE E DESENVOLVIMENTO DE SISTEMAS\\4º SEMESTRE\\PADROES\\trabalho 1\\AutenticationBackEndClass.txt";
		try {
			BufferedReader readFile= new BufferedReader(new FileReader(url));
			String lineOfFile= readFile.readLine();
			String classe = null;
			while(lineOfFile != null) {
				classe = lineOfFile.substring(lineOfFile.lastIndexOf("\\") + 1).split("\\.")[0];
				lineOfFile= readFile.readLine();
			}
			
			List<AutenticationBackEndCreator> autenticationCreators = core.getPluginController().getLoadedPluginsByType(AutenticationBackEndCreator.class);
			
			verifyClass(classe, autenticationCreators);
			this.autenticationBackEndCreator.anOperation();
			
			readFile.close();
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
		for(AutenticationBackEndCreator creator : autenticationCreators) {
			String namePackageClass= creator.getClass().getName();
			String nameClass= namePackageClass.substring(namePackageClass.lastIndexOf(".") + 1);
			if(nameClass.equals(classe)) {
				this.setAutenticationBackCreator(creator);
			}
		}
	}

	private AutenticationBackEndCreator autenticationBackEndCreator;
}
