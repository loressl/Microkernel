package interfaces;

public interface IAutenticationController {
	public boolean initialize(ICore core);
	public void setAutenticationBackCreator(AutenticationBackEndCreator autenticationBackEndCreator);
}
