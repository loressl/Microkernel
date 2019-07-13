package backendloginandpasswordcreator;

import interfaces.AutenticationBackEndCreator;
import interfaces.IAutenticationBackEnd;
import interfaces.ICore;
import interfaces.IPlugin;

import products.BackEndLoginAndPassword;

public class BackEndLoginAndPasswordCreator extends AutenticationBackEndCreator implements IPlugin{

	@Override
	public boolean initialize(ICore core) {
		return true;
	}

	@Override
	public IAutenticationBackEnd createBackEnd() {
		return new BackEndLoginAndPassword();
	}
	
}
