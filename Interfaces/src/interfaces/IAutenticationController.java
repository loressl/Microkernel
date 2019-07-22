package interfaces;

public interface IAutenticationController {
	public boolean initialize();
	public void setAutenticationBackCreator(AutenticationBackEndCreator autenticationBackEndCreator);
}
