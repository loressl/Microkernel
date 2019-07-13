package interfaces;

public interface ICore {
    public IUIController getUIController();
    public IPluginController getPluginController();
    public IAutenticationController getAutenticationController();
}
