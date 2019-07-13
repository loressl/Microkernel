package interfaces;

public abstract class AutenticationBackEndCreator {
	
	public abstract IAutenticationBackEnd createBackEnd();
	
	public void anOperation() {
		this.autenticationBackEnd = createBackEnd();
		this.autenticationBackEnd.messageAutentication();
	}
	
	private IAutenticationBackEnd autenticationBackEnd;
}
