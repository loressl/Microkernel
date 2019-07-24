package backendloginandpasswordcreator;

import interfaces.AutenticationBackEndCreator;
import interfaces.IAutenticationBackEnd;
import interfaces.IPlugin;

import products.BackEndLoginAndPassword;

public class BackEndLoginAndPasswordCreator extends AutenticationBackEndCreator implements IPlugin{

	public BackEndLoginAndPasswordCreator() {}
	
	@Override
	public boolean initialize() {
		return true;
	}

	@Override
	public IAutenticationBackEnd createBackEnd() {
		return new BackEndLoginAndPassword();
	}
	
}
