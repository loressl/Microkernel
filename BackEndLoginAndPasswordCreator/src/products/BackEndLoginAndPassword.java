package products;

import interfaces.IAutenticationBackEnd;

public class BackEndLoginAndPassword implements IAutenticationBackEnd{

	@Override
	public void messageAutentication() {
		System.out.println("Autentica��o de login e senha criada com sucesso!");	
	}

}
