package products;

import interfaces.IAutenticationBackEnd;

public class BackEndLoginAndPassword implements IAutenticationBackEnd{

	@Override
	public void messageAutentication() {
		System.out.println("Autenticação de login e senha criada com sucesso!");	
	}

}
